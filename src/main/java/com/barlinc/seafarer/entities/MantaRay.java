package com.barlinc.seafarer.entities;

import com.barlinc.seafarer.entities.ai.goal.AquaticLeapGoal;
import com.barlinc.seafarer.entities.pose.SeafarerPoses;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MantaRay extends WaterAnimal {

    public float prevOnLandProgress;
    public float onLandProgress;

    private int rollCooldown = this.random.nextInt(10 * 40) + (20 * 40);
    private int loopCooldown = this.random.nextInt(10 * 40) + (20 * 80);

    public final AnimationState flopAnimationState = new AnimationState();
    public final AnimationState swimmingAnimationState = new AnimationState();
    public final AnimationState roll1AnimationState = new AnimationState();
    public final AnimationState roll2AnimationState = new AnimationState();
    public final AnimationState loopingAnimationState = new AnimationState();

    public MantaRay(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 60, 2, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 2);
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.8F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 10));
        this.goalSelector.addGoal(2, new MantaRayLeapGoal(this));
        this.goalSelector.addGoal(3, new MantaRayRollingGoal(this));
        this.goalSelector.addGoal(4, new MantaRayLoopingGoal(this));
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
        return size.height * 0.5F;
    }

    @Override
    public void travel(Vec3 travelVec) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVec);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isInWater() && this.getPose() != SeafarerPoses.ROLLING.get() && rollCooldown > 0) rollCooldown--;
        if (this.isInWater() && this.getPose() != SeafarerPoses.LOOPING.get() && loopCooldown > 0) loopCooldown--;

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        this.flopAnimationState.animateWhen(!this.isInWaterOrBubble(), this.tickCount);
        this.swimmingAnimationState.animateWhen(this.isInWaterOrBubble(), this.tickCount);
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> entityDataAccessor) {
        if (DATA_POSE.equals(entityDataAccessor)) {
            if (this.getPose() == SeafarerPoses.ROLLING.get()) {
                this.swimmingAnimationState.stop();
                if (random.nextBoolean()) {
                    this.roll1AnimationState.start(this.tickCount);
                } else {
                    this.roll2AnimationState.start(this.tickCount);
                }
            }
            else if (this.getPose() == SeafarerPoses.LOOPING.get()) {
                this.swimmingAnimationState.stop();
                this.loopingAnimationState.start(this.tickCount);
            }
            else if (this.getPose() == Pose.STANDING) {
                this.roll1AnimationState.stop();
                this.roll2AnimationState.stop();
                this.loopingAnimationState.stop();
            }
        }
        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public void aiStep() {
        this.prevOnLandProgress = onLandProgress;
        boolean onLand = !this.isInWaterOrBubble() && this.onGround();
        if (onLand && onLandProgress < 10F) {
            onLandProgress++;
        }
        if (!onLand && onLandProgress > 0F) {
            onLandProgress--;
        }

        if (!isInWaterOrBubble() && this.isAlive()) {
            if (this.onGround() && random.nextFloat() < 0.05F) {
                this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.1F, 0.3D, (this.random.nextFloat() * 2.0F - 1.0F) * 0.1F));
                this.setYRot(this.random.nextFloat() * 360.0F);
                this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
            }
        }
        super.aiStep();
    }

    @Override
    @Nullable
    protected SoundEvent getAmbientSound() {
        return SoundEvents.TROPICAL_FISH_AMBIENT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    @Override
    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    @Nullable
    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    public static boolean canSpawn(EntityType<MantaRay> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int seaLevel = level.getSeaLevel();
        int spawnHeight = seaLevel - 13;
        return pos.getY() >= spawnHeight && pos.getY() <= seaLevel && level.getFluidState(pos.below()).is(FluidTags.WATER) && level.getBlockState(pos.above()).is(Blocks.WATER);
    }

    // goals
    static class MantaRayLeapGoal extends AquaticLeapGoal {

        private final MantaRay mantaRay;

        public MantaRayLeapGoal(MantaRay mantaRay) {
            super(mantaRay, 10);
            this.mantaRay = mantaRay;
        }

        @Override
        public void start() {
            Direction direction = mantaRay.getMotionDirection();
            mantaRay.setDeltaMovement(mantaRay.getDeltaMovement().add((double) direction.getStepX() * 1.25D, 0.9D, (double) direction.getStepZ() * 1.25D));
            mantaRay.getNavigation().stop();
        }
    }

    public static class MantaRayRollingGoal extends Goal {

        public MantaRay mantaRay;
        public int timer;

        public MantaRayRollingGoal(MantaRay mantaRay) {
            this.mantaRay = mantaRay;
        }

        @Override
        public boolean canUse() {
            return mantaRay.rollCooldown == 0 && mantaRay.getPose() == Pose.STANDING && mantaRay.isInWater();
        }

        @Override
        public void start() {
            this.timer = 80;
            this.mantaRay.getNavigation().stop();
            this.mantaRay.setPose(SeafarerPoses.ROLLING.get());
        }

        @Override
        public boolean canContinueToUse() {
            return timer > 0 && mantaRay.isInWater() && mantaRay.getPose() == SeafarerPoses.ROLLING.get();
        }

        @Override
        public void tick() {
            this.timer--;
        }

        @Override
        public void stop() {
            mantaRay.rollCooldown = mantaRay.random.nextInt(10 * 40) + (20 * 40);
            this.mantaRay.setPose(Pose.STANDING);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }

    public static class MantaRayLoopingGoal extends Goal {

        public MantaRay mantaRay;
        public int timer;

        public MantaRayLoopingGoal(MantaRay mantaRay) {
            this.mantaRay = mantaRay;
        }

        @Override
        public boolean canUse() {
            return mantaRay.loopCooldown == 0 && mantaRay.getPose() == Pose.STANDING && mantaRay.isInWater() && mantaRay.level().getFluidState(mantaRay.blockPosition().below(2)).is(FluidTags.WATER) && mantaRay.level().getBlockState(mantaRay.blockPosition().above(6)).is(Blocks.WATER);
        }

        @Override
        public void start() {
            this.timer = 80;
            this.mantaRay.getNavigation().stop();
            this.mantaRay.setPose(SeafarerPoses.LOOPING.get());
        }

        @Override
        public boolean canContinueToUse() {
            return timer > 0 && mantaRay.isInWater() && mantaRay.getPose() == SeafarerPoses.LOOPING.get();
        }

        @Override
        public void tick() {
            this.timer--;
        }

        @Override
        public void stop() {
            mantaRay.loopCooldown = mantaRay.random.nextInt(10 * 40) + (20 * 80);
            this.mantaRay.setPose(Pose.STANDING);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
}

package com.barlinc.seafarer.entities;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Sunfish extends WaterAnimal {

    public float prevOnLandProgress;
    public float onLandProgress;

    public final AnimationState flopAnimationState = new AnimationState();
    public final AnimationState swimmingAnimationState = new AnimationState();

    public Sunfish(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 40, 1, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 1);
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new WaterBoundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 10));
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
        return size.height * 0.7F;
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
            if (!this.isEyeInFluid(FluidTags.WATER)) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
            }
        } else {
            super.travel(travelVec);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        this.flopAnimationState.animateWhen(this.isAlive() && !this.isInWaterOrBubble(), this.tickCount);
        this.swimmingAnimationState.animateWhen(this.isInWaterOrBubble(), this.tickCount);
    }

    @Override
    public void aiStep() {
        this.prevOnLandProgress = onLandProgress;
        boolean onLand = !this.isInWaterOrBubble();
        if (onLand && onLandProgress < 10F) {
            onLandProgress++;
        }
        if (!onLand && onLandProgress > 0F) {
            onLandProgress--;
        }

        if (!isInWaterOrBubble() && this.isAlive()) {
            if (this.onGround() && random.nextFloat() < 0.01F) {
                this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.1F, 0.25D, (this.random.nextFloat() * 2.0F - 1.0F) * 0.1F));
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
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    @Override
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }

    public static boolean canSpawn(EntityType<Sunfish> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        int seaLevel = level.getSeaLevel();
        int spawnHeight = seaLevel - 13;
        return pos.getY() >= spawnHeight && pos.getY() <= seaLevel && level.getFluidState(pos.below()).is(FluidTags.WATER) && level.getBlockState(pos.above()).is(Blocks.WATER);
    }
}

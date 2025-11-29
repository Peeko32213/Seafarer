package com.barlinc.seafarer.entities;

import com.barlinc.seafarer.entities.ai.goal.LavaOrWaterRandomSwimGoal;
import com.barlinc.seafarer.entities.ai.navigation.LavaPathNavigation;
import com.barlinc.seafarer.entities.ai.utils.LavaSwimmingMoveControl;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class Magmaw extends Monster {

    public final AnimationState flopAnimationState = new AnimationState();
    public final AnimationState swimmingAnimationState = new AnimationState();

    public Magmaw(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 0.0F);
        this.moveControl = new LavaSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LavaOrWaterRandomSwimGoal(this, 1.0D, 10, 20, 20, 3));
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new LavaPathNavigation(this, level);
    }

    @Override
    public void travel(@NotNull Vec3 travelVector) {
        boolean inLiquid = this.isInLava() || this.isInWater();
        if (this.isEffectiveAi() && inLiquid) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) this.setupAnimationStates();
    }

    private void setupAnimationStates() {
        this.flopAnimationState.animateWhen(!this.isInWaterOrBubble() && !this.isInLava(), this.tickCount);
        this.swimmingAnimationState.animateWhen(this.isInWaterOrBubble() || this.isInLava(), this.tickCount);
    }

    @Override
    public void calculateEntityAnimation(boolean flying) {
        float f1 = (float) Mth.length(this.getX() - this.xo, this.getY() - this.yo, this.getZ() - this.zo);
        float f2 = Math.min(f1 * 10.0F, 1.0F);
        this.walkAnimation.update(f2, 0.4F);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    public static boolean canSpawn(EntityType<? extends Magmaw> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return false;
    }
}

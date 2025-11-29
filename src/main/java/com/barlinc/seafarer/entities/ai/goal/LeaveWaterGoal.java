package com.barlinc.seafarer.entities.ai.goal;

import com.barlinc.seafarer.utils.SeafarerBlockPos;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class LeaveWaterGoal extends Goal {

    private final PathfinderMob mob;
    private BlockPos targetPos;
    private final int chance;

    public LeaveWaterGoal(PathfinderMob mob, int chance) {
        this.mob = mob;
        this.chance = chance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        if (this.mob.level().getFluidState(this.mob.blockPosition()).is(FluidTags.WATER) && (this.mob.getTarget() != null || this.mob.getRandom().nextInt(this.chance) == 0)) {
            targetPos = generateTarget();
            return targetPos != null;
        }
        return false;
    }

    public void start() {
        if (targetPos != null) {
            this.mob.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1);
        }
    }

    public void tick() {
        if (targetPos != null) {
            this.mob.getNavigation().moveTo(targetPos.getX(), targetPos.getY(), targetPos.getZ(), 1);
        }
        if (this.mob.horizontalCollision && this.mob.isInWater()) {
            final float f1 = mob.getYRot() * Mth.DEG_TO_RAD;
            mob.setDeltaMovement(mob.getDeltaMovement().add(-Mth.sin(f1) * 0.2F, 0.05D, Mth.cos(f1) * 0.2F));
        }
    }

    public boolean canContinueToUse() {
        return !this.mob.getNavigation().isDone() && targetPos != null && !this.mob.level().getFluidState(targetPos).is(FluidTags.WATER);
    }

    public BlockPos generateTarget() {
        Vec3 vector3d = LandRandomPos.getPos(this.mob, 23, 7);
        int tries = 0;
        while(vector3d != null && tries < 8) {
            boolean waterDetected = false;
            for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(vector3d.x - 2.0D), Mth.floor(vector3d.y - 1.0D), Mth.floor(vector3d.z - 2.0D), Mth.floor(vector3d.x + 2.0D), Mth.floor(vector3d.y), Mth.floor(vector3d.z + 2.0D))) {
                if (this.mob.level().getFluidState(blockpos1).is(FluidTags.WATER)) {
                    waterDetected = true;
                    break;
                }
            }
            if (waterDetected) {
                vector3d = LandRandomPos.getPos(this.mob, 23, 7);
            } else {
                return SeafarerBlockPos.fromVec3(vector3d);
            }
            tries++;
        }
        return null;
    }
}

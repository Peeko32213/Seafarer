package com.barlinc.seafarer.entities.ai.goal;

import com.barlinc.seafarer.entities.ai.utils.SeafarerBehaviourUtils;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class LavaOrWaterRandomSwimGoal extends RandomStrollGoal {

    public LavaOrWaterRandomSwimGoal(PathfinderMob mob, double speedMultiplier, int interval) {
        super(mob, speedMultiplier, interval);
    }

    @Override
    public boolean canUse() {
        if (!this.mob.isInLava() && !this.mob.isInWater() || this.mob.isPassenger() || mob.getTarget() != null || !this.mob.isInWater() && !this.mob.isInLava()) {
            return false;
        } else {
            if (!this.forceTrigger) {
                if (this.mob.getRandom().nextInt(this.interval) >= 100) {
                    return false;
                }
            }
            Vec3 vector3d = this.getPosition();
            if (vector3d == null) {
                return false;
            } else {
                this.wantedX = vector3d.x;
                this.wantedY = vector3d.y;
                this.wantedZ = vector3d.z;
                this.forceTrigger = false;
                return true;
            }
        }
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse() && (this.mob.isInWater() || this.mob.isInLava());
    }

    @Nullable
    @Override
    protected Vec3 getPosition() {
        return SeafarerBehaviourUtils.getRandomSwimmableLavaOrWaterPos(this.mob, 10, 7);
    }
}

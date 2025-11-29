package com.barlinc.seafarer.entities.ai.goal;

import com.barlinc.seafarer.entities.ai.utils.SeafarerBehaviourUtils;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class LavaOrWaterRandomSwimGoal extends RandomStrollGoal {

    private Vec3 wantedPos;
    private final int radius;
    private final int height;
    private final int proximity;

    public LavaOrWaterRandomSwimGoal(PathfinderMob mob, double speedMultiplier, int interval, int radius, int height, int proximity) {
        super(mob, speedMultiplier, interval);
        this.radius = radius;
        this.height = height;
        this.proximity = proximity;
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
        wantedPos = new Vec3(this.wantedX, this.wantedY, this.wantedZ);
        return super.canContinueToUse() && !(this.wantedPos.distanceTo(this.mob.position()) <= this.mob.getBbWidth() * proximity) && (this.mob.isInWater() || this.mob.isInLava());
    }

    @Nullable
    @Override
    protected Vec3 getPosition() {
        return SeafarerBehaviourUtils.getRandomSwimmableLavaOrWaterPos(this.mob, 10, 7);
    }
}

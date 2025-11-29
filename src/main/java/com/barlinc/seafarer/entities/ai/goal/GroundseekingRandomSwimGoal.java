package com.barlinc.seafarer.entities.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class GroundseekingRandomSwimGoal extends RandomStrollGoal {

    PathfinderMob entity;
    Vec3 wantedPos;

    int radius;
    int height;
    double prox;

    public GroundseekingRandomSwimGoal(PathfinderMob entity, double spdmultiplier, int interval, int SearchRadius, int SearchHeight, double proximity) {
        super(entity, spdmultiplier, interval);
        this.entity = entity;
        this.radius = SearchRadius;
        this.height = SearchHeight;
        this.prox = proximity;
    }

    @Override
    public boolean canUse() {
        boolean canUse =super.canUse() && entity.isInWater();
        return canUse;
    }

    @Override
    public boolean canContinueToUse() {
        wantedPos = new Vec3(this.wantedX, this.wantedY, this.wantedZ);
        return super.canContinueToUse() && entity.isInWater() && !(this.wantedPos.distanceTo(this.entity.position()) <= this.entity.getBbWidth() * prox);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Nullable
    protected Vec3 getPosition() {
        Vec3 goalpos = getRandomSwimmablePosWithSeabed(this.mob, radius, height);
        return goalpos;
    }

    @Nullable
    public static Vec3 getRandomSwimmablePosWithSeabed(PathfinderMob pPathfinder, int pRadius, int pVerticalDistance) {
        Vec3 testPos = DefaultRandomPos.getPos(pPathfinder, pRadius, pVerticalDistance);
        int MaxSearchAmount = pRadius*pRadius*pRadius;
        for (int x = 0; testPos != null && x < MaxSearchAmount; testPos = DefaultRandomPos.getPos(pPathfinder, pRadius, pVerticalDistance), x ++) {
            if (testPos != null) {
                Vec3 belowPos = testPos.subtract(0, 1, 0);
                if (pPathfinder.level().getBlockState(BlockPos.containing(belowPos)).entityCanStandOn(pPathfinder.level(), BlockPos.containing(testPos), pPathfinder) && pPathfinder.level().getBlockState(BlockPos.containing(testPos)).isPathfindable(pPathfinder.level(), BlockPos.containing(testPos), PathComputationType.WATER)) {
                    return testPos;
                }
                if (x == MaxSearchAmount - 1) {
                    return testPos;
                }
            }
        }
        return null;
    }
}

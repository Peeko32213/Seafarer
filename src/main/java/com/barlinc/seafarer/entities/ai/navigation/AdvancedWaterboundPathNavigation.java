package com.barlinc.seafarer.entities.ai.navigation;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.SwimNodeEvaluator;
import net.minecraft.world.phys.Vec3;

public class AdvancedWaterboundPathNavigation extends PathNavigation {

    private boolean allowBreaching;

    private final EntityType<?> entityType;

    public AdvancedWaterboundPathNavigation(Mob mob, Level level, EntityType<?> entityType) {
        super(mob, level);
        this.entityType = entityType;
    }

    protected PathFinder createPathFinder(int maxVisitedNodes) {
        this.allowBreaching = this.mob.getType() == entityType;
        this.nodeEvaluator = new SwimNodeEvaluator(this.allowBreaching);
        return new PathFinder(this.nodeEvaluator, maxVisitedNodes);
    }

    protected boolean canUpdatePath() {
        return this.allowBreaching || this.isInLiquid();
    }

    protected Vec3 getTempMobPos() {
        return new Vec3(this.mob.getX(), this.mob.getY(0.5D), this.mob.getZ());
    }

    protected double getGroundY(Vec3 pVec) {
        return pVec.y;
    }

    protected boolean canMoveDirectly(Vec3 vec3, Vec3 vec31) {
        return isClearForMovementBetween(this.mob, vec3, vec31, false);
    }

    public boolean isStableDestination(BlockPos pos) {
        return !this.level.getBlockState(pos).isSolidRender(this.level, pos);
    }

    public void setCanFloat(boolean canFloat) {
    }
}

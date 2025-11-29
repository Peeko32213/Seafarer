package com.barlinc.seafarer.entities.ai.navigation;

import com.barlinc.seafarer.entities.ai.utils.LavaNodeEvaluator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class LavaPathNavigation extends PathNavigation {

    private boolean allowBreaching;

    public LavaPathNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    @Override
    protected PathFinder createPathFinder(int node) {
        this.nodeEvaluator = new LavaNodeEvaluator(this.allowBreaching);
        return new PathFinder(this.nodeEvaluator, node);
    }

    @Override
    protected boolean canUpdatePath() {
        return this.allowBreaching || this.isInLiquid();
    }

    @Override
    protected Vec3 getTempMobPos() {
        return new Vec3(this.mob.getX(), this.mob.getY(0.5D), this.mob.getZ());
    }

    @Override
    protected double getGroundY(Vec3 ground) {
        return ground.y;
    }

    @Override
    protected boolean canMoveDirectly(Vec3 posVec, Vec3 posVec1) {
        Vec3 vec3 = new Vec3(posVec1.x, posVec1.y + (double) this.mob.getBbHeight() * 0.5D, posVec1.z);
        return this.level.clip(new ClipContext(posVec, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this.mob)).getType() == HitResult.Type.MISS;
    }

    @Override
    public boolean isStableDestination(BlockPos pPos) {
        return !this.level.getBlockState(pPos).isSolidRender(this.level, pPos);
    }

    @Override
    public void setCanFloat(boolean pCanSwim) {
    }
}

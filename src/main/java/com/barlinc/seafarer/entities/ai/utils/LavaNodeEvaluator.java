package com.barlinc.seafarer.entities.ai.utils;

import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LavaNodeEvaluator extends NodeEvaluator {

    private final boolean allowBreaching;
    private final Long2ObjectMap<BlockPathTypes> pathTypesByPosCache = new Long2ObjectOpenHashMap<>();

    public LavaNodeEvaluator(boolean allowBreaching) {
        this.allowBreaching = allowBreaching;
    }

    @Override
    public void prepare(PathNavigationRegion navigationRegion, Mob mob) {
        super.prepare(navigationRegion, mob);
        this.pathTypesByPosCache.clear();
    }

    @Override
    public void done() {
        super.done();
        this.pathTypesByPosCache.clear();
    }

    @Override
    public Node getStart() {
        return super.getNode(Mth.floor(this.mob.getBoundingBox().minX), Mth.floor(this.mob.getBoundingBox().minY + 0.5D), Mth.floor(this.mob.getBoundingBox().minZ));
    }

    @Override
    public Target getGoal(double p_77459_, double p_77460_, double p_77461_) {
        return new Target(super.getNode(Mth.floor(p_77459_), Mth.floor(p_77460_), Mth.floor(p_77461_)));
    }

    @Override
    public int getNeighbors(Node[] nodes, Node node) {
        int i = 0;
        Map<Direction, Node> map = Maps.newEnumMap(Direction.class);

        for(Direction direction : Direction.values()) {
            Node node1 = this.getNode(node.x + direction.getStepX(), node.y + direction.getStepY(), node.z + direction.getStepZ());
            map.put(direction, node1);
            if (this.isNodeValid(node1)) {
                nodes[i++] = node1;
            }
        }

        for(Direction direction1 : Direction.Plane.HORIZONTAL) {
            Direction direction2 = direction1.getClockWise();
            Node node2 = this.getNode(node.x + direction1.getStepX() + direction2.getStepX(), node.y, node.z + direction1.getStepZ() + direction2.getStepZ());
            if (this.isDiagonalNodeValid(node2, map.get(direction1), map.get(direction2))) {
                nodes[i++] = node2;
            }
        }

        return i;
    }

    protected boolean isNodeValid(@Nullable Node node) {
        return node != null && !node.closed;
    }

    protected boolean isDiagonalNodeValid(@Nullable Node p_192964_, @Nullable Node p_192965_, @Nullable Node p_192966_) {
        return this.isNodeValid(p_192964_) && p_192965_ != null && p_192965_.costMalus >= 0.0F && p_192966_ != null && p_192966_.costMalus >= 0.0F;
    }

    @Nullable
    @Override
    protected Node getNode(int pX, int pY, int pZ) {
        Node node = null;
        BlockPathTypes blockpathtypes = this.getCachedBlockType(pX, pY, pZ);
        if (this.allowBreaching && blockpathtypes == BlockPathTypes.BREACH || blockpathtypes == BlockPathTypes.WATER ||  blockpathtypes == BlockPathTypes.LAVA) {
            float f = this.mob.getPathfindingMalus(blockpathtypes);
            if (f >= 0.0F) {
                node = super.getNode(pX, pY, pZ);
                node.type = blockpathtypes;
                node.costMalus = Math.max(node.costMalus, f);
                if (this.level.getFluidState(new BlockPos(pX, pY, pZ)).isEmpty()) {
                    node.costMalus += 8.0F;
                }
            }
        }

        return node;
    }

    protected BlockPathTypes getCachedBlockType(int i, int j, int k) {
        return this.pathTypesByPosCache.computeIfAbsent(BlockPos.asLong(i, j, k), (l) -> this.getBlockPathType(this.level, i, j, k));
    }

    @Override
    public BlockPathTypes getBlockPathType(BlockGetter pLevel, int pX, int pY, int pZ) {
        return this.getBlockPathType(pLevel, pX, pY, pZ, this.mob);
    }

    @Override
    public BlockPathTypes getBlockPathType(BlockGetter pBlockaccess, int pX, int pY, int pZ, Mob pEntityliving) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int i = pX; i < pX + this.entityWidth; ++i) {
            for (int j = pY; j < pY + this.entityHeight; ++j) {
                for (int k = pZ; k < pZ + this.entityDepth; ++k) {
                    FluidState fluidstate = pBlockaccess.getFluidState(mutableBlockPos.set(i, j, k));
                    BlockState blockstate = pBlockaccess.getBlockState(mutableBlockPos.set(i, j, k));
                    if (fluidstate.isEmpty() && blockstate.isPathfindable(pBlockaccess, mutableBlockPos.below(), PathComputationType.WATER) && blockstate.isAir()) {
                        return BlockPathTypes.BREACH;
                    }
                    else {
                        return fluidstate.is(FluidTags.LAVA) ? BlockPathTypes.WATER : BlockPathTypes.BLOCKED;
                    }
                }
            }
        }

        FluidState fluidState1 = pBlockaccess.getFluidState(mutableBlockPos);
        return fluidState1.is(FluidTags.LAVA) ? BlockPathTypes.WATER : BlockPathTypes.BLOCKED;
    }
}

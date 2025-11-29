package com.barlinc.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ShellDecorationBlock extends BushBlock implements SimpleWaterloggedBlock {

    protected  final VoxelShape Z_AXIS_AABB;
    protected  final VoxelShape X_AXIS_AABB;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private final Block deadBlock;


    public ShellDecorationBlock(Properties properties, VoxelShape z_axis_aabb, VoxelShape x_axis_aabb, Block pDeadBlock) {
        super(properties);
        this.Z_AXIS_AABB = z_axis_aabb;
        this.X_AXIS_AABB = x_axis_aabb;
        this.deadBlock = pDeadBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_56089_) {
        if (!this.scanForWater(p_56089_.getLevel(), p_56089_.getClickedPos())) {
            p_56089_.getLevel().scheduleTick(p_56089_.getClickedPos(), this, 60 + p_56089_.getLevel().getRandom().nextInt(40));
        }
        {
            FluidState fluidstate = p_56089_.getLevel().getFluidState(p_56089_.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(p_56089_).setValue(WATERLOGGED, Boolean.valueOf(flag));
        }
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!this.scanForWater(pLevel, pPos)) {
            pLevel.setBlock(pPos, this.deadBlock.defaultBlockState(), 2);
        }

    }

    protected boolean scanForWater(BlockGetter pLevel, BlockPos pPos) {
        BlockState state = pLevel.getBlockState(pPos);
        for(Direction direction : Direction.values()) {
            FluidState fluidstate = pLevel.getFluidState(pPos.relative(direction));
            if (state.canBeHydrated(pLevel, pPos, fluidstate, pPos.relative(direction))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(FACING).getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        if (!this.scanForWater(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 60 + pLevel.getRandom().nextInt(40));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos below = pos.below();
        return this.mayPlaceOn(world.getBlockState(below), world, below);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {
        return (!state.getCollisionShape(world, pos).getFaceShape(Direction.UP).isEmpty() || state.isFaceSturdy(world, pos, Direction.UP)) && !state.is(BlockTags.LEAVES);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return (type == PathComputationType.AIR && !this.hasCollision) || super.isPathfindable(state, world, pos, type);
    }

    public FluidState getFluidState(BlockState p_56131_) {
        return p_56131_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56131_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56120_) {
        p_56120_.add(WATERLOGGED);
    }

}

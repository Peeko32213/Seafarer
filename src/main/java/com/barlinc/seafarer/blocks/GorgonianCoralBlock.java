package com.barlinc.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class GorgonianCoralBlock extends RotatableDoublePlantBlock implements SimpleWaterloggedBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public GorgonianCoralBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, true).setValue(HALF, DoubleBlockHalf.LOWER));;
    }

    @Override
    @NotNull
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, WATERLOGGED, FACING);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return state.isFaceSturdy(blockGetter, pos, Direction.UP) && !state.is(Blocks.MAGMA_BLOCK);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return pos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(pos.above()).canBeReplaced(context) && fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 && !context.getLevel().getBlockState(pos.above()).isAir() ? this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()) : null;
    }

    @Override
    @NotNull
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        BlockState blockstate = super.updateShape(state, direction, blockState, level, pos, blockPos);
        if (!blockstate.isAir()) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return blockstate;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        FluidState fluid = level.getFluidState(pos);
        return super.canSurvive(state, level, pos) && fluid.is(FluidTags.WATER) && fluid.getAmount() == 8;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Override
    @NotNull
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos pos, BlockState state, Fluid fluid) {
        return true;
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pqs, BlockState state, FluidState fluidState) {
        return false;
    }
}

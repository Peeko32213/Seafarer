package com.barlinc.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class StarfishBlock extends Block implements SimpleWaterloggedBlock {

    public static final IntegerProperty STARFISH_AMOUNT = IntegerProperty.create("starfish_amount", 1, 3);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    protected static final VoxelShape EAST_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape UP_AABB;
    protected static final VoxelShape DOWN_AABB;

    public StarfishBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STARFISH_AMOUNT, 1).setValue(WATERLOGGED, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case DOWN -> DOWN_AABB;
            case UP -> UP_AABB;
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            case WEST -> WEST_AABB;
            case EAST -> EAST_AABB;
        };
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            return blockstate.setValue(STARFISH_AMOUNT, Math.min(3, blockstate.getValue(STARFISH_AMOUNT) + 1)).setValue(FACING, context.getClickedFace());
        } else {
            FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, flag).setValue(FACING, context.getClickedFace());
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockPos = pos.relative(direction.getOpposite());
        return level.getBlockState(blockPos).isFaceSturdy(level, blockPos, direction);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        if (!state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (state.getValue(WATERLOGGED)) {
                level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            }
            return super.updateShape(state, direction, blockState, level, pos, blockPos);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(STARFISH_AMOUNT) < 3 || super.canBeReplaced(state, context);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(STARFISH_AMOUNT, WATERLOGGED, FACING);
    }

    static {
        DOWN_AABB = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        UP_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
        EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);
        WEST_AABB = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
        NORTH_AABB = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    }
}

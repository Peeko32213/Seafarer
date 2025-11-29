package com.barlinc.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ShellBlock extends Block implements SimpleWaterloggedBlock {

    public static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 3, 13);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ShellBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, true));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (!this.scanForWater(context.getLevel(), context.getClickedPos())) {
            context.getLevel().scheduleTick(context.getClickedPos(), this, 60 + context.getLevel().getRandom().nextInt(40));
        }
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(context).setValue(WATERLOGGED, flag).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected boolean scanForWater(BlockGetter level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        for (Direction direction : Direction.values()) {
            FluidState fluidstate = level.getFluidState(pos.relative(direction));
            if (state.canBeHydrated(level, pos, fluidstate, pos.relative(direction))) {
                return true;
            }
        }
        return false;
    }

    @Override
    @NotNull
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    @NotNull
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        if (!this.scanForWater(level, pos)) {
            level.scheduleTick(pos, this, 60 + level.getRandom().nextInt(40));
        }
        return super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();
        return this.mayPlaceOn(level.getBlockState(below), level, below);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return (!state.getCollisionShape(blockGetter, pos).getFaceShape(Direction.UP).isEmpty() || state.isFaceSturdy(blockGetter, pos, Direction.UP)) && !state.is(BlockTags.LEAVES);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED, FACING);
    }
}

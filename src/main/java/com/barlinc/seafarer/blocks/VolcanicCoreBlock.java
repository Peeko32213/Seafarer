package com.barlinc.seafarer.blocks;

import com.barlinc.seafarer.blocks.blockentity.VolcanicCoreBlockEntity;
import com.barlinc.seafarer.registry.SeafarerBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;

public class VolcanicCoreBlock extends BaseEntityBlock {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public VolcanicCoreBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVE, true));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (!this.nearLava(context.getLevel(), context.getClickedPos())) {
            context.getLevel().scheduleTick(context.getClickedPos(), this, 60 + context.getLevel().getRandom().nextInt(40));
        }
        return this.defaultBlockState();
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState blockState, LevelAccessor level, BlockPos pos, BlockPos blockPos) {
        if (!this.nearLava(level, pos)) {
            level.scheduleTick(pos, this, 60 + level.getRandom().nextInt(40));
        }
        return super.updateShape(state, direction, blockState, level, pos, blockPos);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (!this.nearLava(level, pos)) {
            level.setBlockAndUpdate(pos, state.setValue(ACTIVE, false));
        }
    }

    protected boolean nearLava(BlockGetter getter, BlockPos pos) {
        int adjacent = 0;
        for (Direction direction : Direction.values()) {
            FluidState fluidstate = getter.getFluidState(pos.relative(direction));
            if (fluidstate.is(FluidTags.LAVA)) {
                adjacent++;
            }
        }
        return adjacent > 3;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(ACTIVE);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new VolcanicCoreBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return VolcanicCoreBlock.createTickerHelper(type, SeafarerBlockEntities.VOLCANIC_CORE.get(), VolcanicCoreBlockEntity::particleTick);
        } else {
            return null;
        }
    }
}

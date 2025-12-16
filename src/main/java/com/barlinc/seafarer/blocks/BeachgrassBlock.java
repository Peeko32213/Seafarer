package com.barlinc.seafarer.blocks;

import com.barlinc.seafarer.registry.SeafarerBlocks;
import com.barlinc.seafarer.registry.tags.SeafarerBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;

public class BeachgrassBlock extends BushBlock implements IForgeShearable, BonemealableBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public BeachgrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.is(SeafarerBlocks.SHORT_BEACHGRASS.get()) && SeafarerBlocks.BEACHGRASS.get().defaultBlockState().canSurvive(level, pos)) {
            level.setBlockAndUpdate(pos, SeafarerBlocks.BEACHGRASS.get().defaultBlockState());
        }
        if (state.is(SeafarerBlocks.BEACHGRASS.get()) && SeafarerBlocks.TALL_BEACHGRASS.get().defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
            TallBeachPlantBlock.placeAt(level, SeafarerBlocks.TALL_BEACHGRASS.get().defaultBlockState(), pos, 2);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean canBonemeal) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(SeafarerBlockTags.BEACH_PLANT_PLACEABLE);
    }
}

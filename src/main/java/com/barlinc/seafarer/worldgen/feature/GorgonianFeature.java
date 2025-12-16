package com.barlinc.seafarer.worldgen.feature;

import com.barlinc.seafarer.blocks.GorgonianCoralBlock;
import com.barlinc.seafarer.registry.SeafarerBlocks;
import com.barlinc.seafarer.registry.tags.SeafarerBlockTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Optional;

public class GorgonianFeature extends Feature<NoneFeatureConfiguration> {

    public GorgonianFeature(Codec<NoneFeatureConfiguration> configuration) {
        super(configuration);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        Optional<Block> gorgonian = BuiltInRegistries.BLOCK.getTag(SeafarerBlockTags.GORGONIANS).flatMap((holders) -> holders.getRandomElement(level.getRandom())).map(Holder::value);

        int i = 0;

        BlockState block = gorgonian.map(Block::defaultBlockState).orElseGet(SeafarerBlocks.TOWERING_GORGONIAN.get()::defaultBlockState).setValue(GorgonianCoralBlock.WATERLOGGED, true);
        BlockPos blockpos = pos.offset(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
        for (int j = 0; j < 4; j++) {
            if (level.getFluidState(blockpos).is(FluidTags.WATER) && blockpos.getY() < 255 && block.canSurvive(level, blockpos)) {
                Direction direction = Direction.getRandom(random);
                BlockState upperState = block.setValue(GorgonianCoralBlock.HALF, DoubleBlockHalf.UPPER);
                BlockPos abovePos = blockpos.above();
                if (direction.getAxis().isHorizontal()) {
                    while (!block.setValue(GorgonianCoralBlock.FACING, direction).canSurvive(level, blockpos)) {
                        direction = Direction.getRandom(random);
                    }
                    if (level.getBlockState(abovePos).is(Blocks.WATER)) {
                        level.setBlock(blockpos, block.setValue(GorgonianCoralBlock.FACING, direction).setValue(GorgonianCoralBlock.WATERLOGGED, true), 2);
                        level.setBlock(abovePos, upperState.setValue(GorgonianCoralBlock.FACING, direction).setValue(GorgonianCoralBlock.WATERLOGGED, true), 2);
                    }
                    i++;
                }
            }
        }
        return i > 0;
    }
}

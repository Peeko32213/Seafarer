package com.barlinc.seafarer.blocks;

import com.barlinc.seafarer.registry.SeafarerBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LightEngine;

import java.util.List;
import java.util.Optional;

public class MossyScoriaBlock extends Block implements BonemealableBlock {

    public MossyScoriaBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    private static boolean canBeMossy(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(level, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(level, blockpos));
            return i < level.getMaxLightLevel();
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeMossy(state, level, pos)) {
            level.setBlockAndUpdate(pos, SeafarerBlocks.SCORIA.get().defaultBlockState());
        }
        super.tick(state, level, pos, random);
    }

    // make sure block isn't mossy if generated where it can't be mossy
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos blockPos, BlockPos facingPos) {
        if (!canBeMossy(state, level, blockPos)) {
            level.scheduleTick(blockPos, this, 60 + level.getRandom().nextInt(40));
        }
        return super.updateShape(state, direction, facingState, level, blockPos, facingPos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean valid) {
        return level.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        BlockState blockState = Blocks.GRASS.defaultBlockState();
        Optional<Holder.Reference<PlacedFeature>> feature = level.registryAccess().registryOrThrow(Registries.PLACED_FEATURE).getHolder(VegetationPlacements.GRASS_BONEMEAL);

        label49:
        for(int i = 0; i < 128; ++i) {
            BlockPos blockPos1 = blockPos;

            for(int j = 0; j < i / 16; ++j) {
                blockPos1 = blockPos1.offset(source.nextInt(3) - 1, (source.nextInt(3) - 1) * source.nextInt(3) / 2, source.nextInt(3) - 1);
                if (!level.getBlockState(blockPos1.below()).is(this) || level.getBlockState(blockPos1).isCollisionShapeFullBlock(level, blockPos1)) {
                    continue label49;
                }
            }

            BlockState state1 = level.getBlockState(blockPos1);
            if (state1.is(blockState.getBlock()) && source.nextInt(10) == 0) {
                ((BonemealableBlock) blockState.getBlock()).performBonemeal(level, source, blockPos1, state1);
            }

            if (state1.isAir()) {
                Holder<PlacedFeature> featureHolder;
                if (source.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> configuredFeatures = level.getBiome(blockPos1).value().getGenerationSettings().getFlowerFeatures();
                    if (configuredFeatures.isEmpty()) {
                        continue;
                    }
                    featureHolder = ((RandomPatchConfiguration) configuredFeatures.get(0).config()).feature();
                } else {
                    if (!feature.isPresent()) {
                        continue;
                    }
                    featureHolder = feature.get();
                }
                featureHolder.value().place(level, level.getChunkSource().getGenerator(), source, blockPos1);
            }
        }
    }
}

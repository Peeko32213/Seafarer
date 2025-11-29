package com.barlinc.seafarer.blocks.blockentity;

import com.barlinc.seafarer.blocks.VolcanicCoreBlock;
import com.barlinc.seafarer.registry.SeafarerBlockEntities;
import com.barlinc.seafarer.registry.SeafarerParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VolcanicCoreBlockEntity extends BlockEntity {

    public VolcanicCoreBlockEntity(BlockPos pos, BlockState state) {
        super(SeafarerBlockEntities.VOLCANIC_CORE.get(), pos, state);
    }

    public static void particleTick(Level level, BlockPos pos, BlockState state, VolcanicCoreBlockEntity blockEntity) {
        RandomSource random = level.getRandom();
        if (state.getValue(VolcanicCoreBlock.ACTIVE)) {
            if (random.nextFloat() < 0.04F) {
                float x = (random.nextFloat() - 0.5F) * 0.5F;
                float z = (random.nextFloat() - 0.5F) * 0.5F;
                if (random.nextFloat() <= 0.3F) {
                    if (random.nextFloat() <= 0.7F) {
                        level.addAlwaysVisibleParticle(SeafarerParticles.BIG_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    } else {
                        level.addAlwaysVisibleParticle(SeafarerParticles.GIANT_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    }
                } else {
                    if (random.nextBoolean()) {
                        level.addAlwaysVisibleParticle(SeafarerParticles.SMALL_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    } else {
                        level.addAlwaysVisibleParticle(SeafarerParticles.MEDIUM_VOLCANIC_SMOKE.get(), true, pos.getX() + 0.5F + x, pos.getY() + 0.5F, pos.getZ() + 0.5F + z, x * 0.15F, 0.2F + random.nextFloat() * 0.03F, z * 0.15F);
                    }
                }
            }
        }
    }
}

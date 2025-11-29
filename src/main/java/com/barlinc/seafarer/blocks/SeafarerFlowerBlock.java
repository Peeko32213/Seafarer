package com.barlinc.seafarer.blocks;

import com.barlinc.seafarer.registry.tags.SeafarerBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;

import java.util.function.Supplier;

public class SeafarerFlowerBlock extends FlowerBlock implements IForgeShearable {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public SeafarerFlowerBlock(Supplier<MobEffect> stewEffect, int effectDuration, Properties properties) {
        super(stewEffect, effectDuration, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(SeafarerBlockTags.BEACH_PLANT_PLACEABLE);
    }
}

package com.barlinc.seafarer.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SeaGlassBottleBlock extends Block {

    public static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 15, 12);
    private final VoxelShape bottleHitbox;

    public SeaGlassBottleBlock(Properties properties) {
        this(SHAPE, properties);
    }

    public SeaGlassBottleBlock(VoxelShape bottleHitbox, Properties pProperties) {
        super(pProperties);
        this.bottleHitbox  =bottleHitbox;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return bottleHitbox;
    }

}

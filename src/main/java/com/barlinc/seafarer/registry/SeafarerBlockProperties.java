package com.barlinc.seafarer.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class SeafarerBlockProperties {

    public static final BlockBehaviour.Properties PLANT = BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);
    public static final BlockBehaviour.Properties WATER_PLANT = BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).noCollission().instabreak().sound(SoundType.WET_GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);

    public static final BlockBehaviour.Properties DEAD_CORAL_BLOCK = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
    public static final BlockBehaviour.Properties DEAD_CORAL = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).forceSolidOn().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().noCollission().instabreak();

    public static final BlockBehaviour.Properties SAND = BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.SAND).instrument(NoteBlockInstrument.SNARE).mapColor(MapColor.SAND);
    public static final BlockBehaviour.Properties SANDSTONE = BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F);

    public static final BlockBehaviour.Properties SCORIA = BlockBehaviour.Properties.of().sound(SoundType.BASALT).mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.GUITAR).requiresCorrectToolForDrops().strength(1.2F, 4.0F);

    public static final BlockBehaviour.Properties LEAVES = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(SeafarerBlockProperties::ocelotOrParrot).isSuffocating(SeafarerBlockProperties::never).isViewBlocking(SeafarerBlockProperties::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(SeafarerBlockProperties::never);

    public static BlockBehaviour.Properties shellBlock(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.XYLOPHONE).requiresCorrectToolForDrops().strength(2.0F).sound(SoundType.BONE_BLOCK);
    }

    public static BlockBehaviour.Properties seaGlass(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.AMETHYST).noOcclusion().isValidSpawn(SeafarerBlockProperties::neverEntity).isRedstoneConductor(SeafarerBlockProperties::never).isSuffocating(SeafarerBlockProperties::never).isViewBlocking(SeafarerBlockProperties::never);
    }

    public static BlockBehaviour.Properties seaGlassSolid(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST);
    }

    public static BlockBehaviour.Properties seaGlassLamp(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel(state -> 15);
    }

    public static BlockBehaviour.Properties seaGlassPebbles(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3F).requiresCorrectToolForDrops().noCollission().noOcclusion().sound(SoundType.AMETHYST).pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties seaGlassBottle(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.4F).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.AMETHYST).pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties starfish(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).strength(0.2F).sound(SoundType.CORAL_BLOCK).instabreak().noOcclusion().noCollission().instabreak().pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties coral(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY);
    }

    public static BlockBehaviour.Properties coralBlock(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK);
    }

    public static BlockBehaviour.Properties flower(MapColor color) {
        return BlockBehaviour.Properties.of().mapColor(color).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY);
    }

    public static boolean ocelotOrParrot(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    public static boolean neverEntity(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return false;
    }
}

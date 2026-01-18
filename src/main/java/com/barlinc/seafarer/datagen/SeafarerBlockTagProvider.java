package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.tags.SeafarerBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.barlinc.seafarer.registry.SeafarerBlocks.*;

public class SeafarerBlockTagProvider extends BlockTagsProvider {

    public SeafarerBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.CORAL_PLANTS).add(
//                AMBER_CORAL.get(),
//                CERULEAN_CORAL.get(),
//                MAROON_CORAL.get(),
//                OLIVE_CORAL.get(),
//                TURQUOISE_CORAL.get(),
//                VERDANT_CORAL.get(),
//                AMBER_CORAL_FAN.get(),
//                CERULEAN_CORAL_FAN.get(),
//                MAROON_CORAL_FAN.get(),
//                OLIVE_CORAL_FAN.get(),
//                TURQUOISE_CORAL_FAN.get(),
//                VERDANT_CORAL_FAN.get(),
                CYAN_ZOA.get(),
                ORANGE_ZOA.get(),
                PURPLE_ZOA.get(),
                RED_ZOA.get(),
                BLUE_CHRISTMAS_TREE_WORM.get(),
                BLACK_CHRISTMAS_TREE_WORM.get(),
                YELLOW_CHRISTMAS_TREE_WORM.get(),
                WHITE_CHRISTMAS_TREE_WORM.get(),
                RED_CHRISTMAS_TREE_WORM.get()
        );

//        this.tag(BlockTags.CORAL_BLOCKS).add(
//                AMBER_CORAL_BLOCK.get(),
//                CERULEAN_CORAL_BLOCK.get(),
//                MAROON_CORAL_BLOCK.get(),
//                OLIVE_CORAL_BLOCK.get(),
//                TURQUOISE_CORAL_BLOCK.get(),
//                VERDANT_CORAL_BLOCK.get()
//        );
//
//        this.tag(BlockTags.WALL_CORALS).add(
//                AMBER_CORAL_WALL_FAN.get(),
//                CERULEAN_CORAL_WALL_FAN.get(),
//                MAROON_CORAL_WALL_FAN.get(),
//                OLIVE_CORAL_WALL_FAN.get(),
//                TURQUOISE_CORAL_WALL_FAN.get(),
//                VERDANT_CORAL_WALL_FAN.get()
//        );

        this.tag(SeafarerBlockTags.GORGONIANS).add(
                TOWERING_GORGONIAN.get(),
                ATTUM_GORGONIAN.get(),
                ANTLER_GORGONIAN.get()
        );

        this.tag(SeafarerBlockTags.STARFISH).add(
                CORAL_STARFISH.get(),
                LAGOON_STARFISH.get(),
                PLUMERIA_STARFISH.get(),
                SKY_BLUE_STARFISH.get(),
                SUNNY_STARFISH.get(),
                SUNSET_STARFISH.get()
        );

        this.tag(BlockTags.SAND).add(
//                VOLCANIC_SAND.get(),
//                SHELLY_VOLCANIC_SAND.get(),
//                STARRY_VOLCANIC_SAND.get(),
//                CORALINE_SAND.get(),
//                SHELLY_CORALINE_SAND.get(),
//                STARRY_CORALINE_SAND.get(),
                SHELLY_SAND.get(),
                STARRY_SAND.get()
        );

        this.tag(BlockTags.DIRT).add(
                MOSSY_SCORIA.get()
        );

        this.tag(SeafarerBlockTags.BEACH_PLANT_PLACEABLE)
                .addTag(BlockTags.SAND)
                .addTag(BlockTags.DIRT);

        this.tag(BlockTags.SMALL_FLOWERS).add(
                COASTAL_WILDFLOWER.get(),
                COASTAL_LAVENDER.get(),
                SEA_THRIFT.get(),
                SEA_HOLLY.get(),
                FIERY_DUSTER.get(),
                SILK_LILIES.get(),
                TWILIGHT_BLADE.get(),
                WIDOWBLOOM.get()
        );

        this.tag(BlockTags.FLOWER_POTS).add(
                POTTED_COASTAL_WILDFLOWER.get(),
                POTTED_COASTAL_LAVENDER.get(),
                POTTED_SEA_THRIFT.get(),
                POTTED_SEA_HOLLY.get(),
                POTTED_FIERY_DUSTER.get(),
                POTTED_SILK_LILIES.get(),
                POTTED_TWILIGHT_BLADE.get(),
                POTTED_WIDOWBLOOM.get(),
                POTTED_BEACHGRASS.get(),
                POTTED_SHORT_BEACHGRASS.get(),
                POTTED_YELLOW_VOLCANIC_GRASS.get(),
                POTTED_BLUE_VOLCANIC_GRASS.get(),
                POTTED_ORANGE_VOLCANIC_GRASS.get()
        );

        this.tag(BlockTags.TALL_FLOWERS).add(
                DAWNFLAME.get(),
                SAPPHIRE_COWBELL.get()
        );

        this.tag(BlockTags.LEAVES).add(
                WHITE_FLOWERING_JUNGLE_LEAVES.get(),
                ORANGE_FLOWERING_JUNGLE_LEAVES.get(),
                YELLOW_FLOWERING_JUNGLE_LEAVES.get(),
                BLUE_FLOWERING_JUNGLE_LEAVES.get(),
                MAGENTA_FLOWERING_JUNGLE_LEAVES.get()
        );

        this.tag(BlockTags.REPLACEABLE).add(
                ORANGE_VOLCANIC_GRASS.get(),
                YELLOW_VOLCANIC_GRASS.get(),
                BLUE_VOLCANIC_GRASS.get(),
                SHORT_BEACHGRASS.get(),
                BEACHGRASS.get(),
                TALL_BEACHGRASS.get()
        );

        this.tag(BlockTags.REPLACEABLE_BY_TREES).add(
                ORANGE_VOLCANIC_GRASS.get(),
                YELLOW_VOLCANIC_GRASS.get(),
                BLUE_VOLCANIC_GRASS.get(),
                SHORT_BEACHGRASS.get(),
                BEACHGRASS.get(),
                TALL_BEACHGRASS.get(),
                DAWNFLAME.get(),
                SAPPHIRE_COWBELL.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                ORANGE_VOLCANIC_GRASS.get(),
                YELLOW_VOLCANIC_GRASS.get(),
                BLUE_VOLCANIC_GRASS.get(),
                SHORT_BEACHGRASS.get(),
                BEACHGRASS.get(),
                TALL_BEACHGRASS.get()
        );

        this.tag(BlockTags.SWORD_EFFICIENT).add(
                ORANGE_VOLCANIC_GRASS.get(),
                YELLOW_VOLCANIC_GRASS.get(),
                BLUE_VOLCANIC_GRASS.get(),
                SHORT_BEACHGRASS.get(),
                BEACHGRASS.get(),
                TALL_BEACHGRASS.get(),
                DAWNFLAME.get(),
                SAPPHIRE_COWBELL.get(),
                FISHING_NET.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                SHELLY_SAND.get(),
                STARRY_SAND.get(),
                SEA_GLASS_SAND.get(),
                CORALINE_SAND.get(),
                SHELLY_CORALINE_SAND.get(),
                STARRY_CORALINE_SAND.get(),
                VOLCANIC_SAND.get(),
                SHELLY_VOLCANIC_SAND.get(),
                STARRY_VOLCANIC_SAND.get()
        );

        this.tag(SeafarerBlockTags.SEA_GLASS).add(
                WHITE_SEA_GLASS.get(),
                LIGHT_GRAY_SEA_GLASS.get(),
                GRAY_SEA_GLASS.get(),
                BLACK_SEA_GLASS.get(),
                BROWN_SEA_GLASS.get(),
                RED_SEA_GLASS.get(),
                ORANGE_SEA_GLASS.get(),
                YELLOW_SEA_GLASS.get(),
                LIME_SEA_GLASS.get(),
                GREEN_SEA_GLASS.get(),
                CYAN_SEA_GLASS.get(),
                LIGHT_BLUE_SEA_GLASS.get(),
                BLUE_SEA_GLASS.get(),
                PURPLE_SEA_GLASS.get(),
                MAGENTA_SEA_GLASS.get(),
                PINK_SEA_GLASS.get()
        );

        this.tag(SeafarerBlockTags.SEA_GLASS_PANES).add(
                WHITE_SEA_GLASS_PANE.get(),
                LIGHT_GRAY_SEA_GLASS_PANE.get(),
                GRAY_SEA_GLASS_PANE.get(),
                BLACK_SEA_GLASS_PANE.get(),
                BROWN_SEA_GLASS_PANE.get(),
                RED_SEA_GLASS_PANE.get(),
                ORANGE_SEA_GLASS_PANE.get(),
                YELLOW_SEA_GLASS_PANE.get(),
                LIME_SEA_GLASS_PANE.get(),
                GREEN_SEA_GLASS_PANE.get(),
                CYAN_SEA_GLASS_PANE.get(),
                LIGHT_BLUE_SEA_GLASS_PANE.get(),
                BLUE_SEA_GLASS_PANE.get(),
                PURPLE_SEA_GLASS_PANE.get(),
                MAGENTA_SEA_GLASS_PANE.get(),
                PINK_SEA_GLASS_PANE.get()
        );

        this.tag(Tags.Blocks.GLASS_WHITE).add(WHITE_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_LIGHT_GRAY).add(LIGHT_GRAY_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_GRAY).add(GRAY_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_BLACK).add(BLACK_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_BROWN).add(BROWN_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_RED).add(RED_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_ORANGE).add(ORANGE_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_YELLOW).add(YELLOW_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_LIME).add(LIME_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_GREEN).add(GREEN_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_CYAN).add(CYAN_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_LIGHT_BLUE).add(LIGHT_BLUE_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_BLUE).add(BLUE_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_PURPLE).add(PURPLE_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_MAGENTA).add(MAGENTA_SEA_GLASS.get());
        this.tag(Tags.Blocks.GLASS_PINK).add(PINK_SEA_GLASS.get());

        this.tag(Tags.Blocks.GLASS_PANES_WHITE).add(WHITE_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_LIGHT_GRAY).add(LIGHT_GRAY_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_GRAY).add(GRAY_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_BLACK).add(BLACK_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_BROWN).add(BROWN_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_RED).add(RED_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_ORANGE).add(ORANGE_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_YELLOW).add(YELLOW_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_LIME).add(LIME_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_GREEN).add(GREEN_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_CYAN).add(CYAN_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_LIGHT_BLUE).add(LIGHT_BLUE_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_BLUE).add(BLUE_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_PURPLE).add(PURPLE_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_MAGENTA).add(MAGENTA_SEA_GLASS_PANE.get());
        this.tag(Tags.Blocks.GLASS_PANES_PINK).add(PINK_SEA_GLASS_PANE.get());

        this.tag(Tags.Blocks.GLASS).addTag(SeafarerBlockTags.SEA_GLASS);

        this.tag(Tags.Blocks.GLASS_PANES).addTag(SeafarerBlockTags.SEA_GLASS_PANES);

        this.tag(BlockTags.IMPERMEABLE).addTag(SeafarerBlockTags.SEA_GLASS);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                SPIKY_SHELL_BRICKS.get(), SPIKY_SHELL_BRICK_STAIRS.get(), SPIKY_SHELL_BRICK_SLAB.get(), SPIKY_SHELL_PILLAR.get(),
                CLAM_SHELL_BRICKS.get(), CLAM_SHELL_BRICK_STAIRS.get(), CLAM_SHELL_BRICK_SLAB.get(), CLAM_SHELL_PILLAR.get(),
                HORN_SHELL_BRICKS.get(), HORN_SHELL_BRICK_STAIRS.get(), HORN_SHELL_BRICK_SLAB.get(), HORN_SHELL_PILLAR.get(),
                SWIRL_SHELL_BRICKS.get(), SWIRL_SHELL_BRICK_STAIRS.get(), SWIRL_SHELL_BRICK_SLAB.get(), SWIRL_SHELL_PILLAR.get(),
                SPIRAL_SHELL_BRICKS.get(), SPIRAL_SHELL_BRICK_STAIRS.get(), SPIRAL_SHELL_BRICK_SLAB.get(), SPIRAL_SHELL_PILLAR.get(),
                PYRAMID_SHELL_BRICKS.get(), PYRAMID_SHELL_BRICK_STAIRS.get(), PYRAMID_SHELL_BRICK_SLAB.get(), PYRAMID_SHELL_PILLAR.get(),

                AMBER_CORAL_BLOCK.get(),
                CERULEAN_CORAL_BLOCK.get(),
                MAROON_CORAL_BLOCK.get(),
                OLIVE_CORAL_BLOCK.get(),
                TURQUOISE_CORAL_BLOCK.get(),
                VERDANT_CORAL_BLOCK.get(),

                DEAD_AMBER_CORAL_BLOCK.get(), DEAD_AMBER_CORAL.get(), DEAD_AMBER_CORAL_FAN.get(), DEAD_AMBER_CORAL_WALL_FAN.get(),
                DEAD_CERULEAN_CORAL_BLOCK.get(), DEAD_CERULEAN_CORAL.get(), DEAD_CERULEAN_CORAL_FAN.get(), DEAD_CERULEAN_CORAL_WALL_FAN.get(),
                DEAD_MAROON_CORAL_BLOCK.get(), DEAD_MAROON_CORAL.get(), DEAD_MAROON_CORAL_FAN.get(), DEAD_MAROON_CORAL_WALL_FAN.get(),
                DEAD_OLIVE_CORAL_BLOCK.get(), DEAD_OLIVE_CORAL.get(), DEAD_OLIVE_CORAL_FAN.get(), DEAD_OLIVE_CORAL_WALL_FAN.get(),
                DEAD_TURQUOISE_CORAL_BLOCK.get(), DEAD_TURQUOISE_CORAL.get(), DEAD_TURQUOISE_CORAL_FAN.get(), DEAD_TURQUOISE_CORAL_WALL_FAN.get(),
                DEAD_VERDANT_CORAL_BLOCK.get(), DEAD_VERDANT_CORAL.get(), DEAD_VERDANT_CORAL_FAN.get(), DEAD_VERDANT_CORAL_WALL_FAN.get(),

                CORALINE_SANDSTONE.get(), CORALINE_SANDSTONE_STAIRS.get(), CORALINE_SANDSTONE_SLAB.get(), CORALINE_SANDSTONE_WALL.get(),
                CHISELED_CORALINE_SANDSTONE.get(),
                SMOOTH_CORALINE_SANDSTONE.get(), SMOOTH_CORALINE_SANDSTONE_STAIRS.get(), SMOOTH_CORALINE_SANDSTONE_SLAB.get(),
                CUT_CORALINE_SANDSTONE.get(), CUT_CORALINE_SANDSTONE_SLAB.get(),

                VOLCANIC_SANDSTONE.get(), VOLCANIC_SANDSTONE_STAIRS.get(), VOLCANIC_SANDSTONE_SLAB.get(), VOLCANIC_SANDSTONE_WALL.get(),
                CHISELED_VOLCANIC_SANDSTONE.get(),
                SMOOTH_VOLCANIC_SANDSTONE.get(), SMOOTH_VOLCANIC_SANDSTONE_STAIRS.get(), SMOOTH_VOLCANIC_SANDSTONE_SLAB.get(),
                CUT_VOLCANIC_SANDSTONE.get(), CUT_VOLCANIC_SANDSTONE_SLAB.get(),

                MOLTEN_SCORIA.get(), MOSSY_SCORIA.get(),
                SCORIA.get(), SCORIA_STAIRS.get(), SCORIA_SLAB.get(), SCORIA_WALL.get(),
                POLISHED_SCORIA.get(), POLISHED_SCORIA_STAIRS.get(), POLISHED_SCORIA_SLAB.get(), POLISHED_SCORIA_WALL.get(),
                SCORIA_BRICKS.get(), SCORIA_BRICK_STAIRS.get(), SCORIA_BRICK_SLAB.get(), SCORIA_BRICK_WALL.get(),
                SMOOTH_SCORIA.get(), SMOOTH_SCORIA_STAIRS.get(), SMOOTH_SCORIA_SLAB.get(), SMOOTH_SCORIA_WALL.get(),
                CHISELED_SCORIA_BRICKS.get(),

                WHITE_PEBBLED_SEA_GLASS.get(),
                WHITE_SEA_GLASS.get(), WHITE_SEA_GLASS_PANE.get(),
                WHITE_SEA_GLASS_BRICKS.get(), WHITE_SEA_GLASS_BRICK_STAIRS.get(), WHITE_SEA_GLASS_BRICK_SLAB.get(),
                WHITE_SEA_GLASS_LAMP.get(), WHITE_NETTED_SEA_GLASS_LAMP.get(), WHITE_MOSAIC_SEA_GLASS_LAMP.get(),

                LIGHT_GRAY_PEBBLED_SEA_GLASS.get(),
                LIGHT_GRAY_SEA_GLASS.get(), LIGHT_GRAY_SEA_GLASS_PANE.get(),
                LIGHT_GRAY_SEA_GLASS_BRICKS.get(), LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get(), LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get(),
                LIGHT_GRAY_SEA_GLASS_LAMP.get(), LIGHT_GRAY_NETTED_SEA_GLASS_LAMP.get(), LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP.get(),

                GRAY_PEBBLED_SEA_GLASS.get(),
                GRAY_SEA_GLASS.get(), GRAY_SEA_GLASS_PANE.get(),
                GRAY_SEA_GLASS_BRICKS.get(), GRAY_SEA_GLASS_BRICK_STAIRS.get(), GRAY_SEA_GLASS_BRICK_SLAB.get(),
                GRAY_SEA_GLASS_LAMP.get(), GRAY_NETTED_SEA_GLASS_LAMP.get(), GRAY_MOSAIC_SEA_GLASS_LAMP.get(),

                BLACK_PEBBLED_SEA_GLASS.get(),
                BLACK_SEA_GLASS.get(), BLACK_SEA_GLASS_PANE.get(),
                BLACK_SEA_GLASS_BRICKS.get(), BLACK_SEA_GLASS_BRICK_STAIRS.get(), BLACK_SEA_GLASS_BRICK_SLAB.get(),
                BLACK_SEA_GLASS_LAMP.get(), BLACK_NETTED_SEA_GLASS_LAMP.get(), BLACK_MOSAIC_SEA_GLASS_LAMP.get(),

                BROWN_PEBBLED_SEA_GLASS.get(),
                BROWN_SEA_GLASS.get(), BROWN_SEA_GLASS_PANE.get(),
                BROWN_SEA_GLASS_BRICKS.get(), BROWN_SEA_GLASS_BRICK_STAIRS.get(), BROWN_SEA_GLASS_BRICK_SLAB.get(),
                BROWN_SEA_GLASS_LAMP.get(), BROWN_NETTED_SEA_GLASS_LAMP.get(), BROWN_MOSAIC_SEA_GLASS_LAMP.get(),

                RED_PEBBLED_SEA_GLASS.get(),
                RED_SEA_GLASS.get(), RED_SEA_GLASS_PANE.get(),
                RED_SEA_GLASS_BRICKS.get(), RED_SEA_GLASS_BRICK_STAIRS.get(), RED_SEA_GLASS_BRICK_SLAB.get(),
                RED_SEA_GLASS_LAMP.get(), RED_NETTED_SEA_GLASS_LAMP.get(), RED_MOSAIC_SEA_GLASS_LAMP.get(),

                ORANGE_PEBBLED_SEA_GLASS.get(),
                ORANGE_SEA_GLASS.get(), ORANGE_SEA_GLASS_PANE.get(),
                ORANGE_SEA_GLASS_BRICKS.get(), ORANGE_SEA_GLASS_BRICK_STAIRS.get(), ORANGE_SEA_GLASS_BRICK_SLAB.get(),
                ORANGE_SEA_GLASS_LAMP.get(), ORANGE_NETTED_SEA_GLASS_LAMP.get(), ORANGE_MOSAIC_SEA_GLASS_LAMP.get(),

                YELLOW_PEBBLED_SEA_GLASS.get(),
                YELLOW_SEA_GLASS.get(), YELLOW_SEA_GLASS_PANE.get(),
                YELLOW_SEA_GLASS_BRICKS.get(), YELLOW_SEA_GLASS_BRICK_STAIRS.get(), YELLOW_SEA_GLASS_BRICK_SLAB.get(),
                YELLOW_SEA_GLASS_LAMP.get(), YELLOW_NETTED_SEA_GLASS_LAMP.get(), YELLOW_MOSAIC_SEA_GLASS_LAMP.get(),

                LIME_PEBBLED_SEA_GLASS.get(),
                LIME_SEA_GLASS.get(), LIME_SEA_GLASS_PANE.get(),
                LIME_SEA_GLASS_BRICKS.get(), LIME_SEA_GLASS_BRICK_STAIRS.get(), LIME_SEA_GLASS_BRICK_SLAB.get(),
                LIME_SEA_GLASS_LAMP.get(), LIME_NETTED_SEA_GLASS_LAMP.get(), LIME_MOSAIC_SEA_GLASS_LAMP.get(),

                GREEN_PEBBLED_SEA_GLASS.get(),
                GREEN_SEA_GLASS.get(), GREEN_SEA_GLASS_PANE.get(),
                GREEN_SEA_GLASS_BRICKS.get(), GREEN_SEA_GLASS_BRICK_STAIRS.get(), GREEN_SEA_GLASS_BRICK_SLAB.get(),
                GREEN_SEA_GLASS_LAMP.get(), GREEN_NETTED_SEA_GLASS_LAMP.get(), GREEN_MOSAIC_SEA_GLASS_LAMP.get(),

                CYAN_PEBBLED_SEA_GLASS.get(),
                CYAN_SEA_GLASS.get(), CYAN_SEA_GLASS_PANE.get(),
                CYAN_SEA_GLASS_BRICKS.get(), CYAN_SEA_GLASS_BRICK_STAIRS.get(), CYAN_SEA_GLASS_BRICK_SLAB.get(),
                CYAN_SEA_GLASS_LAMP.get(), CYAN_NETTED_SEA_GLASS_LAMP.get(), CYAN_MOSAIC_SEA_GLASS_LAMP.get(),

                LIGHT_BLUE_PEBBLED_SEA_GLASS.get(),
                LIGHT_BLUE_SEA_GLASS.get(), LIGHT_BLUE_SEA_GLASS_PANE.get(),
                LIGHT_BLUE_SEA_GLASS_BRICKS.get(), LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get(), LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get(),
                LIGHT_BLUE_SEA_GLASS_LAMP.get(), LIGHT_BLUE_NETTED_SEA_GLASS_LAMP.get(), LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP.get(),

                BLUE_PEBBLED_SEA_GLASS.get(),
                BLUE_SEA_GLASS.get(), BLUE_SEA_GLASS_PANE.get(),
                BLUE_SEA_GLASS_BRICKS.get(), BLUE_SEA_GLASS_BRICK_STAIRS.get(), BLUE_SEA_GLASS_BRICK_SLAB.get(),
                BLUE_SEA_GLASS_LAMP.get(), BLUE_NETTED_SEA_GLASS_LAMP.get(), BLUE_MOSAIC_SEA_GLASS_LAMP.get(),

                PURPLE_PEBBLED_SEA_GLASS.get(),
                PURPLE_SEA_GLASS.get(), PURPLE_SEA_GLASS_PANE.get(),
                PURPLE_SEA_GLASS_BRICKS.get(), PURPLE_SEA_GLASS_BRICK_STAIRS.get(), PURPLE_SEA_GLASS_BRICK_SLAB.get(),
                PURPLE_SEA_GLASS_LAMP.get(), PURPLE_NETTED_SEA_GLASS_LAMP.get(), PURPLE_MOSAIC_SEA_GLASS_LAMP.get(),

                MAGENTA_PEBBLED_SEA_GLASS.get(),
                MAGENTA_SEA_GLASS.get(), MAGENTA_SEA_GLASS_PANE.get(),
                MAGENTA_SEA_GLASS_BRICKS.get(), MAGENTA_SEA_GLASS_BRICK_STAIRS.get(), MAGENTA_SEA_GLASS_BRICK_SLAB.get(),
                MAGENTA_SEA_GLASS_LAMP.get(), MAGENTA_NETTED_SEA_GLASS_LAMP.get(), MAGENTA_MOSAIC_SEA_GLASS_LAMP.get(),

                PINK_PEBBLED_SEA_GLASS.get(),
                PINK_SEA_GLASS.get(), PINK_SEA_GLASS_PANE.get(),
                PINK_SEA_GLASS_BRICKS.get(), PINK_SEA_GLASS_BRICK_STAIRS.get(), PINK_SEA_GLASS_BRICK_SLAB.get(),
                PINK_SEA_GLASS_LAMP.get(), PINK_NETTED_SEA_GLASS_LAMP.get(), PINK_MOSAIC_SEA_GLASS_LAMP.get()
        );

        this.tag(BlockTags.STAIRS).add(
                VOLCANIC_SANDSTONE_STAIRS.get(),
                CORALINE_SANDSTONE_STAIRS.get(),
                SCORIA_STAIRS.get(),
                POLISHED_SCORIA_STAIRS.get(),
                SCORIA_BRICK_STAIRS.get(),
                SMOOTH_SCORIA_STAIRS.get(),
                WHITE_SEA_GLASS_BRICK_STAIRS.get(),
                LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get(),
                GRAY_SEA_GLASS_BRICK_STAIRS.get(),
                BLACK_SEA_GLASS_BRICK_STAIRS.get(),
                BROWN_SEA_GLASS_BRICK_STAIRS.get(),
                RED_SEA_GLASS_BRICK_STAIRS.get(),
                ORANGE_SEA_GLASS_BRICK_STAIRS.get(),
                YELLOW_SEA_GLASS_BRICK_STAIRS.get(),
                LIME_SEA_GLASS_BRICK_STAIRS.get(),
                GREEN_SEA_GLASS_BRICK_STAIRS.get(),
                CYAN_SEA_GLASS_BRICK_STAIRS.get(),
                LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get(),
                BLUE_SEA_GLASS_BRICK_STAIRS.get(),
                PURPLE_SEA_GLASS_BRICK_STAIRS.get(),
                MAGENTA_SEA_GLASS_BRICK_STAIRS.get(),
                PINK_SEA_GLASS_BRICK_STAIRS.get(),
                SPIKY_SHELL_BRICK_STAIRS.get(),
                CLAM_SHELL_BRICK_STAIRS.get(),
                HORN_SHELL_BRICK_STAIRS.get(),
                SWIRL_SHELL_BRICK_STAIRS.get(),
                SPIRAL_SHELL_BRICK_STAIRS.get(),
                PYRAMID_SHELL_BRICK_STAIRS.get()
        );

        this.tag(BlockTags.SLABS).add(
                VOLCANIC_SANDSTONE_SLAB.get(),
                CORALINE_SANDSTONE_SLAB.get(),
                SCORIA_SLAB.get(),
                POLISHED_SCORIA_SLAB.get(),
                SCORIA_BRICK_SLAB.get(),
                SMOOTH_SCORIA_SLAB.get(),
                CUT_CORALINE_SANDSTONE_SLAB.get(),
                CUT_VOLCANIC_SANDSTONE_SLAB.get(),
                WHITE_SEA_GLASS_BRICK_SLAB.get(),
                LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get(),
                GRAY_SEA_GLASS_BRICK_SLAB.get(),
                BLACK_SEA_GLASS_BRICK_SLAB.get(),
                BROWN_SEA_GLASS_BRICK_SLAB.get(),
                RED_SEA_GLASS_BRICK_SLAB.get(),
                ORANGE_SEA_GLASS_BRICK_SLAB.get(),
                YELLOW_SEA_GLASS_BRICK_SLAB.get(),
                LIME_SEA_GLASS_BRICK_SLAB.get(),
                GREEN_SEA_GLASS_BRICK_SLAB.get(),
                CYAN_SEA_GLASS_BRICK_SLAB.get(),
                LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get(),
                BLUE_SEA_GLASS_BRICK_SLAB.get(),
                PURPLE_SEA_GLASS_BRICK_SLAB.get(),
                MAGENTA_SEA_GLASS_BRICK_SLAB.get(),
                PINK_SEA_GLASS_BRICK_SLAB.get(),
                SPIKY_SHELL_BRICK_SLAB.get(),
                CLAM_SHELL_BRICK_SLAB.get(),
                HORN_SHELL_BRICK_SLAB.get(),
                SWIRL_SHELL_BRICK_SLAB.get(),
                SPIRAL_SHELL_BRICK_SLAB.get(),
                PYRAMID_SHELL_BRICK_SLAB.get()
        );

        this.tag(BlockTags.WALLS).add(
                VOLCANIC_SANDSTONE_WALL.get(),
                CORALINE_SANDSTONE_WALL.get(),
                SCORIA_WALL.get(),
                POLISHED_SCORIA_WALL.get(),
                SCORIA_BRICK_WALL.get(),
                SMOOTH_SCORIA_WALL.get()
        );

        this.tag(BlockTags.CLIMBABLE).add(
                FISHING_NET.get()
        );
    }


    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Block Tags";
    }
}

package com.barlinc.seafarer.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.barlinc.seafarer.registry.SeafarerBlocks.*;

public class SeafarerLootTableProvider extends LootTableProvider {

    public SeafarerLootTableProvider(PackOutput output) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(
                new LootTableProvider.SubProviderEntry(SeafarerBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
    }

    private static class SeafarerBlockLoot extends BlockLootSubProvider {

        private final Set<Block> knownBlocks = new HashSet<>();

        protected SeafarerBlockLoot() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void add(Block block, LootTable.Builder builder) {
            super.add(block, builder);
            this.knownBlocks.add(block);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return this.knownBlocks;
        }

        @Override
        protected void generate() {
            this.dropSelf(WHITE_PEBBLED_SEA_GLASS.get());
            this.dropSelf(WHITE_SEA_GLASS.get());
            this.dropSelf(WHITE_SEA_GLASS_PANE.get());
            this.dropSelf(WHITE_SEA_GLASS_BRICKS.get());
            this.dropSelf(WHITE_SEA_GLASS_BRICK_STAIRS.get());
            this.add(WHITE_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(WHITE_SEA_GLASS_LAMP.get());
            this.dropSelf(WHITE_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(WHITE_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(LIGHT_GRAY_PEBBLED_SEA_GLASS.get());
            this.dropSelf(LIGHT_GRAY_SEA_GLASS.get());
            this.dropSelf(LIGHT_GRAY_SEA_GLASS_PANE.get());
            this.dropSelf(LIGHT_GRAY_SEA_GLASS_BRICKS.get());
            this.dropSelf(LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get());
            this.add(LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(LIGHT_GRAY_SEA_GLASS_LAMP.get());
            this.dropSelf(LIGHT_GRAY_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(GRAY_PEBBLED_SEA_GLASS.get());
            this.dropSelf(GRAY_SEA_GLASS.get());
            this.dropSelf(GRAY_SEA_GLASS_PANE.get());
            this.dropSelf(GRAY_SEA_GLASS_BRICKS.get());
            this.dropSelf(GRAY_SEA_GLASS_BRICK_STAIRS.get());
            this.add(GRAY_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(GRAY_SEA_GLASS_LAMP.get());
            this.dropSelf(GRAY_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(GRAY_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(BLACK_PEBBLED_SEA_GLASS.get());
            this.dropSelf(BLACK_SEA_GLASS.get());
            this.dropSelf(BLACK_SEA_GLASS_PANE.get());
            this.dropSelf(BLACK_SEA_GLASS_BRICKS.get());
            this.dropSelf(BLACK_SEA_GLASS_BRICK_STAIRS.get());
            this.add(BLACK_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(BLACK_SEA_GLASS_LAMP.get());
            this.dropSelf(BLACK_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(BLACK_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(BROWN_PEBBLED_SEA_GLASS.get());
            this.dropSelf(BROWN_SEA_GLASS.get());
            this.dropSelf(BROWN_SEA_GLASS_PANE.get());
            this.dropSelf(BROWN_SEA_GLASS_BRICKS.get());
            this.dropSelf(BROWN_SEA_GLASS_BRICK_STAIRS.get());
            this.add(BROWN_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(BROWN_SEA_GLASS_LAMP.get());
            this.dropSelf(BROWN_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(BROWN_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(RED_PEBBLED_SEA_GLASS.get());
            this.dropSelf(RED_SEA_GLASS.get());
            this.dropSelf(RED_SEA_GLASS_PANE.get());
            this.dropSelf(RED_SEA_GLASS_BRICKS.get());
            this.dropSelf(RED_SEA_GLASS_BRICK_STAIRS.get());
            this.add(RED_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(RED_SEA_GLASS_LAMP.get());
            this.dropSelf(RED_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(RED_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(ORANGE_PEBBLED_SEA_GLASS.get());
            this.dropSelf(ORANGE_SEA_GLASS.get());
            this.dropSelf(ORANGE_SEA_GLASS_PANE.get());
            this.dropSelf(ORANGE_SEA_GLASS_BRICKS.get());
            this.dropSelf(ORANGE_SEA_GLASS_BRICK_STAIRS.get());
            this.add(ORANGE_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(ORANGE_SEA_GLASS_LAMP.get());
            this.dropSelf(ORANGE_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(ORANGE_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(YELLOW_PEBBLED_SEA_GLASS.get());
            this.dropSelf(YELLOW_SEA_GLASS.get());
            this.dropSelf(YELLOW_SEA_GLASS_PANE.get());
            this.dropSelf(YELLOW_SEA_GLASS_BRICKS.get());
            this.dropSelf(YELLOW_SEA_GLASS_BRICK_STAIRS.get());
            this.add(YELLOW_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(YELLOW_SEA_GLASS_LAMP.get());
            this.dropSelf(YELLOW_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(YELLOW_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(LIME_PEBBLED_SEA_GLASS.get());
            this.dropSelf(LIME_SEA_GLASS.get());
            this.dropSelf(LIME_SEA_GLASS_PANE.get());
            this.dropSelf(LIME_SEA_GLASS_BRICKS.get());
            this.dropSelf(LIME_SEA_GLASS_BRICK_STAIRS.get());
            this.add(LIME_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(LIME_SEA_GLASS_LAMP.get());
            this.dropSelf(LIME_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(LIME_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(GREEN_PEBBLED_SEA_GLASS.get());
            this.dropSelf(GREEN_SEA_GLASS.get());
            this.dropSelf(GREEN_SEA_GLASS_PANE.get());
            this.dropSelf(GREEN_SEA_GLASS_BRICKS.get());
            this.dropSelf(GREEN_SEA_GLASS_BRICK_STAIRS.get());
            this.add(GREEN_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(GREEN_SEA_GLASS_LAMP.get());
            this.dropSelf(GREEN_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(GREEN_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(CYAN_PEBBLED_SEA_GLASS.get());
            this.dropSelf(CYAN_SEA_GLASS.get());
            this.dropSelf(CYAN_SEA_GLASS_PANE.get());
            this.dropSelf(CYAN_SEA_GLASS_BRICKS.get());
            this.dropSelf(CYAN_SEA_GLASS_BRICK_STAIRS.get());
            this.add(CYAN_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(CYAN_SEA_GLASS_LAMP.get());
            this.dropSelf(CYAN_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(CYAN_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(LIGHT_BLUE_PEBBLED_SEA_GLASS.get());
            this.dropSelf(LIGHT_BLUE_SEA_GLASS.get());
            this.dropSelf(LIGHT_BLUE_SEA_GLASS_PANE.get());
            this.dropSelf(LIGHT_BLUE_SEA_GLASS_BRICKS.get());
            this.dropSelf(LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get());
            this.add(LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(LIGHT_BLUE_SEA_GLASS_LAMP.get());
            this.dropSelf(LIGHT_BLUE_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(BLUE_PEBBLED_SEA_GLASS.get());
            this.dropSelf(BLUE_SEA_GLASS.get());
            this.dropSelf(BLUE_SEA_GLASS_PANE.get());
            this.dropSelf(BLUE_SEA_GLASS_BRICKS.get());
            this.dropSelf(BLUE_SEA_GLASS_BRICK_STAIRS.get());
            this.add(BLUE_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(BLUE_SEA_GLASS_LAMP.get());
            this.dropSelf(BLUE_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(BLUE_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(PURPLE_PEBBLED_SEA_GLASS.get());
            this.dropSelf(PURPLE_SEA_GLASS.get());
            this.dropSelf(PURPLE_SEA_GLASS_PANE.get());
            this.dropSelf(PURPLE_SEA_GLASS_BRICKS.get());
            this.dropSelf(PURPLE_SEA_GLASS_BRICK_STAIRS.get());
            this.add(PURPLE_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(PURPLE_SEA_GLASS_LAMP.get());
            this.dropSelf(PURPLE_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(PURPLE_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(MAGENTA_PEBBLED_SEA_GLASS.get());
            this.dropSelf(MAGENTA_SEA_GLASS.get());
            this.dropSelf(MAGENTA_SEA_GLASS_PANE.get());
            this.dropSelf(MAGENTA_SEA_GLASS_BRICKS.get());
            this.dropSelf(MAGENTA_SEA_GLASS_BRICK_STAIRS.get());
            this.add(MAGENTA_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(MAGENTA_SEA_GLASS_LAMP.get());
            this.dropSelf(MAGENTA_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(MAGENTA_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(PINK_PEBBLED_SEA_GLASS.get());
            this.dropSelf(PINK_SEA_GLASS.get());
            this.dropSelf(PINK_SEA_GLASS_PANE.get());
            this.dropSelf(PINK_SEA_GLASS_BRICKS.get());
            this.dropSelf(PINK_SEA_GLASS_BRICK_STAIRS.get());
            this.add(PINK_SEA_GLASS_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(PINK_SEA_GLASS_LAMP.get());
            this.dropSelf(PINK_NETTED_SEA_GLASS_LAMP.get());
            this.dropSelf(PINK_MOSAIC_SEA_GLASS_LAMP.get());

            this.dropSelf(MOLTEN_SCORIA.get());
            this.add(MOSSY_SCORIA.get(), block -> this.createSingleItemTableWithSilkTouch(block, SCORIA.get()));
            this.dropSelf(SCORIA.get());
            this.dropSelf(SCORIA_STAIRS.get());
            this.add(SCORIA_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(SCORIA_WALL.get());
            this.dropSelf(POLISHED_SCORIA.get());
            this.dropSelf(POLISHED_SCORIA_STAIRS.get());
            this.add(POLISHED_SCORIA_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(POLISHED_SCORIA_WALL.get());
            this.dropSelf(SCORIA_BRICKS.get());
            this.dropSelf(SCORIA_BRICK_STAIRS.get());
            this.add(SCORIA_BRICK_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(SCORIA_BRICK_WALL.get());
            this.dropSelf(SMOOTH_SCORIA.get());
            this.dropSelf(SMOOTH_SCORIA_STAIRS.get());
            this.add(SMOOTH_SCORIA_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(SMOOTH_SCORIA_WALL.get());
            this.dropSelf(CHISELED_SCORIA_BRICKS.get());

            this.dropSelf(VOLCANIC_SAND.get());
            this.dropSelf(VOLCANIC_SANDSTONE.get());
            this.dropSelf(VOLCANIC_SANDSTONE_STAIRS.get());
            this.add(VOLCANIC_SANDSTONE_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(VOLCANIC_SANDSTONE_WALL.get());
            this.dropSelf(CHISELED_VOLCANIC_SANDSTONE.get());
            this.dropSelf(SMOOTH_VOLCANIC_SANDSTONE.get());
            this.dropSelf(SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
            this.add(SMOOTH_VOLCANIC_SANDSTONE_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(CUT_VOLCANIC_SANDSTONE.get());
            this.dropSelf(CUT_VOLCANIC_SANDSTONE_SLAB.get());

            this.dropSelf(CORALINE_SAND.get());
            this.dropSelf(CORALINE_SANDSTONE.get());
            this.dropSelf(CORALINE_SANDSTONE_STAIRS.get());
            this.add(CORALINE_SANDSTONE_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(CORALINE_SANDSTONE_WALL.get());
            this.dropSelf(CHISELED_CORALINE_SANDSTONE.get());
            this.dropSelf(SMOOTH_CORALINE_SANDSTONE.get());
            this.dropSelf(SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
            this.add(SMOOTH_CORALINE_SANDSTONE_SLAB.get(), this::createSlabItemTable);
            this.dropSelf(CUT_CORALINE_SANDSTONE.get());
            this.dropSelf(CUT_CORALINE_SANDSTONE_SLAB.get());

            this.dropSelf(PYRAMID_SHELL.get());
            this.dropSelf(PYRAMID_SHELL_BRICKS.get());
            this.dropSelf(PYRAMID_SHELL_BRICK_STAIRS.get());
            this.add(PYRAMID_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(SPIRAL_SHELL.get());
            this.dropSelf(SPIRAL_SHELL_BRICKS.get());
            this.dropSelf(SPIRAL_SHELL_BRICK_STAIRS.get());
            this.add(SPIRAL_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(SWIRL_SHELL.get());
            this.dropSelf(SWIRL_SHELL_BRICKS.get());
            this.dropSelf(SWIRL_SHELL_BRICK_STAIRS.get());
            this.add(SWIRL_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(HORN_SHELL.get());
            this.dropSelf(HORN_SHELL_BRICKS.get());
            this.dropSelf(HORN_SHELL_BRICK_STAIRS.get());
            this.add(HORN_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(CLAM_SHELL.get());
            this.dropSelf(CLAM_SHELL_BRICKS.get());
            this.dropSelf(CLAM_SHELL_BRICK_STAIRS.get());
            this.add(CLAM_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(SPIKY_SHELL.get());
            this.dropSelf(SPIKY_SHELL_BRICKS.get());
            this.dropSelf(SPIKY_SHELL_BRICK_STAIRS.get());
            this.add(SPIKY_SHELL_BRICK_SLAB.get(), this::createSlabItemTable);

            this.dropSelf(DEAD_VERDANT_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_VERDANT_CORAL.get());
            this.dropWhenSilkTouch(DEAD_VERDANT_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_VERDANT_CORAL_WALL_FAN.get());

            this.dropSelf(DEAD_TURQUOISE_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_TURQUOISE_CORAL.get());
            this.dropWhenSilkTouch(DEAD_TURQUOISE_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_TURQUOISE_CORAL_WALL_FAN.get());

            this.dropSelf(DEAD_OLIVE_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_OLIVE_CORAL.get());
            this.dropWhenSilkTouch(DEAD_OLIVE_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_OLIVE_CORAL_WALL_FAN.get());

            this.dropSelf(DEAD_MAROON_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_MAROON_CORAL.get());
            this.dropWhenSilkTouch(DEAD_MAROON_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_MAROON_CORAL_WALL_FAN.get());

            this.dropSelf(DEAD_CERULEAN_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_CERULEAN_CORAL.get());
            this.dropWhenSilkTouch(DEAD_CERULEAN_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_CERULEAN_CORAL_WALL_FAN.get());

            this.dropSelf(DEAD_AMBER_CORAL_BLOCK.get());
            this.dropWhenSilkTouch(DEAD_AMBER_CORAL.get());
            this.dropWhenSilkTouch(DEAD_AMBER_CORAL_FAN.get());
            this.dropWhenSilkTouch(DEAD_AMBER_CORAL_WALL_FAN.get());

            this.add(VERDANT_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_VERDANT_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(VERDANT_CORAL.get());
            this.dropWhenSilkTouch(VERDANT_CORAL_FAN.get());
            this.dropWhenSilkTouch(VERDANT_CORAL_WALL_FAN.get());

            this.add(TURQUOISE_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_TURQUOISE_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(TURQUOISE_CORAL.get());
            this.dropWhenSilkTouch(TURQUOISE_CORAL_FAN.get());
            this.dropWhenSilkTouch(TURQUOISE_CORAL_WALL_FAN.get());

            this.add(OLIVE_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_OLIVE_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(OLIVE_CORAL.get());
            this.dropWhenSilkTouch(OLIVE_CORAL_FAN.get());
            this.dropWhenSilkTouch(OLIVE_CORAL_WALL_FAN.get());

            this.add(MAROON_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_MAROON_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(MAROON_CORAL.get());
            this.dropWhenSilkTouch(MAROON_CORAL_FAN.get());
            this.dropWhenSilkTouch(MAROON_CORAL_WALL_FAN.get());

            this.add(CERULEAN_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_CERULEAN_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(CERULEAN_CORAL.get());
            this.dropWhenSilkTouch(CERULEAN_CORAL_FAN.get());
            this.dropWhenSilkTouch(CERULEAN_CORAL_WALL_FAN.get());

            this.add(AMBER_CORAL_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, DEAD_AMBER_CORAL_BLOCK.get()));
            this.dropWhenSilkTouch(AMBER_CORAL.get());
            this.dropWhenSilkTouch(AMBER_CORAL_FAN.get());
            this.dropWhenSilkTouch(AMBER_CORAL_WALL_FAN.get());

            this.dropWhenSilkTouch(PURPLE_ZOA.get());
            this.dropWhenSilkTouch(CYAN_ZOA.get());
            this.dropWhenSilkTouch(ORANGE_ZOA.get());
            this.dropWhenSilkTouch(RED_ZOA.get());

            this.dropWhenSilkTouch(BLUE_CHRISTMAS_TREE_WORM.get());
            this.dropWhenSilkTouch(YELLOW_CHRISTMAS_TREE_WORM.get());
            this.dropWhenSilkTouch(RED_CHRISTMAS_TREE_WORM.get());
            this.dropWhenSilkTouch(WHITE_CHRISTMAS_TREE_WORM.get());
            this.dropWhenSilkTouch(BLACK_CHRISTMAS_TREE_WORM.get());

            this.add(MAGENTA_FLOWERING_JUNGLE_LEAVES.get(), block -> createLeavesDrops(block, Blocks.JUNGLE_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
            this.add(BLUE_FLOWERING_JUNGLE_LEAVES.get(), block -> createLeavesDrops(block, Blocks.JUNGLE_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
            this.add(YELLOW_FLOWERING_JUNGLE_LEAVES.get(), block -> createLeavesDrops(block, Blocks.JUNGLE_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
            this.add(ORANGE_FLOWERING_JUNGLE_LEAVES.get(), block -> createLeavesDrops(block, Blocks.JUNGLE_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));
            this.add(WHITE_FLOWERING_JUNGLE_LEAVES.get(), block -> createLeavesDrops(block, Blocks.JUNGLE_SAPLING, 0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F));

            this.add(BLUE_VOLCANIC_GRASS.get(), SeafarerBlockLoot::createShearsOnlyDrop);
            this.add(YELLOW_VOLCANIC_GRASS.get(), SeafarerBlockLoot::createShearsOnlyDrop);
            this.add(ORANGE_VOLCANIC_GRASS.get(), SeafarerBlockLoot::createShearsOnlyDrop);
            this.dropPottedContents(POTTED_BLUE_VOLCANIC_GRASS.get());
            this.dropPottedContents(POTTED_YELLOW_VOLCANIC_GRASS.get());
            this.dropPottedContents(POTTED_ORANGE_VOLCANIC_GRASS.get());

            this.tallFlower(SAPPHIRE_COWBELL.get());
            this.tallFlower(DAWNFLAME.get());

            this.dropSelf(WIDOWBLOOM.get());
            this.dropPottedContents(POTTED_WIDOWBLOOM.get());

            this.dropSelf(TWILIGHT_BLADE.get());
            this.dropPottedContents(POTTED_TWILIGHT_BLADE.get());

            this.dropSelf(SILK_LILIES.get());
            this.dropPottedContents(POTTED_SILK_LILIES.get());

            this.dropSelf(FIERY_DUSTER.get());
            this.dropPottedContents(POTTED_FIERY_DUSTER.get());

            this.dropSelf(COASTAL_WILDFLOWER.get());
            this.dropPottedContents(POTTED_COASTAL_WILDFLOWER.get());

            this.dropSelf(COASTAL_LAVENDER.get());
            this.dropPottedContents(POTTED_COASTAL_LAVENDER.get());

            this.dropSelf(SEA_HOLLY.get());
            this.dropPottedContents(POTTED_SEA_HOLLY.get());

            this.dropSelf(SEA_THRIFT.get());
            this.dropPottedContents(POTTED_SEA_THRIFT.get());

            this.createDoublePlantWithSeedDrops(TALL_BEACHGRASS.get(), BEACHGRASS.get());

            this.createGrassDrops(BEACHGRASS.get());
            this.dropPottedContents(POTTED_BEACHGRASS.get());

            this.createGrassDrops(SHORT_BEACHGRASS.get());
            this.dropPottedContents(POTTED_SHORT_BEACHGRASS.get());

            this.dropSelf(FISHING_NET.get());
        }

        private void tallFlower(Block block) {
            this.add(block, block1 -> createSinglePropConditionTable(block1, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        }
    }
}

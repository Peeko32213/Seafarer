package com.barlinc.seafarer;

import com.barlinc.seafarer.registry.SeafarerBlocks;
import com.barlinc.seafarer.registry.SeafarerItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Seafarer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SEAFARER_TAB = CREATIVE_TABS.register("seafarer_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SeafarerItems.SEAFARER.get()))
                    .title(Component.translatable("itemGroup.seafarer"))
                    .displayItems((parameters, output) -> {

                        // Spawn eggs
                        SeafarerItems.ITEMS.getEntries().forEach(spawnEgg -> {
                            if ((spawnEgg.get() instanceof ForgeSpawnEggItem)) {
                                output.accept(spawnEgg.get());
                            }
                        });

                        // horseshoe crab
                        output.accept(SeafarerItems.HORSESHOE_CRAB_BUCKET.get());
                        output.accept(SeafarerItems.RAW_HORSESHOE_CRAB.get());
                        output.accept(SeafarerItems.COOKED_HORSESHOE_CRAB.get());

                        // shore crab
                        output.accept(SeafarerItems.SHORE_CRAB_BUCKET.get());
                        output.accept(SeafarerItems.RAW_SHORE_CRAB_LEG.get());
                        output.accept(SeafarerItems.COOKED_SHORE_CRAB_LEG.get());

                        output.accept(SeafarerItems.SOY_SAUCE.get());

                        // junk
                        output.accept(SeafarerBlocks.FISHING_NET.get());

                        output.accept(SeafarerBlocks.SHORT_BEACHGRASS.get());
                        output.accept(SeafarerBlocks.BEACHGRASS.get());
                        output.accept(SeafarerBlocks.TALL_BEACHGRASS.get());
                        output.accept(SeafarerBlocks.SEA_THRIFT.get());
                        output.accept(SeafarerBlocks.SEA_HOLLY.get());
                        output.accept(SeafarerBlocks.COASTAL_LAVENDER.get());
                        output.accept(SeafarerBlocks.COASTAL_WILDFLOWER.get());
                        output.accept(SeafarerBlocks.FIERY_DUSTER.get());
                        output.accept(SeafarerBlocks.SILK_LILIES.get());
                        output.accept(SeafarerBlocks.TWILIGHT_BLADE.get());
                        output.accept(SeafarerBlocks.WIDOWBLOOM.get());
                        output.accept(SeafarerBlocks.DAWNFLAME.get());
                        output.accept(SeafarerBlocks.SAPPHIRE_COWBELL.get());
                        output.accept(SeafarerBlocks.ORANGE_VOLCANIC_GRASS.get());
                        output.accept(SeafarerBlocks.YELLOW_VOLCANIC_GRASS.get());
                        output.accept(SeafarerBlocks.BLUE_VOLCANIC_GRASS.get());
                        output.accept(SeafarerBlocks.WHITE_FLOWERING_JUNGLE_LEAVES.get());
                        output.accept(SeafarerBlocks.ORANGE_FLOWERING_JUNGLE_LEAVES.get());
                        output.accept(SeafarerBlocks.YELLOW_FLOWERING_JUNGLE_LEAVES.get());
                        output.accept(SeafarerBlocks.BLUE_FLOWERING_JUNGLE_LEAVES.get());
                        output.accept(SeafarerBlocks.MAGENTA_FLOWERING_JUNGLE_LEAVES.get());
                        output.accept(SeafarerBlocks.BLACK_CHRISTMAS_TREE_WORM.get());
                        output.accept(SeafarerBlocks.WHITE_CHRISTMAS_TREE_WORM.get());
                        output.accept(SeafarerBlocks.RED_CHRISTMAS_TREE_WORM.get());
                        output.accept(SeafarerBlocks.YELLOW_CHRISTMAS_TREE_WORM.get());
                        output.accept(SeafarerBlocks.BLUE_CHRISTMAS_TREE_WORM.get());
                        output.accept(SeafarerBlocks.RED_ZOA.get());
                        output.accept(SeafarerBlocks.ORANGE_ZOA.get());
                        output.accept(SeafarerBlocks.CYAN_ZOA.get());
                        output.accept(SeafarerBlocks.PURPLE_ZOA.get());
                        output.accept(SeafarerBlocks.ANTLER_GORGONIAN.get());
                        output.accept(SeafarerBlocks.ATTUM_GORGONIAN.get());
                        output.accept(SeafarerBlocks.FLORAL_GORGONIAN.get());
                        output.accept(SeafarerBlocks.TOWERING_GORGONIAN.get());

                        // starfish
                        output.accept(SeafarerBlocks.CORAL_STARFISH.get());
                        output.accept(SeafarerBlocks.LAGOON_STARFISH.get());
                        output.accept(SeafarerBlocks.PLUMERIA_STARFISH.get());
                        output.accept(SeafarerBlocks.SKY_BLUE_STARFISH.get());
                        output.accept(SeafarerBlocks.SUNNY_STARFISH.get());
                        output.accept(SeafarerBlocks.SUNSET_STARFISH.get());
                        output.accept(SeafarerItems.DRIED_STARFISH.get());

                        // corals
                        output.accept(SeafarerBlocks.AMBER_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.AMBER_CORAL.get());
                        output.accept(SeafarerItems.AMBER_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.CERULEAN_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.CERULEAN_CORAL.get());
                        output.accept(SeafarerItems.CERULEAN_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.MAROON_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.MAROON_CORAL.get());
                        output.accept(SeafarerItems.MAROON_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.OLIVE_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.OLIVE_CORAL.get());
                        output.accept(SeafarerItems.OLIVE_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.TURQUOISE_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.TURQUOISE_CORAL.get());
                        output.accept(SeafarerItems.TURQUOISE_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.VERDANT_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.VERDANT_CORAL.get());
                        output.accept(SeafarerItems.VERDANT_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_AMBER_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_AMBER_CORAL.get());
                        output.accept(SeafarerItems.DEAD_AMBER_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_CERULEAN_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_CERULEAN_CORAL.get());
                        output.accept(SeafarerItems.DEAD_CERULEAN_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_MAROON_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_MAROON_CORAL.get());
                        output.accept(SeafarerItems.DEAD_MAROON_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_OLIVE_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_OLIVE_CORAL.get());
                        output.accept(SeafarerItems.DEAD_OLIVE_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_TURQUOISE_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_TURQUOISE_CORAL.get());
                        output.accept(SeafarerItems.DEAD_TURQUOISE_CORAL_FAN.get());

                        output.accept(SeafarerBlocks.DEAD_VERDANT_CORAL_BLOCK.get());
                        output.accept(SeafarerBlocks.DEAD_VERDANT_CORAL.get());
                        output.accept(SeafarerItems.DEAD_VERDANT_CORAL_FAN.get());

                        // spiky shell blocks
                        output.accept(SeafarerBlocks.SPIKY_SHELL.get());
                        output.accept(SeafarerBlocks.SPIKY_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.SPIKY_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.SPIKY_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.SPIKY_SHELL_PILLAR.get());

                        // clam shell blocks
                        output.accept(SeafarerBlocks.CLAM_SHELL.get());
                        output.accept(SeafarerBlocks.CLAM_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.CLAM_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.CLAM_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.CLAM_SHELL_PILLAR.get());

                        // horn shell blocks
                        output.accept(SeafarerBlocks.HORN_SHELL.get());
                        output.accept(SeafarerBlocks.HORN_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.HORN_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.HORN_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.HORN_SHELL_PILLAR.get());

                        // swirl shell blocks
                        output.accept(SeafarerBlocks.SWIRL_SHELL.get());
                        output.accept(SeafarerBlocks.SWIRL_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.SWIRL_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.SWIRL_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.SWIRL_SHELL_PILLAR.get());

                        // spiral shell blocks
                        output.accept(SeafarerBlocks.SPIRAL_SHELL.get());
                        output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.SPIRAL_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.SPIRAL_SHELL_PILLAR.get());

                        // pyramid shell blocks
                        output.accept(SeafarerBlocks.PYRAMID_SHELL.get());
                        output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICKS.get());
                        output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.PYRAMID_SHELL_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.PYRAMID_SHELL_PILLAR.get());

                        // misc sand
                        output.accept(SeafarerBlocks.SHELLY_SAND.get());
                        output.accept(SeafarerBlocks.STARRY_SAND.get());
                        output.accept(SeafarerBlocks.SEA_GLASS_SAND.get());

                        // coraline sand
                        output.accept(SeafarerBlocks.CORALINE_SAND.get());
                        output.accept(SeafarerBlocks.SHELLY_CORALINE_SAND.get());
                        output.accept(SeafarerBlocks.STARRY_CORALINE_SAND.get());
                        output.accept(SeafarerBlocks.CORALINE_SANDSTONE.get());
                        output.accept(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get());
                        output.accept(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get());
                        output.accept(SeafarerBlocks.CORALINE_SANDSTONE_WALL.get());
                        output.accept(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get());
                        output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE.get());
                        output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_STAIRS.get());
                        output.accept(SeafarerBlocks.SMOOTH_CORALINE_SANDSTONE_SLAB.get());
                        output.accept(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get());
                        output.accept(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get());

                        // volcanic sand
                        output.accept(SeafarerBlocks.VOLCANIC_SAND.get());
                        output.accept(SeafarerBlocks.SHELLY_VOLCANIC_SAND.get());
                        output.accept(SeafarerBlocks.STARRY_VOLCANIC_SAND.get());
                        output.accept(SeafarerBlocks.VOLCANIC_SANDSTONE.get());
                        output.accept(SeafarerBlocks.VOLCANIC_SANDSTONE_STAIRS.get());
                        output.accept(SeafarerBlocks.VOLCANIC_SANDSTONE_SLAB.get());
                        output.accept(SeafarerBlocks.VOLCANIC_SANDSTONE_WALL.get());
                        output.accept(SeafarerBlocks.CHISELED_VOLCANIC_SANDSTONE.get());
                        output.accept(SeafarerBlocks.SMOOTH_VOLCANIC_SANDSTONE.get());
                        output.accept(SeafarerBlocks.SMOOTH_VOLCANIC_SANDSTONE_STAIRS.get());
                        output.accept(SeafarerBlocks.SMOOTH_VOLCANIC_SANDSTONE_SLAB.get());
                        output.accept(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE.get());
                        output.accept(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE_SLAB.get());

                        // scoria
                        output.accept(SeafarerBlocks.MOLTEN_SCORIA.get());
                        output.accept(SeafarerBlocks.MOSSY_SCORIA.get());
                        output.accept(SeafarerBlocks.SCORIA.get());
                        output.accept(SeafarerBlocks.SCORIA_STAIRS.get());
                        output.accept(SeafarerBlocks.SCORIA_SLAB.get());
                        output.accept(SeafarerBlocks.SCORIA_WALL.get());

                        output.accept(SeafarerBlocks.POLISHED_SCORIA.get());
                        output.accept(SeafarerBlocks.POLISHED_SCORIA_STAIRS.get());
                        output.accept(SeafarerBlocks.POLISHED_SCORIA_SLAB.get());
                        output.accept(SeafarerBlocks.POLISHED_SCORIA_WALL.get());

                        output.accept(SeafarerBlocks.SCORIA_BRICKS.get());
                        output.accept(SeafarerBlocks.SCORIA_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.SCORIA_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.SCORIA_BRICK_WALL.get());

                        output.accept(SeafarerBlocks.SMOOTH_SCORIA.get());
                        output.accept(SeafarerBlocks.SMOOTH_SCORIA_STAIRS.get());
                        output.accept(SeafarerBlocks.SMOOTH_SCORIA_SLAB.get());
                        output.accept(SeafarerBlocks.SMOOTH_SCORIA_WALL.get());

                        output.accept(SeafarerBlocks.CHISELED_SCORIA_BRICKS.get());

                        // volcanic core
                        output.accept(SeafarerBlocks.VOLCANIC_CORE.get());

                        output.accept(SeafarerItems.SEA_GLASS_PEBBLES.get());

                        // white sea glass
                        output.accept(SeafarerBlocks.WHITE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.WHITE_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.WHITE_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.WHITE_MOSAIC_SEA_GLASS_LAMP.get());

                        // light gray sea glass
                        output.accept(SeafarerBlocks.LIGHT_GRAY_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP.get());

                        // gray sea glass
                        output.accept(SeafarerBlocks.GRAY_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.GRAY_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.GRAY_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.GRAY_MOSAIC_SEA_GLASS_LAMP.get());

                        // black sea glass
                        output.accept(SeafarerBlocks.BLACK_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.BLACK_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BLACK_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BLACK_MOSAIC_SEA_GLASS_LAMP.get());

                        output.accept(SeafarerBlocks.BROWN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.BROWN_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BROWN_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BROWN_MOSAIC_SEA_GLASS_LAMP.get());

                        output.accept(SeafarerBlocks.RED_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.RED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.RED_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.RED_MOSAIC_SEA_GLASS_LAMP.get());

                        output.accept(SeafarerBlocks.ORANGE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.ORANGE_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.ORANGE_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.ORANGE_MOSAIC_SEA_GLASS_LAMP.get());

                        output.accept(SeafarerBlocks.YELLOW_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.YELLOW_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.YELLOW_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.YELLOW_MOSAIC_SEA_GLASS_LAMP.get());

                        // lime sea glass
                        output.accept(SeafarerBlocks.LIME_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.LIME_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIME_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIME_MOSAIC_SEA_GLASS_LAMP.get());

                        // green sea glass
                        output.accept(SeafarerBlocks.GREEN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.GREEN_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.GREEN_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.GREEN_MOSAIC_SEA_GLASS_LAMP.get());

                        // light blue sea glass
                        output.accept(SeafarerBlocks.LIGHT_BLUE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP.get());

                        // cyan sea glass
                        output.accept(SeafarerBlocks.CYAN_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.CYAN_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.CYAN_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.CYAN_MOSAIC_SEA_GLASS_LAMP.get());

                        // blue sea glass
                        output.accept(SeafarerBlocks.BLUE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.BLUE_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BLUE_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.BLUE_MOSAIC_SEA_GLASS_LAMP.get());

                        // purple sea glass
                        output.accept(SeafarerBlocks.PURPLE_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.PURPLE_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.PURPLE_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.PURPLE_MOSAIC_SEA_GLASS_LAMP.get());

                        // magenta sea glass
                        output.accept(SeafarerBlocks.MAGENTA_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.MAGENTA_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.MAGENTA_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.MAGENTA_MOSAIC_SEA_GLASS_LAMP.get());

                        output.accept(SeafarerBlocks.PINK_PEBBLED_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS_PANE.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS_BRICKS.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS_BRICK_STAIRS.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS_BRICK_SLAB.get());
                        output.accept(SeafarerBlocks.PINK_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.PINK_NETTED_SEA_GLASS_LAMP.get());
                        output.accept(SeafarerBlocks.PINK_MOSAIC_SEA_GLASS_LAMP.get());

            }).build());
}

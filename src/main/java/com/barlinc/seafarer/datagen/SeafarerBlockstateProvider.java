package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.blocks.RotatableDoublePlantBlock;
import com.barlinc.seafarer.blocks.StarfishBlock;
import com.barlinc.seafarer.registry.SeafarerBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

import static com.barlinc.seafarer.registry.SeafarerBlocks.*;

public class SeafarerBlockstateProvider extends BlockStateProvider {

    public SeafarerBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Seafarer.MOD_ID, exFileHelper);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(Seafarer.MOD_ID, "block/" + path);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // white sea glass
        this.cubeAllBlock(WHITE_PEBBLED_SEA_GLASS);
        this.glassBlock(WHITE_SEA_GLASS);
        this.cubeAllBlock(WHITE_SEA_GLASS_BRICKS);
        this.slab(WHITE_SEA_GLASS_BRICK_SLAB, this.blockTexture(WHITE_SEA_GLASS_BRICKS.get()));
        this.stairs(WHITE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(WHITE_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(WHITE_SEA_GLASS_LAMP);
        this.pillar(WHITE_NETTED_SEA_GLASS_LAMP);
        this.pillar(WHITE_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(WHITE_SEA_GLASS_PANE, this.blockTexture(WHITE_SEA_GLASS.get()));

        // light gray sea glass
        this.cubeAllBlock(LIGHT_GRAY_PEBBLED_SEA_GLASS);
        this.glassBlock(LIGHT_GRAY_SEA_GLASS);
        this.cubeAllBlock(LIGHT_GRAY_SEA_GLASS_BRICKS);
        this.slab(LIGHT_GRAY_SEA_GLASS_BRICK_SLAB, this.blockTexture(LIGHT_GRAY_SEA_GLASS_BRICKS.get()));
        this.stairs(LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIGHT_GRAY_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(LIGHT_GRAY_SEA_GLASS_LAMP);
        this.pillar(LIGHT_GRAY_NETTED_SEA_GLASS_LAMP);
        this.pillar(LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(LIGHT_GRAY_SEA_GLASS_PANE, this.blockTexture(LIGHT_GRAY_SEA_GLASS.get()));

        // gray sea glass
        this.cubeAllBlock(GRAY_PEBBLED_SEA_GLASS);
        this.glassBlock(GRAY_SEA_GLASS);
        this.cubeAllBlock(GRAY_SEA_GLASS_BRICKS);
        this.slab(GRAY_SEA_GLASS_BRICK_SLAB, this.blockTexture(GRAY_SEA_GLASS_BRICKS.get()));
        this.stairs(GRAY_SEA_GLASS_BRICK_STAIRS, this.blockTexture(GRAY_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(GRAY_SEA_GLASS_LAMP);
        this.pillar(GRAY_NETTED_SEA_GLASS_LAMP);
        this.pillar(GRAY_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(GRAY_SEA_GLASS_PANE, this.blockTexture(GRAY_SEA_GLASS.get()));

        // black sea glass
        this.cubeAllBlock(BLACK_PEBBLED_SEA_GLASS);
        this.glassBlock(BLACK_SEA_GLASS);
        this.cubeAllBlock(BLACK_SEA_GLASS_BRICKS);
        this.slab(BLACK_SEA_GLASS_BRICK_SLAB, this.blockTexture(BLACK_SEA_GLASS_BRICKS.get()));
        this.stairs(BLACK_SEA_GLASS_BRICK_STAIRS, this.blockTexture(BLACK_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(BLACK_SEA_GLASS_LAMP);
        this.pillar(BLACK_NETTED_SEA_GLASS_LAMP);
        this.pillar(BLACK_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(BLACK_SEA_GLASS_PANE, this.blockTexture(BLACK_SEA_GLASS.get()));

        // brown sea glass
        this.cubeAllBlock(BROWN_PEBBLED_SEA_GLASS);
        this.glassBlock(BROWN_SEA_GLASS);
        this.cubeAllBlock(BROWN_SEA_GLASS_BRICKS);
        this.slab(BROWN_SEA_GLASS_BRICK_SLAB, this.blockTexture(BROWN_SEA_GLASS_BRICKS.get()));
        this.stairs(BROWN_SEA_GLASS_BRICK_STAIRS, this.blockTexture(BROWN_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(BROWN_SEA_GLASS_LAMP);
        this.pillar(BROWN_NETTED_SEA_GLASS_LAMP);
        this.pillar(BROWN_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(BROWN_SEA_GLASS_PANE, this.blockTexture(BROWN_SEA_GLASS.get()));

        // red sea glass
        this.cubeAllBlock(RED_PEBBLED_SEA_GLASS);
        this.glassBlock(RED_SEA_GLASS);
        this.cubeAllBlock(RED_SEA_GLASS_BRICKS);
        this.slab(RED_SEA_GLASS_BRICK_SLAB, this.blockTexture(RED_SEA_GLASS_BRICKS.get()));
        this.stairs(RED_SEA_GLASS_BRICK_STAIRS, this.blockTexture(RED_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(RED_SEA_GLASS_LAMP);
        this.pillar(RED_NETTED_SEA_GLASS_LAMP);
        this.pillar(RED_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(RED_SEA_GLASS_PANE, this.blockTexture(RED_SEA_GLASS.get()));

        // orange sea glass
        this.cubeAllBlock(ORANGE_PEBBLED_SEA_GLASS);
        this.glassBlock(ORANGE_SEA_GLASS);
        this.cubeAllBlock(ORANGE_SEA_GLASS_BRICKS);
        this.slab(ORANGE_SEA_GLASS_BRICK_SLAB, this.blockTexture(ORANGE_SEA_GLASS_BRICKS.get()));
        this.stairs(ORANGE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(ORANGE_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(ORANGE_SEA_GLASS_LAMP);
        this.pillar(ORANGE_NETTED_SEA_GLASS_LAMP);
        this.pillar(ORANGE_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(ORANGE_SEA_GLASS_PANE, this.blockTexture(ORANGE_SEA_GLASS.get()));

        // yellow sea glass
        this.cubeAllBlock(YELLOW_PEBBLED_SEA_GLASS);
        this.glassBlock(YELLOW_SEA_GLASS);
        this.cubeAllBlock(YELLOW_SEA_GLASS_BRICKS);
        this.slab(YELLOW_SEA_GLASS_BRICK_SLAB, this.blockTexture(YELLOW_SEA_GLASS_BRICKS.get()));
        this.stairs(YELLOW_SEA_GLASS_BRICK_STAIRS, this.blockTexture(YELLOW_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(YELLOW_SEA_GLASS_LAMP);
        this.pillar(YELLOW_NETTED_SEA_GLASS_LAMP);
        this.pillar(YELLOW_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(YELLOW_SEA_GLASS_PANE, this.blockTexture(YELLOW_SEA_GLASS.get()));

        // lime sea glass
        this.cubeAllBlock(LIME_PEBBLED_SEA_GLASS);
        this.glassBlock(LIME_SEA_GLASS);
        this.cubeAllBlock(LIME_SEA_GLASS_BRICKS);
        this.slab(LIME_SEA_GLASS_BRICK_SLAB, this.blockTexture(LIME_SEA_GLASS_BRICKS.get()));
        this.stairs(LIME_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIME_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(LIME_SEA_GLASS_LAMP);
        this.pillar(LIME_NETTED_SEA_GLASS_LAMP);
        this.pillar(LIME_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(LIME_SEA_GLASS_PANE, this.blockTexture(LIME_SEA_GLASS.get()));

        // green sea glass
        this.cubeAllBlock(GREEN_PEBBLED_SEA_GLASS);
        this.glassBlock(GREEN_SEA_GLASS);
        this.cubeAllBlock(GREEN_SEA_GLASS_BRICKS);
        this.slab(GREEN_SEA_GLASS_BRICK_SLAB, this.blockTexture(GREEN_SEA_GLASS_BRICKS.get()));
        this.stairs(GREEN_SEA_GLASS_BRICK_STAIRS, this.blockTexture(GREEN_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(GREEN_SEA_GLASS_LAMP);
        this.pillar(GREEN_NETTED_SEA_GLASS_LAMP);
        this.pillar(GREEN_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(GREEN_SEA_GLASS_PANE, this.blockTexture(GREEN_SEA_GLASS.get()));

        // cyan sea glass
        this.cubeAllBlock(CYAN_PEBBLED_SEA_GLASS);
        this.glassBlock(CYAN_SEA_GLASS);
        this.cubeAllBlock(CYAN_SEA_GLASS_BRICKS);
        this.slab(CYAN_SEA_GLASS_BRICK_SLAB, this.blockTexture(CYAN_SEA_GLASS_BRICKS.get()));
        this.stairs(CYAN_SEA_GLASS_BRICK_STAIRS, this.blockTexture(CYAN_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(CYAN_SEA_GLASS_LAMP);
        this.pillar(CYAN_NETTED_SEA_GLASS_LAMP);
        this.pillar(CYAN_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(CYAN_SEA_GLASS_PANE, this.blockTexture(CYAN_SEA_GLASS.get()));

        // light blue sea glass
        this.cubeAllBlock(LIGHT_BLUE_PEBBLED_SEA_GLASS);
        this.glassBlock(LIGHT_BLUE_SEA_GLASS);
        this.cubeAllBlock(LIGHT_BLUE_SEA_GLASS_BRICKS);
        this.slab(LIGHT_BLUE_SEA_GLASS_BRICK_SLAB, this.blockTexture(LIGHT_BLUE_SEA_GLASS_BRICKS.get()));
        this.stairs(LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(LIGHT_BLUE_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(LIGHT_BLUE_SEA_GLASS_LAMP);
        this.pillar(LIGHT_BLUE_NETTED_SEA_GLASS_LAMP);
        this.pillar(LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(LIGHT_BLUE_SEA_GLASS_PANE, this.blockTexture(LIGHT_BLUE_SEA_GLASS.get()));

        // blue sea glass
        this.cubeAllBlock(BLUE_PEBBLED_SEA_GLASS);
        this.glassBlock(BLUE_SEA_GLASS);
        this.cubeAllBlock(BLUE_SEA_GLASS_BRICKS);
        this.slab(BLUE_SEA_GLASS_BRICK_SLAB, this.blockTexture(BLUE_SEA_GLASS_BRICKS.get()));
        this.stairs(BLUE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(BLUE_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(BLUE_SEA_GLASS_LAMP);
        this.pillar(BLUE_NETTED_SEA_GLASS_LAMP);
        this.pillar(BLUE_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(BLUE_SEA_GLASS_PANE, this.blockTexture(BLUE_SEA_GLASS.get()));

        // purple sea glass
        this.cubeAllBlock(PURPLE_PEBBLED_SEA_GLASS);
        this.glassBlock(PURPLE_SEA_GLASS);
        this.cubeAllBlock(PURPLE_SEA_GLASS_BRICKS);
        this.slab(PURPLE_SEA_GLASS_BRICK_SLAB, this.blockTexture(PURPLE_SEA_GLASS_BRICKS.get()));
        this.stairs(PURPLE_SEA_GLASS_BRICK_STAIRS, this.blockTexture(PURPLE_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(PURPLE_SEA_GLASS_LAMP);
        this.pillar(PURPLE_NETTED_SEA_GLASS_LAMP);
        this.pillar(PURPLE_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(PURPLE_SEA_GLASS_PANE, this.blockTexture(PURPLE_SEA_GLASS.get()));

        // magenta sea glass
        this.cubeAllBlock(MAGENTA_PEBBLED_SEA_GLASS);
        this.glassBlock(MAGENTA_SEA_GLASS);
        this.cubeAllBlock(MAGENTA_SEA_GLASS_BRICKS);
        this.slab(MAGENTA_SEA_GLASS_BRICK_SLAB, this.blockTexture(MAGENTA_SEA_GLASS_BRICKS.get()));
        this.stairs(MAGENTA_SEA_GLASS_BRICK_STAIRS, this.blockTexture(MAGENTA_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(MAGENTA_SEA_GLASS_LAMP);
        this.pillar(MAGENTA_NETTED_SEA_GLASS_LAMP);
        this.pillar(MAGENTA_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(MAGENTA_SEA_GLASS_PANE, this.blockTexture(MAGENTA_SEA_GLASS.get()));

        // pink sea glass
        this.cubeAllBlock(PINK_PEBBLED_SEA_GLASS);
        this.glassBlock(PINK_SEA_GLASS);
        this.cubeAllBlock(PINK_SEA_GLASS_BRICKS);
        this.slab(PINK_SEA_GLASS_BRICK_SLAB, this.blockTexture(PINK_SEA_GLASS_BRICKS.get()));
        this.stairs(PINK_SEA_GLASS_BRICK_STAIRS, this.blockTexture(PINK_SEA_GLASS_BRICKS.get()));
        this.directionalBlock(PINK_SEA_GLASS_LAMP);
        this.pillar(PINK_NETTED_SEA_GLASS_LAMP);
        this.pillar(PINK_MOSAIC_SEA_GLASS_LAMP);
        this.glassPane(PINK_SEA_GLASS_PANE, this.blockTexture(PINK_SEA_GLASS.get()));

        // shell blocks
        this.cubeAllBlock(CLAM_SHELL_BRICKS);
        this.stairs(CLAM_SHELL_BRICK_STAIRS, this.blockTexture(CLAM_SHELL_BRICKS.get()));
        this.slab(CLAM_SHELL_BRICK_SLAB, this.blockTexture(CLAM_SHELL_BRICKS.get()));
        this.pillar(CLAM_SHELL_PILLAR);

        this.cubeAllBlock(HORN_SHELL_BRICKS);
        this.stairs(HORN_SHELL_BRICK_STAIRS, this.blockTexture(HORN_SHELL_BRICKS.get()));
        this.slab(HORN_SHELL_BRICK_SLAB, this.blockTexture(HORN_SHELL_BRICKS.get()));
        this.pillar(HORN_SHELL_PILLAR);

        this.cubeAllBlock(SPIKY_SHELL_BRICKS);
        this.stairs(SPIKY_SHELL_BRICK_STAIRS, this.blockTexture(SPIKY_SHELL_BRICKS.get()));
        this.slab(SPIKY_SHELL_BRICK_SLAB, this.blockTexture(SPIKY_SHELL_BRICKS.get()));
        this.pillar(SPIKY_SHELL_PILLAR);

        this.cubeAllBlock(SPIRAL_SHELL_BRICKS);
        this.stairs(SPIRAL_SHELL_BRICK_STAIRS, this.blockTexture(SPIRAL_SHELL_BRICKS.get()));
        this.slab(SPIRAL_SHELL_BRICK_SLAB, this.blockTexture(SPIRAL_SHELL_BRICKS.get()));
        this.pillar(SPIRAL_SHELL_PILLAR);

        this.cubeAllBlock(SWIRL_SHELL_BRICKS);
        this.stairs(SWIRL_SHELL_BRICK_STAIRS, this.blockTexture(SWIRL_SHELL_BRICKS.get()));
        this.slab(SWIRL_SHELL_BRICK_SLAB, this.blockTexture(SWIRL_SHELL_BRICKS.get()));
        this.pillar(SWIRL_SHELL_PILLAR);

        this.cubeAllBlock(PYRAMID_SHELL_BRICKS);
        this.stairs(PYRAMID_SHELL_BRICK_STAIRS, this.blockTexture(PYRAMID_SHELL_BRICKS.get()));
        this.slab(PYRAMID_SHELL_BRICK_SLAB, this.blockTexture(PYRAMID_SHELL_BRICKS.get()));
        this.pillar(PYRAMID_SHELL_PILLAR);

        this.pottedPlant(SEA_THRIFT, POTTED_SEA_THRIFT);
        this.pottedPlant(COASTAL_LAVENDER, POTTED_COASTAL_LAVENDER);
        this.pottedPlant(COASTAL_WILDFLOWER, POTTED_COASTAL_WILDFLOWER);

        this.pottedPlant(SEA_HOLLY, POTTED_SEA_HOLLY);
        this.pottedPlant(FIERY_DUSTER, POTTED_FIERY_DUSTER);
        this.pottedPlant(SILK_LILIES, POTTED_SILK_LILIES);
        this.pottedPlant(TWILIGHT_BLADE, POTTED_TWILIGHT_BLADE);
        this.pottedPlant(WIDOWBLOOM, POTTED_WIDOWBLOOM);

        this.tallPlant(DAWNFLAME);
        this.tallPlant(SAPPHIRE_COWBELL);

        // volcanic grass
        this.pottedPlant(BLUE_VOLCANIC_GRASS, POTTED_BLUE_VOLCANIC_GRASS);
        this.pottedPlant(ORANGE_VOLCANIC_GRASS, POTTED_ORANGE_VOLCANIC_GRASS);
        this.pottedPlant(YELLOW_VOLCANIC_GRASS, POTTED_YELLOW_VOLCANIC_GRASS);

        // corals
        this.cubeAllBlock(AMBER_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_AMBER_CORAL_BLOCK);
        this.simpleCross(DEAD_AMBER_CORAL);
        this.simpleCross(AMBER_CORAL);
        this.coralFan(DEAD_AMBER_CORAL_FAN, DEAD_AMBER_CORAL_WALL_FAN);
        this.coralFan(AMBER_CORAL_FAN, AMBER_CORAL_WALL_FAN);

        this.cubeAllBlock(CERULEAN_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_CERULEAN_CORAL_BLOCK);
        this.simpleCross(DEAD_CERULEAN_CORAL);
        this.simpleCross(CERULEAN_CORAL);
        this.coralFan(DEAD_CERULEAN_CORAL_FAN, DEAD_CERULEAN_CORAL_WALL_FAN);
        this.coralFan(CERULEAN_CORAL_FAN, CERULEAN_CORAL_WALL_FAN);

        this.cubeAllBlock(MAROON_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_MAROON_CORAL_BLOCK);
        this.simpleCross(DEAD_MAROON_CORAL);
        this.simpleCross(MAROON_CORAL);
        this.coralFan(DEAD_MAROON_CORAL_FAN, DEAD_MAROON_CORAL_WALL_FAN);
        this.coralFan(MAROON_CORAL_FAN, MAROON_CORAL_WALL_FAN);

        this.cubeAllBlock(OLIVE_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_OLIVE_CORAL_BLOCK);
        this.simpleCross(DEAD_OLIVE_CORAL);
        this.simpleCross(OLIVE_CORAL);
        this.coralFan(DEAD_OLIVE_CORAL_FAN, DEAD_OLIVE_CORAL_WALL_FAN);
        this.coralFan(OLIVE_CORAL_FAN, OLIVE_CORAL_WALL_FAN);

        this.cubeAllBlock(TURQUOISE_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_TURQUOISE_CORAL_BLOCK);
        this.simpleCross(DEAD_TURQUOISE_CORAL);
        this.simpleCross(TURQUOISE_CORAL);
        this.coralFan(DEAD_TURQUOISE_CORAL_FAN, DEAD_TURQUOISE_CORAL_WALL_FAN);
        this.coralFan(TURQUOISE_CORAL_FAN, TURQUOISE_CORAL_WALL_FAN);

        this.cubeAllBlock(VERDANT_CORAL_BLOCK);
        this.cubeAllBlock(DEAD_VERDANT_CORAL_BLOCK);
        this.simpleCross(DEAD_VERDANT_CORAL);
        this.simpleCross(VERDANT_CORAL);
        this.coralFan(DEAD_VERDANT_CORAL_FAN, DEAD_VERDANT_CORAL_WALL_FAN);
        this.coralFan(VERDANT_CORAL_FAN, VERDANT_CORAL_WALL_FAN);

        // christmas tree worms
        this.christmasTreeWorm(BLACK_CHRISTMAS_TREE_WORM);
        this.christmasTreeWorm(YELLOW_CHRISTMAS_TREE_WORM);
        this.christmasTreeWorm(RED_CHRISTMAS_TREE_WORM);
        this.christmasTreeWorm(BLUE_CHRISTMAS_TREE_WORM);
        this.christmasTreeWorm(WHITE_CHRISTMAS_TREE_WORM);

        // zoas
        this.zoa(CYAN_ZOA);
        this.zoa(ORANGE_ZOA);
        this.zoa(RED_ZOA);
        this.zoa(PURPLE_ZOA);

        // gorgonians
        this.largeGorgonian(ANTLER_GORGONIAN);
        this.largeGorgonian(ATTUM_GORGONIAN);
        this.largeGorgonian(FLORAL_GORGONIAN);
        this.largeGorgonian(TOWERING_GORGONIAN);

        // starfish
        this.starfish(CORAL_STARFISH);
        this.starfish(LAGOON_STARFISH);
        this.starfish(PLUMERIA_STARFISH);
        this.starfish(SKY_BLUE_STARFISH);
        this.starfish(SUNNY_STARFISH);
        this.starfish(SUNSET_STARFISH);

        this.randomBlock(STARRY_SAND, 4);
        this.randomBlock(SHELLY_SAND, 3);
        this.randomBlock(SEA_GLASS_SAND, 4);

        this.cubeAllBlock(CORALINE_SAND);
        this.randomBlock(STARRY_CORALINE_SAND, 4);
        this.randomBlock(SHELLY_CORALINE_SAND, 3);
        this.wall(CORALINE_SANDSTONE_WALL, this.blockTexture(CORALINE_SANDSTONE.get()));
        this.cubeAllBlock(SMOOTH_CORALINE_SANDSTONE);
        this.stairs(SMOOTH_CORALINE_SANDSTONE_STAIRS, this.blockTexture(SMOOTH_CORALINE_SANDSTONE.get()));
        this.slab(SMOOTH_CORALINE_SANDSTONE_SLAB, this.blockTexture(SMOOTH_CORALINE_SANDSTONE.get()));
        this.simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get(), this.existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get(), this.existingModel((getName(SeafarerBlocks.CORALINE_SANDSTONE_STAIRS.get()))));
        this.simpleBlockItem(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.CUT_CORALINE_SANDSTONE.get()))));
        this.simpleBlockItem(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get(), this.existingModel((getName(SeafarerBlocks.CUT_CORALINE_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.CHISELED_CORALINE_SANDSTONE.get()))));

        this.cubeAllBlock(VOLCANIC_SAND);
        this.randomBlock(STARRY_VOLCANIC_SAND, 4);
        this.randomBlock(SHELLY_VOLCANIC_SAND, 3);
        this.wall(VOLCANIC_SANDSTONE_WALL, this.blockTexture(VOLCANIC_SANDSTONE.get()));
        this.cubeAllBlock(SMOOTH_VOLCANIC_SANDSTONE);
        this.stairs(SMOOTH_VOLCANIC_SANDSTONE_STAIRS, this.blockTexture(SMOOTH_VOLCANIC_SANDSTONE.get()));
        this.slab(SMOOTH_VOLCANIC_SANDSTONE_SLAB, this.blockTexture(SMOOTH_VOLCANIC_SANDSTONE.get()));
        this.simpleBlockItem(SeafarerBlocks.VOLCANIC_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.VOLCANIC_SANDSTONE.get()))));
        this.simpleBlockItem(SeafarerBlocks.VOLCANIC_SANDSTONE_SLAB.get(), this.existingModel((getName(SeafarerBlocks.VOLCANIC_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeafarerBlocks.VOLCANIC_SANDSTONE_STAIRS.get(), this.existingModel((getName(SeafarerBlocks.VOLCANIC_SANDSTONE_STAIRS.get()))));
        this.simpleBlockItem(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE.get()))));
        this.simpleBlockItem(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE_SLAB.get(), this.existingModel((getName(SeafarerBlocks.CUT_VOLCANIC_SANDSTONE_SLAB.get()))));
        this.simpleBlockItem(SeafarerBlocks.CHISELED_VOLCANIC_SANDSTONE.get(), this.existingModel((getName(SeafarerBlocks.CHISELED_VOLCANIC_SANDSTONE.get()))));

        // scoria
        this.cubeAllBlock(SCORIA);
        this.stairs(SCORIA_STAIRS, this.blockTexture(SCORIA.get()));
        this.slab(SCORIA_SLAB, this.blockTexture(SCORIA.get()));
        this.wall(SCORIA_WALL, this.blockTexture(SCORIA.get()));

        this.cubeAllBlock(POLISHED_SCORIA);
        this.stairs(POLISHED_SCORIA_STAIRS, this.blockTexture(POLISHED_SCORIA.get()));
        this.slab(POLISHED_SCORIA_SLAB, this.blockTexture(POLISHED_SCORIA.get()));
        this.wall(POLISHED_SCORIA_WALL, this.blockTexture(POLISHED_SCORIA.get()));

        this.cubeAllBlock(SCORIA_BRICKS);
        this.stairs(SCORIA_BRICK_STAIRS, this.blockTexture(SCORIA_BRICKS.get()));
        this.slab(SCORIA_BRICK_SLAB, this.blockTexture(SCORIA_BRICKS.get()));
        this.wall(SCORIA_BRICK_WALL, this.blockTexture(SCORIA_BRICKS.get()));

        this.cubeAllBlock(SMOOTH_SCORIA);
        this.stairs(SMOOTH_SCORIA_STAIRS, this.blockTexture(SMOOTH_SCORIA.get()));
        this.slab(SMOOTH_SCORIA_SLAB, this.blockTexture(SMOOTH_SCORIA.get()));
        this.wall(SMOOTH_SCORIA_WALL, this.blockTexture(SMOOTH_SCORIA.get()));

        this.cubeAllBlock(CHISELED_SCORIA_BRICKS);

        this.emissiveOverlayBlock(MOLTEN_SCORIA);

        this.floweringJungleLeaves(WHITE_FLOWERING_JUNGLE_LEAVES);
        this.floweringJungleLeaves(ORANGE_FLOWERING_JUNGLE_LEAVES);
        this.floweringJungleLeaves(YELLOW_FLOWERING_JUNGLE_LEAVES);
        this.floweringJungleLeaves(BLUE_FLOWERING_JUNGLE_LEAVES);
        this.floweringJungleLeaves(MAGENTA_FLOWERING_JUNGLE_LEAVES);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private String getName(Block block) {
        return key(block).toString().replace(Seafarer.MOD_ID + ":", "");
    }

    public void block(Block block) {
        this.simpleBlock(block);
        this.blockItem(block);
    }

    public void block(RegistryObject<Block> block) {
        this.block(block.get());
    }

    public void blockItem(Block block) {
        this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
    }

    public void blockItem(RegistryObject<Block> block) {
        this.blockItem(block.get());
    }

    public void directionalBlock(RegistryObject<Block> block, ResourceLocation sideTexture, ResourceLocation bottomTexture, ResourceLocation topTexture) {
        this.directionalBlock(block.get(), models().cubeBottomTop(name(block.get()), sideTexture, bottomTexture, topTexture));
        this.blockItem(block);
    }

    public void directionalBlock(RegistryObject<Block> block) {
        ResourceLocation blockTexture = blockTexture(block.get());
        this.directionalBlock(block, suffix(blockTexture, "_side"), suffix(blockTexture, "_bottom"), suffix(blockTexture, "_top"));
    }

    public static ResourceLocation suffix(ResourceLocation resourceLocation, String suffix) {
        return new ResourceLocation(resourceLocation.getNamespace(), resourceLocation.getPath() + suffix);
    }

    @Override
    public String getName() {
        return "Block States: " + Seafarer.MOD_ID;
    }

    // updated

    // item
    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(getItemName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = getItemName(item);
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc(folder.format(name)));
    }

    // block
    private void cubeAllBlock(RegistryObject<Block> block) {
        this.simpleBlock(block.get());
        this.itemModel(block);
    }

    private void cubeAllBlockWithRenderType(RegistryObject<Block> block, String renderType) {
        this.simpleBlock(block.get(), models().getBuilder(name(block.get())).parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/cube_all"))).renderType(renderType).texture("all", blockTexture(block.get())));
        this.itemModel(block);
    }

    private void glassBlock(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), models().getBuilder(name(block.get())).parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/cube_all"))).renderType("translucent").texture("all", blockTexture(block.get())));
        this.itemModel(block);
    }

    private void stairs(RegistryObject<Block> stairs, ResourceLocation texture) {
        this.stairsBlock((StairBlock) stairs.get(), texture);
        this.itemModel(stairs);
    }

    private void slab(RegistryObject<Block> slab, ResourceLocation texture) {
        this.slabBlock((SlabBlock) slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void wall(RegistryObject<Block> wall, ResourceLocation texture) {
        this.wallBlock((WallBlock) wall.get(), texture);
        this.itemModels().wallInventory(getItemName(wall.get()), texture);
    }

    private void pillar(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    public void pillarWithBottom(RegistryObject<Block> pillar) {
        ResourceLocation blockTexture = this.blockTexture(pillar.get());
        this.directionalBlock(pillar, suffix(blockTexture, "_side"), suffix(blockTexture, "_bottom"), suffix(blockTexture, "_top"));
        this.itemModel(pillar);
    }

    private void pillarNoTop(RegistryObject<Block> pillar) {
        this.axisBlock((RotatedPillarBlock) pillar.get(), this.blockTexture(pillar.get()), this.modLoc("block/" + getItemName(pillar.get()) + "_top"));
        this.itemModel(pillar);
    }

    private void glassPane(RegistryObject<Block> pane, ResourceLocation texture) {
        this.paneBlockWithRenderType((IronBarsBlock) pane.get(), texture, this.modLoc("block/" + getItemName(pane.get()) + "_top"), "translucent");
        this.itemModels().withExistingParent(getItemName(pane.get()), "item/generated").texture("layer0", this.modLoc("block/" + getItemName(pane.get()).replace("_pane", "")));
    }

    private void wood(RegistryObject<Block> log, ResourceLocation texture) {
        this.axisBlock((RotatedPillarBlock) log.get(), texture, texture);
        this.itemModel(log);
    }

    private void fence(RegistryObject<Block> fence, ResourceLocation texture) {
        this.fenceBlock((FenceBlock) fence.get(), texture);
        this.itemModels().fenceInventory(getItemName(fence.get()), texture);
    }

    private void fenceGate(RegistryObject<Block> gate, ResourceLocation texture) {
        this.fenceGateBlock((FenceGateBlock) gate.get(), texture);
        this.itemModel(gate);
    }

    private void trapdoor(RegistryObject<Block> trapdoor) {
        this.trapdoorBlock((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true);
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void trapdoorCutout(RegistryObject<Block> trapdoor) {
        this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(getItemName(trapdoor.get()), this.modLoc("block/" + getItemName(trapdoor.get()) + "_bottom"));
    }

    private void door(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlock((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"));
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void doorCutout(RegistryObject<Block> door) {
        String name = getItemName(door.get());
        this.doorBlockWithRenderType((DoorBlock) door.get(), name.replace("_door", ""), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top"), "cutout");
        this.generatedItem(door.get(), TextureFolder.ITEM);
    }

    private void button(RegistryObject<Block> button, ResourceLocation texture) {
        this.buttonBlock((ButtonBlock) button.get(), texture);
        this.itemModels().buttonInventory(getItemName(button.get()), texture);
    }

    private void pressurePlate(RegistryObject<Block> pressurePlate, ResourceLocation texture) {
        this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), texture);
        this.itemModel(pressurePlate);
    }

    private void leaves(RegistryObject<Block> leaves) {
        this.simpleBlock(leaves.get(), this.models().withExistingParent(getItemName(leaves.get()), "block/leaves").texture("all", this.blockTexture(leaves.get())));
        this.itemModel(leaves);
    }

    private void simpleCross(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), this.models().cross(getItemName(block.get()), this.blockTexture(block.get())).renderType("cutout"));
        this.generatedItem(block.get(), TextureFolder.BLOCK);
    }

    private void tallPlant(RegistryObject<Block> flower) {
        String name = getItemName(flower.get());
        Function<String, ModelFile> model = s -> this.models().cross(name + "_" + s, this.modLoc("block/" + name + "_" + s)).renderType("cutout");
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_top"));
        this.getVariantBuilder(flower.get()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(model.apply("top"))).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(model.apply("bottom")));
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(pot.get()), "block/flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture(plant.get()));
        this.simpleCross(plant);
        this.generatedItem(plant.get(), TextureFolder.BLOCK);
    }

    private void coralFan(RegistryObject<Block> coralFan, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(coralFan.get()), "block/coral_fan").texture("fan", texture).renderType("cutout");
        this.simpleBlock(coralFan.get(), model);
    }

    private void coralWallFan(RegistryObject<Block> coralFan, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(getBlockName(coralFan.get()), "block/coral_wall_fan").texture("fan", texture).renderType("cutout");
        this.horizontalBlock(coralFan.get(), model);
    }

    private void coralFan(RegistryObject<Block> coralFan, RegistryObject<Block> coralWallFan) {
        this.coralFan(coralFan, this.blockTexture(coralFan.get()));
        this.coralWallFan(coralWallFan, this.blockTexture(coralFan.get()));
        this.generatedItem(coralFan.get(), TextureFolder.BLOCK);
    }

    private void christmasTreeWorm(RegistryObject<Block> worm) {
        ResourceLocation texture = this.blockTexture(worm.get());
        this.simpleBlock(worm.get(), this.models().withExistingParent(getItemName(worm.get()), "seafarer:block/christmas_tree_worm").texture("worm", texture));
        this.generatedItem(worm.get(), TextureFolder.ITEM);
    }

    private void zoa(RegistryObject<Block> zoa) {
        ResourceLocation texture = this.blockTexture(zoa.get());
        this.simpleBlock(zoa.get(), this.models().withExistingParent(getItemName(zoa.get()), "seafarer:block/zoa").texture("zoa", texture));
        this.generatedItem(zoa.get(), TextureFolder.ITEM);
    }

    private void largeGorgonian(RegistryObject<Block> gorgonian) {
        ResourceLocation texture = this.blockTexture(gorgonian.get());
        String name = getItemName(gorgonian.get());
        ModelFile largeGorgonianTop = this.models().withExistingParent(name + "_top", "seafarer:block/large_gorgonian_top").texture("top", texture + "_top");
        ModelFile largeGorgonianBottom = this.models().withExistingParent(name + "_bottom", "seafarer:block/large_gorgonian_bottom").texture("bottom", texture + "_bottom");
        this.getVariantBuilder(gorgonian.get()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).with(RotatableDoublePlantBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel(largeGorgonianTop)).partialState().partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).with(RotatableDoublePlantBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel(largeGorgonianBottom)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).with(RotatableDoublePlantBlock.FACING, Direction.EAST).addModels(new ConfiguredModel(largeGorgonianTop, 0, 90, false)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).with(RotatableDoublePlantBlock.FACING, Direction.EAST).addModels(new ConfiguredModel(largeGorgonianBottom, 0, 90, false)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).with(RotatableDoublePlantBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel(largeGorgonianTop, 0, 180, false)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).with(RotatableDoublePlantBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel(largeGorgonianBottom, 0, 180, false)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).with(RotatableDoublePlantBlock.FACING, Direction.WEST).addModels(new ConfiguredModel(largeGorgonianTop, 0, 270, false)).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).with(RotatableDoublePlantBlock.FACING, Direction.WEST).addModels(new ConfiguredModel(largeGorgonianBottom, 0, 270, false));
        this.generatedItem(gorgonian.get(), TextureFolder.ITEM);
    }

    private void starfish(RegistryObject<Block> block) {
        ResourceLocation texture = this.blockTexture(block.get());
        String name = getItemName(block.get());
        this.generatedItem(block.get(), TextureFolder.ITEM);
        for (int starfishAmount = 1; starfishAmount < 4; starfishAmount++) {
            ModelFile starfish = this.models().withExistingParent(name + "_" + (starfishAmount - 1), "seafarer:block/starfish").texture("starfish", texture + "_" + (starfishAmount - 1));
            ModelFile starfish_alt = this.models().withExistingParent(name + "_alt_" + (starfishAmount - 1), "seafarer:block/starfish_alt").texture("starfish", texture + "_" + (starfishAmount - 1));
            this.getVariantBuilder(block.get()).partialState().with(StarfishBlock.FACING, Direction.UP).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish), new ConfiguredModel(starfish, 0, 90, false), new ConfiguredModel(starfish, 0, 180, false), new ConfiguredModel(starfish, 0, 270, false)).partialState().with(StarfishBlock.FACING, Direction.DOWN).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish, 180, 0, false), new ConfiguredModel(starfish, 180, 90, false), new ConfiguredModel(starfish, 180, 180, false), new ConfiguredModel(starfish, 180, 270, false)).partialState().with(StarfishBlock.FACING, Direction.NORTH).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish, 90, 0, false), new ConfiguredModel(starfish, 270, 180, false), new ConfiguredModel(starfish_alt, 90, 0, false), new ConfiguredModel(starfish_alt, 270, 180, false)).partialState().with(StarfishBlock.FACING, Direction.SOUTH).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish, 90, 180, false), new ConfiguredModel(starfish, 270, 0, false), new ConfiguredModel(starfish_alt, 90, 180, false), new ConfiguredModel(starfish_alt, 270, 0, false)).partialState().with(StarfishBlock.FACING, Direction.EAST).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish, 90, 90, false), new ConfiguredModel(starfish, 270, 270, false), new ConfiguredModel(starfish_alt, 90, 90, false), new ConfiguredModel(starfish_alt, 270, 270, false)).partialState().with(StarfishBlock.FACING, Direction.WEST).with(StarfishBlock.STARFISH_AMOUNT, starfishAmount).addModels(new ConfiguredModel(starfish, 90, 270, false), new ConfiguredModel(starfish, 270, 90, false), new ConfiguredModel(starfish_alt, 90, 270, false), new ConfiguredModel(starfish_alt, 270, 90, false));
        }
    }

    private void randomBlock(RegistryObject<Block> block, int variants) {
        String name = getBlockName(block.get());
        Function<Integer, ModelFile> model = i -> this.models().cubeAll(name + "_" + i, this.modLoc("block/" + name + "_" + i));
        for (int j = 0; j <= variants - 1; j++) {
            this.getVariantBuilder(block.get()).partialState().addModels(new ConfiguredModel(model.apply(j)));
        }
        this.itemModels().withExistingParent(name, this.modLoc("block/" + name + "_0"));
    }

    private void floweringJungleLeaves(RegistryObject<Block> leaves) {
        String name = getItemName(leaves.get());
        ResourceLocation base_texture = this.blockTexture(Blocks.JUNGLE_LEAVES);
        ResourceLocation flowers_0 = new ResourceLocation(this.blockTexture(leaves.get()).getNamespace(), this.blockTexture(leaves.get()).getPath() + "_overlay_0");
        ResourceLocation flowers_1 = new ResourceLocation(this.blockTexture(leaves.get()).getNamespace(), this.blockTexture(leaves.get()).getPath() + "_overlay_1");
        ModelFile flowering_leaves_0 = this.models().withExistingParent(name + "_0", "seafarer:block/overlay_leaves").texture("all", base_texture).texture("overlay", flowers_0);
        ModelFile flowering_leaves_1 = this.models().withExistingParent(name + "_1", "seafarer:block/overlay_leaves").texture("all", base_texture).texture("overlay", flowers_1);
        this.itemModels().withExistingParent(name, this.modLoc("block/" + name + "_0"));
        this.getVariantBuilder(leaves.get()).partialState().addModels(new ConfiguredModel(flowering_leaves_0), new ConfiguredModel(flowering_leaves_1));
    }

    private void emissiveOverlayBlock(RegistryObject<Block> block) {
        ResourceLocation texture = this.blockTexture(block.get());
        ResourceLocation glow = new ResourceLocation(texture.getNamespace(), texture.getPath() + "_glow");
        this.simpleBlock(block.get(), this.models().withExistingParent(getItemName(block.get()), "seafarer:block/emissive_block").texture("all", texture).texture("glow", glow));
        this.itemModel(block);
    }

    // utils
    private static String getItemName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private enum TextureFolder {
        ITEM, BLOCK;
        public String format(String itemName) {
            return this.name().toLowerCase() + '/' + itemName;
        }
    }
}

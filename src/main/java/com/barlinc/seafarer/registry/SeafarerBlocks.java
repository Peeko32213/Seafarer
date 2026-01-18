package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.blocks.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SeafarerBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Seafarer.MOD_ID);
    public static List<RegistryObject<? extends Block>> BLOCK_TRANSLATIONS = new ArrayList<>();

    // white sea glass
    public static final RegistryObject<Block> WHITE_PEBBLED_SEA_GLASS = registerBlock("white_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_SEA_GLASS = registerBlock("white_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_SEA_GLASS_PANE = registerBlock("white_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_SEA_GLASS_BRICKS = registerBlock("white_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_SEA_GLASS_BRICK_STAIRS = registerBlock("white_sea_glass_brick_stairs", () -> new StairBlock(() -> WHITE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(WHITE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> WHITE_SEA_GLASS_BRICK_SLAB = registerBlock("white_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(WHITE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> WHITE_SEA_GLASS_LAMP = registerBlock("white_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_NETTED_SEA_GLASS_LAMP = registerBlock("white_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_MOSAIC_SEA_GLASS_LAMP = registerBlock("white_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.SNOW)));

    // light gray sea glass
    public static final RegistryObject<Block> LIGHT_GRAY_PEBBLED_SEA_GLASS = registerBlock("light_gray_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS = registerBlock("light_gray_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS_PANE = registerBlock("light_gray_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS_BRICKS = registerBlock("light_gray_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS = registerBlock("light_gray_sea_glass_brick_stairs", () -> new StairBlock(() -> LIGHT_GRAY_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_GRAY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS_BRICK_SLAB = registerBlock("light_gray_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LIGHT_GRAY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_GRAY_SEA_GLASS_LAMP = registerBlock("light_gray_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_NETTED_SEA_GLASS_LAMP = registerBlock("light_gray_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP = registerBlock("light_gray_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GRAY)));

    // gray sea glass
    public static final RegistryObject<Block> GRAY_PEBBLED_SEA_GLASS = registerBlock("gray_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_SEA_GLASS = registerBlock("gray_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_SEA_GLASS_PANE = registerBlock("gray_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_SEA_GLASS_BRICKS = registerBlock("gray_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_SEA_GLASS_BRICK_STAIRS = registerBlock("gray_sea_glass_brick_stairs", () -> new StairBlock(() -> GRAY_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GRAY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_SEA_GLASS_BRICK_SLAB = registerBlock("gray_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GRAY_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> GRAY_SEA_GLASS_LAMP = registerBlock("gray_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_NETTED_SEA_GLASS_LAMP = registerBlock("gray_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> GRAY_MOSAIC_SEA_GLASS_LAMP = registerBlock("gray_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GRAY)));

    // black sea glass
    public static final RegistryObject<Block> BLACK_PEBBLED_SEA_GLASS = registerBlock("black_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SEA_GLASS = registerBlock("black_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SEA_GLASS_PANE = registerBlock("black_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SEA_GLASS_BRICKS = registerBlock("black_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SEA_GLASS_BRICK_STAIRS = registerBlock("black_sea_glass_brick_stairs", () -> new StairBlock(() -> BLACK_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLACK_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_SEA_GLASS_BRICK_SLAB = registerBlock("black_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLACK_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_SEA_GLASS_LAMP = registerBlock("black_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_NETTED_SEA_GLASS_LAMP = registerBlock("black_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_MOSAIC_SEA_GLASS_LAMP = registerBlock("black_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLACK)));

    // brown sea glass
    public static final RegistryObject<Block> BROWN_PEBBLED_SEA_GLASS = registerBlock("brown_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_SEA_GLASS = registerBlock("brown_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_SEA_GLASS_PANE = registerBlock("brown_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_SEA_GLASS_BRICKS = registerBlock("brown_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_SEA_GLASS_BRICK_STAIRS = registerBlock("brown_sea_glass_brick_stairs", () -> new StairBlock(() -> BROWN_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BROWN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_SEA_GLASS_BRICK_SLAB = registerBlock("brown_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BROWN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BROWN_SEA_GLASS_LAMP = registerBlock("brown_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_NETTED_SEA_GLASS_LAMP = registerBlock("brown_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> BROWN_MOSAIC_SEA_GLASS_LAMP = registerBlock("brown_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BROWN)));

    // red sea glass
    public static final RegistryObject<Block> RED_PEBBLED_SEA_GLASS = registerBlock("red_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_SEA_GLASS = registerBlock("red_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_SEA_GLASS_PANE = registerBlock("red_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_SEA_GLASS_BRICKS = registerBlock("red_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_SEA_GLASS_BRICK_STAIRS = registerBlock("red_sea_glass_brick_stairs", () -> new StairBlock(() -> RED_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(RED_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> RED_SEA_GLASS_BRICK_SLAB = registerBlock("red_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> RED_SEA_GLASS_LAMP = registerBlock("red_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_NETTED_SEA_GLASS_LAMP = registerBlock("red_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_MOSAIC_SEA_GLASS_LAMP = registerBlock("red_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_RED)));

    // orange sea glass
    public static final RegistryObject<Block> ORANGE_PEBBLED_SEA_GLASS = registerBlock("orange_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS = registerBlock("orange_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS_PANE = registerBlock("orange_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS_BRICKS = registerBlock("orange_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS_BRICK_STAIRS = registerBlock("orange_sea_glass_brick_stairs", () -> new StairBlock(() -> ORANGE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(ORANGE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS_BRICK_SLAB = registerBlock("orange_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(ORANGE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> ORANGE_SEA_GLASS_LAMP = registerBlock("orange_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_NETTED_SEA_GLASS_LAMP = registerBlock("orange_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> ORANGE_MOSAIC_SEA_GLASS_LAMP = registerBlock("orange_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_ORANGE)));

    // yellow sea glass
    public static final RegistryObject<Block> YELLOW_PEBBLED_SEA_GLASS = registerBlock("yellow_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS = registerBlock("yellow_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS_PANE = registerBlock("yellow_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS_BRICKS = registerBlock("yellow_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS_BRICK_STAIRS = registerBlock("yellow_sea_glass_brick_stairs", () -> new StairBlock(() -> YELLOW_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(YELLOW_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS_BRICK_SLAB = registerBlock("yellow_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(YELLOW_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> YELLOW_SEA_GLASS_LAMP = registerBlock("yellow_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_NETTED_SEA_GLASS_LAMP = registerBlock("yellow_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> YELLOW_MOSAIC_SEA_GLASS_LAMP = registerBlock("yellow_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_YELLOW)));

    // lime sea glass
    public static final RegistryObject<Block> LIME_PEBBLED_SEA_GLASS = registerBlock("lime_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_SEA_GLASS = registerBlock("lime_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_SEA_GLASS_PANE = registerBlock("lime_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_SEA_GLASS_BRICKS = registerBlock("lime_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_SEA_GLASS_BRICK_STAIRS = registerBlock("lime_sea_glass_brick_stairs", () -> new StairBlock(() -> LIME_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIME_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIME_SEA_GLASS_BRICK_SLAB = registerBlock("lime_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LIME_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIME_SEA_GLASS_LAMP = registerBlock("lime_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_NETTED_SEA_GLASS_LAMP = registerBlock("lime_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> LIME_MOSAIC_SEA_GLASS_LAMP = registerBlock("lime_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_GREEN)));

    // green sea glass
    public static final RegistryObject<Block> GREEN_PEBBLED_SEA_GLASS = registerBlock("green_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_SEA_GLASS = registerBlock("green_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_SEA_GLASS_PANE = registerBlock("green_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_SEA_GLASS_BRICKS = registerBlock("green_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_SEA_GLASS_BRICK_STAIRS = registerBlock("green_sea_glass_brick_stairs", () -> new StairBlock(() -> GREEN_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GREEN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_SEA_GLASS_BRICK_SLAB = registerBlock("green_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GREEN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> GREEN_SEA_GLASS_LAMP = registerBlock("green_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_NETTED_SEA_GLASS_LAMP = registerBlock("green_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> GREEN_MOSAIC_SEA_GLASS_LAMP = registerBlock("green_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_GREEN)));

    // cyan sea glass
    public static final RegistryObject<Block> CYAN_PEBBLED_SEA_GLASS = registerBlock("cyan_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_SEA_GLASS = registerBlock("cyan_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_SEA_GLASS_PANE = registerBlock("cyan_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_SEA_GLASS_BRICKS = registerBlock("cyan_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_SEA_GLASS_BRICK_STAIRS = registerBlock("cyan_sea_glass_brick_stairs", () -> new StairBlock(() -> CYAN_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CYAN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_SEA_GLASS_BRICK_SLAB = registerBlock("cyan_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CYAN_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> CYAN_SEA_GLASS_LAMP = registerBlock("cyan_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_NETTED_SEA_GLASS_LAMP = registerBlock("cyan_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CYAN_MOSAIC_SEA_GLASS_LAMP = registerBlock("cyan_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_CYAN)));

    // light blue sea glass
    public static final RegistryObject<Block> LIGHT_BLUE_PEBBLED_SEA_GLASS = registerBlock("light_blue_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS = registerBlock("light_blue_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_PANE = registerBlock("light_blue_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BRICKS = registerBlock("light_blue_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS = registerBlock("light_blue_sea_glass_brick_stairs", () -> new StairBlock(() -> LIGHT_BLUE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(LIGHT_BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_BRICK_SLAB = registerBlock("light_blue_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(LIGHT_BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> LIGHT_BLUE_SEA_GLASS_LAMP = registerBlock("light_blue_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_NETTED_SEA_GLASS_LAMP = registerBlock("light_blue_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP = registerBlock("light_blue_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_LIGHT_BLUE)));

    // blue sea glass
    public static final RegistryObject<Block> BLUE_PEBBLED_SEA_GLASS = registerBlock("blue_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_SEA_GLASS = registerBlock("blue_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_SEA_GLASS_PANE = registerBlock("blue_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_SEA_GLASS_BRICKS = registerBlock("blue_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_SEA_GLASS_BRICK_STAIRS = registerBlock("blue_sea_glass_brick_stairs", () -> new StairBlock(() -> BLUE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_SEA_GLASS_BRICK_SLAB = registerBlock("blue_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BLUE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_SEA_GLASS_LAMP = registerBlock("blue_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_NETTED_SEA_GLASS_LAMP = registerBlock("blue_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLUE_MOSAIC_SEA_GLASS_LAMP = registerBlock("blue_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_BLUE)));

    // purple sea glass
    public static final RegistryObject<Block> PURPLE_PEBBLED_SEA_GLASS = registerBlock("purple_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS = registerBlock("purple_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS_PANE = registerBlock("purple_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS_BRICKS = registerBlock("purple_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS_BRICK_STAIRS = registerBlock("purple_sea_glass_brick_stairs", () -> new StairBlock(() -> PURPLE_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PURPLE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS_BRICK_SLAB = registerBlock("purple_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PURPLE_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_SEA_GLASS_LAMP = registerBlock("purple_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_NETTED_SEA_GLASS_LAMP = registerBlock("purple_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> PURPLE_MOSAIC_SEA_GLASS_LAMP = registerBlock("purple_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PURPLE)));

    // magenta sea glass
    public static final RegistryObject<Block> MAGENTA_PEBBLED_SEA_GLASS = registerBlock("magenta_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS = registerBlock("magenta_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS_PANE = registerBlock("magenta_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS_BRICKS = registerBlock("magenta_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS_BRICK_STAIRS = registerBlock("magenta_sea_glass_brick_stairs", () -> new StairBlock(() -> MAGENTA_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(MAGENTA_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS_BRICK_SLAB = registerBlock("magenta_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(MAGENTA_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> MAGENTA_SEA_GLASS_LAMP = registerBlock("magenta_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_NETTED_SEA_GLASS_LAMP = registerBlock("magenta_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> MAGENTA_MOSAIC_SEA_GLASS_LAMP = registerBlock("magenta_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_MAGENTA)));

    // pink sea glass
    public static final RegistryObject<Block> PINK_PEBBLED_SEA_GLASS = registerBlock("pink_pebbled_sea_glass", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_SEA_GLASS = registerBlock("pink_sea_glass", () -> new GlassBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_SEA_GLASS_PANE = registerBlock("pink_sea_glass_pane", () -> new IronBarsBlock(SeafarerBlockProperties.seaGlass(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_SEA_GLASS_BRICKS = registerBlock("pink_sea_glass_bricks", () -> new Block(SeafarerBlockProperties.seaGlassSolid(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_SEA_GLASS_BRICK_STAIRS = registerBlock("pink_sea_glass_brick_stairs", () -> new StairBlock(() -> PINK_SEA_GLASS_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PINK_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PINK_SEA_GLASS_BRICK_SLAB = registerBlock("pink_sea_glass_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PINK_SEA_GLASS_BRICKS.get())));
    public static final RegistryObject<Block> PINK_SEA_GLASS_LAMP = registerBlock("pink_sea_glass_lamp", () -> new SeafarerDirectionalBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_NETTED_SEA_GLASS_LAMP = registerBlock("pink_netted_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> PINK_MOSAIC_SEA_GLASS_LAMP = registerBlock("pink_mosaic_sea_glass_lamp", () -> new RotatedPillarBlock(SeafarerBlockProperties.seaGlassLamp(MapColor.COLOR_PINK)));

    public static final RegistryObject<Block> FISHING_NET = registerBlock("fishing_net", () -> new FishingNetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.1F).sound(SoundType.WOOL).speedFactor(0.7F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));

    // starfish
    public static final RegistryObject<Block> CORAL_STARFISH = registerBlock("coral_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> LAGOON_STARFISH = registerBlock("lagoon_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PLUMERIA_STARFISH = registerBlock("plumeria_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> SKY_BLUE_STARFISH = registerBlock("sky_blue_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> SUNNY_STARFISH = registerBlock("sunny_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> SUNSET_STARFISH = registerBlock("sunset_starfish", () -> new StarfishBlock(SeafarerBlockProperties.starfish(MapColor.COLOR_ORANGE)));

    public static final RegistryObject<Block> TALL_BEACHGRASS = registerBlock("tall_beachgrass", () -> new TallBeachPlantBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> BEACHGRASS = registerBlock("beachgrass", () -> new BeachgrassBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_BEACHGRASS = registerBlockWithoutItem("potted_beachgrass", () -> new FlowerPotBlock(SeafarerBlocks.BEACHGRASS.get(), registerFlowerPot()));
    public static final RegistryObject<Block> SHORT_BEACHGRASS = registerBlock("short_beachgrass", () -> new BeachgrassBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_SHORT_BEACHGRASS = registerBlockWithoutItem("potted_short_beachgrass", () -> new FlowerPotBlock(SeafarerBlocks.BEACHGRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SEA_THRIFT = registerBlock("sea_thrift", () -> new SeafarerFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeafarerBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_SEA_THRIFT = registerBlockWithoutItem("potted_sea_thrift", () -> new FlowerPotBlock(SeafarerBlocks.SEA_THRIFT.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SEA_HOLLY = registerBlock("sea_holly", () -> new SeafarerFlowerBlock(() -> MobEffects.MOVEMENT_SPEED, 7, SeafarerBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_SEA_HOLLY = registerBlockWithoutItem("potted_sea_holly", () -> new FlowerPotBlock(SeafarerBlocks.SEA_HOLLY.get(), registerFlowerPot()));

    public static final RegistryObject<Block> COASTAL_LAVENDER = registerBlock("coastal_lavender", () -> new SeafarerFlowerBlock(() -> MobEffects.SLOW_FALLING, 9, SeafarerBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_COASTAL_LAVENDER = registerBlockWithoutItem("potted_coastal_lavender", () -> new FlowerPotBlock(SeafarerBlocks.COASTAL_LAVENDER.get(), registerFlowerPot()));

    public static final RegistryObject<Block> COASTAL_WILDFLOWER = registerBlock("coastal_wildflower", () -> new SeafarerFlowerBlock(() -> MobEffects.DIG_SPEED, 9, SeafarerBlockProperties.flower(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> POTTED_COASTAL_WILDFLOWER = registerBlockWithoutItem("potted_coastal_wildflower", () -> new FlowerPotBlock(SeafarerBlocks.COASTAL_WILDFLOWER.get(), registerFlowerPot()));

    public static final RegistryObject<Block> CLAM_SHELL = registerBlock("clam_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HORN_SHELL = registerBlock("horn_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIKY_SHELL = registerBlock("spiky_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPIRAL_SHELL = registerBlock("spiral_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SWIRL_SHELL = registerBlock("swirl_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PYRAMID_SHELL = registerBlock("pyramid_shell", () -> new ShellBlock(BlockBehaviour.Properties.of().instabreak().sound(SoundType.STONE).noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CLAM_SHELL_BRICKS = registerBlock("clam_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> CLAM_SHELL_BRICK_STAIRS = registerBlock("clam_shell_brick_stairs", () -> new StairBlock(() -> CLAM_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CLAM_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> CLAM_SHELL_BRICK_SLAB = registerBlock("clam_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CLAM_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> CLAM_SHELL_PILLAR = registerBlock("clam_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));

    public static final RegistryObject<Block> HORN_SHELL_BRICKS = registerBlock("horn_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> HORN_SHELL_BRICK_STAIRS = registerBlock("horn_shell_brick_stairs", () -> new StairBlock(() -> HORN_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(HORN_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> HORN_SHELL_BRICK_SLAB = registerBlock("horn_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HORN_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> HORN_SHELL_PILLAR = registerBlock("horn_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_YELLOW)));

    public static final RegistryObject<Block> SPIKY_SHELL_BRICKS = registerBlock("spiky_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_PINK)));
    public static final RegistryObject<Block> SPIKY_SHELL_BRICK_STAIRS = registerBlock("spiky_shell_brick_stairs", () -> new StairBlock(() -> SPIKY_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SPIKY_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIKY_SHELL_BRICK_SLAB = registerBlock("spiky_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SPIKY_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIKY_SHELL_PILLAR = registerBlock("spiky_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_PINK)));

    public static final RegistryObject<Block> SPIRAL_SHELL_BRICKS = registerBlock("spiral_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> SPIRAL_SHELL_BRICK_STAIRS = registerBlock("spiral_shell_brick_stairs", () -> new StairBlock(() -> SPIRAL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SPIRAL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIRAL_SHELL_BRICK_SLAB = registerBlock("spiral_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SPIRAL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SPIRAL_SHELL_PILLAR = registerBlock("spiral_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.COLOR_LIGHT_BLUE)));

    public static final RegistryObject<Block> SWIRL_SHELL_BRICKS = registerBlock("swirl_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_MAGENTA)));
    public static final RegistryObject<Block> SWIRL_SHELL_BRICK_STAIRS = registerBlock("swirl_shell_brick_stairs", () -> new StairBlock(() -> SWIRL_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SWIRL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SWIRL_SHELL_BRICK_SLAB = registerBlock("swirl_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SWIRL_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> SWIRL_SHELL_PILLAR = registerBlock("swirl_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.TERRACOTTA_MAGENTA)));

    public static final RegistryObject<Block> PYRAMID_SHELL_BRICKS = registerBlock("pyramid_shell_bricks", () -> new Block(SeafarerBlockProperties.shellBlock(MapColor.SAND)));
    public static final RegistryObject<Block> PYRAMID_SHELL_BRICK_STAIRS = registerBlock("pyramid_shell_brick_stairs", () -> new StairBlock(() -> PYRAMID_SHELL_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(PYRAMID_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> PYRAMID_SHELL_BRICK_SLAB = registerBlock("pyramid_shell_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PYRAMID_SHELL_BRICKS.get())));
    public static final RegistryObject<Block> PYRAMID_SHELL_PILLAR = registerBlock("pyramid_shell_pillar", () -> new RotatedPillarBlock(SeafarerBlockProperties.shellBlock(MapColor.SAND)));

    public static final RegistryObject<Block> SHELLY_SAND = registerBlock("shelly_sand", () -> new SandBlock(14406560, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> STARRY_SAND = registerBlock("starry_sand", () -> new SandBlock(14406560, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> SEA_GLASS_SAND = registerBlock("sea_glass_sand", () -> new SandBlock(14406560, SeafarerBlockProperties.SAND));

    // amber coral
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_BLOCK = registerBlock("dead_amber_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL = registerBlock("dead_amber_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_WALL_FAN = registerBlockWithoutItem("dead_amber_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_AMBER_CORAL_FAN = registerBlockWithoutItem("dead_amber_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> AMBER_CORAL_BLOCK = registerBlock("amber_coral_block", () -> new CoralBlock(DEAD_AMBER_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL = registerBlock("amber_coral", () -> new CoralPlantBlock(DEAD_AMBER_CORAL.get(), SeafarerBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL_WALL_FAN = registerBlockWithoutItem("amber_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_AMBER_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> AMBER_CORAL_FAN = registerBlockWithoutItem("amber_coral_fan", () -> new CoralFanBlock(DEAD_AMBER_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.TERRACOTTA_ORANGE)));

    // cerulean coral
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_BLOCK = registerBlock("dead_cerulean_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL = registerBlock("dead_cerulean_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_WALL_FAN = registerBlockWithoutItem("dead_cerulean_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_CERULEAN_CORAL_FAN = registerBlockWithoutItem("dead_cerulean_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> CERULEAN_CORAL_BLOCK = registerBlock("cerulean_coral_block", () -> new CoralBlock(DEAD_CERULEAN_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL = registerBlock("cerulean_coral", () -> new CoralPlantBlock(DEAD_CERULEAN_CORAL.get(), SeafarerBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL_WALL_FAN = registerBlockWithoutItem("cerulean_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_CERULEAN_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CERULEAN_CORAL_FAN = registerBlockWithoutItem("cerulean_coral_fan", () -> new CoralFanBlock(DEAD_CERULEAN_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_BLUE)));

    // maroon coral
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_BLOCK = registerBlock("dead_maroon_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL = registerBlock("dead_maroon_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_WALL_FAN = registerBlockWithoutItem("dead_maroon_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_MAROON_CORAL_FAN = registerBlockWithoutItem("dead_maroon_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> MAROON_CORAL_BLOCK = registerBlock("maroon_coral_block", () -> new CoralBlock(DEAD_MAROON_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL = registerBlock("maroon_coral", () -> new CoralPlantBlock(DEAD_MAROON_CORAL.get(), SeafarerBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL_WALL_FAN = registerBlockWithoutItem("maroon_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_MAROON_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> MAROON_CORAL_FAN = registerBlockWithoutItem("maroon_coral_fan", () -> new CoralFanBlock(DEAD_MAROON_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_RED)));

    // olive coral
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_BLOCK = registerBlock("dead_olive_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL = registerBlock("dead_olive_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_WALL_FAN = registerBlockWithoutItem("dead_olive_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_OLIVE_CORAL_FAN = registerBlockWithoutItem("dead_olive_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> OLIVE_CORAL_BLOCK = registerBlock("olive_coral_block", () -> new CoralBlock(DEAD_OLIVE_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL = registerBlock("olive_coral", () -> new CoralPlantBlock(DEAD_OLIVE_CORAL.get(), SeafarerBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL_WALL_FAN = registerBlockWithoutItem("olive_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_OLIVE_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> OLIVE_CORAL_FAN = registerBlockWithoutItem("olive_coral_fan", () -> new CoralFanBlock(DEAD_OLIVE_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_LIGHT_GREEN)));

    // turquoise coral
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_BLOCK = registerBlock("dead_turquoise_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL = registerBlock("dead_turquoise_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_WALL_FAN = registerBlockWithoutItem("dead_turquoise_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_TURQUOISE_CORAL_FAN = registerBlockWithoutItem("dead_turquoise_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> TURQUOISE_CORAL_BLOCK = registerBlock("turquoise_coral_block", () -> new CoralBlock(DEAD_TURQUOISE_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL = registerBlock("turquoise_coral", () -> new CoralPlantBlock(DEAD_TURQUOISE_CORAL.get(), SeafarerBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL_WALL_FAN = registerBlockWithoutItem("turquoise_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_TURQUOISE_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> TURQUOISE_CORAL_FAN = registerBlockWithoutItem("turquoise_coral_fan", () -> new CoralFanBlock(DEAD_TURQUOISE_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_CYAN)));

    // verdant coral
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_BLOCK = registerBlock("dead_verdant_coral_block", () -> new Block(SeafarerBlockProperties.DEAD_CORAL_BLOCK));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL = registerBlock("dead_verdant_coral", () -> new BaseCoralPlantBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_WALL_FAN = registerBlockWithoutItem("dead_verdant_coral_wall_fan", () -> new BaseCoralWallFanBlock(SeafarerBlockProperties.DEAD_CORAL));
    public static final RegistryObject<Block> DEAD_VERDANT_CORAL_FAN = registerBlockWithoutItem("dead_verdant_coral_fan", () -> new BaseCoralFanBlock(SeafarerBlockProperties.DEAD_CORAL));

    public static final RegistryObject<Block> VERDANT_CORAL_BLOCK = registerBlock("verdant_coral_block", () -> new CoralBlock(DEAD_VERDANT_CORAL_BLOCK.get(), SeafarerBlockProperties.coralBlock(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL = registerBlock("verdant_coral", () -> new CoralPlantBlock(DEAD_VERDANT_CORAL.get(), SeafarerBlockProperties.coral(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL_WALL_FAN = registerBlockWithoutItem("verdant_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_VERDANT_CORAL_WALL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> VERDANT_CORAL_FAN = registerBlockWithoutItem("verdant_coral_fan", () -> new CoralFanBlock(DEAD_VERDANT_CORAL_FAN.get(), SeafarerBlockProperties.coral(MapColor.COLOR_GREEN)));

    // zoas
    public static final RegistryObject<Block> CYAN_ZOA = registerBlock("cyan_zoa",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> ORANGE_ZOA = registerBlock("orange_zoa",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> RED_ZOA = registerBlock("red_zoa",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> PURPLE_ZOA = registerBlock("purple_zoa",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_PURPLE)));

    // gorgonians
    public static final RegistryObject<Block> ANTLER_GORGONIAN = registerBlock("antler_gorgonian",() -> new GorgonianCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> ATTUM_GORGONIAN = registerBlock("attum_gorgonian",() -> new GorgonianCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> FLORAL_GORGONIAN = registerBlock("floral_gorgonian",() -> new GorgonianCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> TOWERING_GORGONIAN = registerBlock("towering_gorgonian",() -> new GorgonianCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_ORANGE)));

    // christmas tree worms
    public static final RegistryObject<Block> BLUE_CHRISTMAS_TREE_WORM = registerBlock("blue_christmas_tree_worm",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> BLACK_CHRISTMAS_TREE_WORM = registerBlock("black_christmas_tree_worm",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> RED_CHRISTMAS_TREE_WORM = registerBlock("red_christmas_tree_worm",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> YELLOW_CHRISTMAS_TREE_WORM = registerBlock("yellow_christmas_tree_worm",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> WHITE_CHRISTMAS_TREE_WORM = registerBlock("white_christmas_tree_worm",() -> new FloweryCoralBlock(SeafarerBlockProperties.coral(MapColor.TERRACOTTA_WHITE)));

    // coraline sand
    public static final RegistryObject<Block> CORALINE_SAND = registerBlock("coraline_sand", () -> new SandBlock(15790058, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> SHELLY_CORALINE_SAND = registerBlock("shelly_coraline_sand", () -> new SandBlock(15790058, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> STARRY_CORALINE_SAND = registerBlock("starry_coraline_sand", () -> new SandBlock(15790058, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> CORALINE_SANDSTONE = registerBlock("coraline_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CORALINE_SANDSTONE_SLAB = registerBlock("coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CORALINE_SANDSTONE_STAIRS = registerBlock("coraline_sandstone_stairs", () -> new StairBlock(() -> CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CORALINE_SANDSTONE_WALL = registerBlock("coraline_sandstone_wall", () -> new WallBlock(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CHISELED_CORALINE_SANDSTONE = registerBlock("chiseled_coraline_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE = registerBlock("smooth_coraline_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE_STAIRS = registerBlock("smooth_coraline_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_CORALINE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_CORALINE_SANDSTONE_SLAB = registerBlock("smooth_coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_CORALINE_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE = registerBlock("cut_coraline_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CUT_CORALINE_SANDSTONE_SLAB = registerBlock("cut_coraline_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_CORALINE_SANDSTONE.get())));

    // volcanic sand
    public static final RegistryObject<Block> VOLCANIC_SAND = registerBlock("volcanic_sand", () -> new SandBlock(3487297, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> SHELLY_VOLCANIC_SAND = registerBlock("shelly_volcanic_sand", () -> new SandBlock(3487297, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> STARRY_VOLCANIC_SAND = registerBlock("starry_volcanic_sand", () -> new SandBlock(3487297, SeafarerBlockProperties.SAND));
    public static final RegistryObject<Block> VOLCANIC_SANDSTONE = registerBlock("volcanic_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> VOLCANIC_SANDSTONE_SLAB = registerBlock("volcanic_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VOLCANIC_SANDSTONE.get())));
    public static final RegistryObject<Block> VOLCANIC_SANDSTONE_STAIRS = registerBlock("volcanic_sandstone_stairs", () -> new StairBlock(() -> VOLCANIC_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(VOLCANIC_SANDSTONE.get())));
    public static final RegistryObject<Block> VOLCANIC_SANDSTONE_WALL = registerBlock("volcanic_sandstone_wall", () -> new WallBlock(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CHISELED_VOLCANIC_SANDSTONE = registerBlock("chiseled_volcanic_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_VOLCANIC_SANDSTONE = registerBlock("smooth_volcanic_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> SMOOTH_VOLCANIC_SANDSTONE_STAIRS = registerBlock("smooth_volcanic_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_VOLCANIC_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_VOLCANIC_SANDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_VOLCANIC_SANDSTONE_SLAB = registerBlock("smooth_volcanic_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_VOLCANIC_SANDSTONE.get())));
    public static final RegistryObject<Block> CUT_VOLCANIC_SANDSTONE = registerBlock("cut_volcanic_sandstone", () -> new Block(SeafarerBlockProperties.SANDSTONE));
    public static final RegistryObject<Block> CUT_VOLCANIC_SANDSTONE_SLAB = registerBlock("cut_volcanic_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CUT_VOLCANIC_SANDSTONE.get())));

    // scoria
    public static final RegistryObject<Block> SCORIA = registerBlock("scoria", () -> new Block(SeafarerBlockProperties.SCORIA));
    public static final RegistryObject<Block> MOSSY_SCORIA = registerBlock("mossy_scoria", () -> new MossyScoriaBlock(SeafarerBlockProperties.SCORIA));
    public static final RegistryObject<Block> SCORIA_STAIRS = registerBlock("scoria_stairs", () -> new StairBlock(() -> SCORIA.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCORIA.get())));
    public static final RegistryObject<Block> SCORIA_SLAB = registerBlock("scoria_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCORIA.get())));
    public static final RegistryObject<Block> SCORIA_WALL = registerBlock("scoria_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCORIA.get())));

    public static final RegistryObject<Block> POLISHED_SCORIA = registerBlock("polished_scoria", () -> new Block(SeafarerBlockProperties.SCORIA));
    public static final RegistryObject<Block> POLISHED_SCORIA_STAIRS = registerBlock("polished_scoria_stairs", () -> new StairBlock(() -> POLISHED_SCORIA.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_SCORIA.get())));
    public static final RegistryObject<Block> POLISHED_SCORIA_SLAB = registerBlock("polished_scoria_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SCORIA.get())));
    public static final RegistryObject<Block> POLISHED_SCORIA_WALL = registerBlock("polished_scoria_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SCORIA.get())));

    public static final RegistryObject<Block> SCORIA_BRICKS = registerBlock("scoria_bricks", () -> new Block(SeafarerBlockProperties.SCORIA));
    public static final RegistryObject<Block> SCORIA_BRICK_STAIRS = registerBlock("scoria_brick_stairs", () -> new StairBlock(() -> SCORIA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SCORIA_BRICKS.get())));
    public static final RegistryObject<Block> SCORIA_BRICK_SLAB = registerBlock("scoria_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SCORIA_BRICKS.get())));
    public static final RegistryObject<Block> SCORIA_BRICK_WALL = registerBlock("scoria_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SCORIA_BRICKS.get())));
    public static final RegistryObject<Block> CHISELED_SCORIA_BRICKS = registerBlock("chiseled_scoria_bricks", () -> new Block(SeafarerBlockProperties.SCORIA));

    public static final RegistryObject<Block> SMOOTH_SCORIA = registerBlock("smooth_scoria", () -> new Block(SeafarerBlockProperties.SCORIA));
    public static final RegistryObject<Block> SMOOTH_SCORIA_STAIRS = registerBlock("smooth_scoria_stairs", () -> new StairBlock(() -> SMOOTH_SCORIA.get().defaultBlockState(), BlockBehaviour.Properties.copy(SMOOTH_SCORIA.get())));
    public static final RegistryObject<Block> SMOOTH_SCORIA_SLAB = registerBlock("smooth_scoria_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_SCORIA.get())));
    public static final RegistryObject<Block> SMOOTH_SCORIA_WALL = registerBlock("smooth_scoria_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SMOOTH_SCORIA.get())));

    public static final RegistryObject<Block> MOLTEN_SCORIA = registerBlock("molten_scoria", () -> new MoltenScoriaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().lightLevel((state) -> 3).strength(0.75F, 2.5F).isValidSpawn((state, getter, pos, entityType) -> entityType.fireImmune()).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> VOLCANIC_CORE = registerBlock("volcanic_core", () -> new VolcanicCoreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().lightLevel((state) -> 8).strength(50.0F, 1200.0F).isValidSpawn((state, getter, pos, entityType) -> entityType.fireImmune()).sound(SoundType.BASALT)));

    public static final RegistryObject<Block> FIERY_DUSTER = registerBlock("fiery_duster", () -> new SeafarerFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeafarerBlockProperties.flower(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> POTTED_FIERY_DUSTER = registerBlockWithoutItem("potted_fiery_duster", () -> new FlowerPotBlock(SeafarerBlocks.FIERY_DUSTER.get(), registerFlowerPot()));

    public static final RegistryObject<Block> SILK_LILIES = registerBlock("silk_lilies", () -> new SeafarerFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeafarerBlockProperties.flower(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> POTTED_SILK_LILIES = registerBlockWithoutItem("potted_silk_lilies", () -> new FlowerPotBlock(SeafarerBlocks.SILK_LILIES.get(), registerFlowerPot()));

    public static final RegistryObject<Block> TWILIGHT_BLADE = registerBlock("twilight_blade", () -> new SeafarerFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeafarerBlockProperties.flower(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> POTTED_TWILIGHT_BLADE = registerBlockWithoutItem("potted_twilight_blade", () -> new FlowerPotBlock(SeafarerBlocks.TWILIGHT_BLADE.get(), registerFlowerPot()));

    public static final RegistryObject<Block> WIDOWBLOOM = registerBlock("widowbloom", () -> new SeafarerFlowerBlock(() -> MobEffects.DAMAGE_BOOST, 7, SeafarerBlockProperties.flower(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> POTTED_WIDOWBLOOM = registerBlockWithoutItem("potted_widowbloom", () -> new FlowerPotBlock(SeafarerBlocks.WIDOWBLOOM.get(), registerFlowerPot()));

    public static final RegistryObject<Block> DAWNFLAME = registerBlock("dawnflame", () -> new TallBeachPlantBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> SAPPHIRE_COWBELL = registerBlock("sapphire_cowbell", () -> new TallBeachPlantBlock(SeafarerBlockProperties.PLANT));

    public static final RegistryObject<Block> WHITE_FLOWERING_JUNGLE_LEAVES = registerBlock("white_flowering_jungle_leaves", () -> new LeavesBlock(SeafarerBlockProperties.LEAVES));
    public static final RegistryObject<Block> ORANGE_FLOWERING_JUNGLE_LEAVES = registerBlock("orange_flowering_jungle_leaves", () -> new LeavesBlock(SeafarerBlockProperties.LEAVES));
    public static final RegistryObject<Block> YELLOW_FLOWERING_JUNGLE_LEAVES = registerBlock("yellow_flowering_jungle_leaves", () -> new LeavesBlock(SeafarerBlockProperties.LEAVES));
    public static final RegistryObject<Block> BLUE_FLOWERING_JUNGLE_LEAVES = registerBlock("blue_flowering_jungle_leaves", () -> new LeavesBlock(SeafarerBlockProperties.LEAVES));
    public static final RegistryObject<Block> MAGENTA_FLOWERING_JUNGLE_LEAVES = registerBlock("magenta_flowering_jungle_leaves", () -> new LeavesBlock(SeafarerBlockProperties.LEAVES));

    public static final RegistryObject<Block> BLUE_VOLCANIC_GRASS = registerBlock("blue_volcanic_grass", () -> new BeachPlantBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_BLUE_VOLCANIC_GRASS = registerBlockWithoutItem("potted_blue_volcanic_grass", () -> new FlowerPotBlock(SeafarerBlocks.BLUE_VOLCANIC_GRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> ORANGE_VOLCANIC_GRASS = registerBlock("orange_volcanic_grass", () -> new BeachPlantBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_ORANGE_VOLCANIC_GRASS = registerBlockWithoutItem("potted_orange_volcanic_grass", () -> new FlowerPotBlock(SeafarerBlocks.ORANGE_VOLCANIC_GRASS.get(), registerFlowerPot()));

    public static final RegistryObject<Block> YELLOW_VOLCANIC_GRASS = registerBlock("yellow_volcanic_grass", () -> new BeachPlantBlock(SeafarerBlockProperties.PLANT));
    public static final RegistryObject<Block> POTTED_YELLOW_VOLCANIC_GRASS = registerBlockWithoutItem("potted_yellow_volcanic_grass", () -> new FlowerPotBlock(SeafarerBlocks.YELLOW_VOLCANIC_GRASS.get(), registerFlowerPot()));

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        BLOCK_TRANSLATIONS.add(block);
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerBlockNoLang(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static <B extends Block> RegistryObject<B> registerPlaceOnWaterBlockItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        SeafarerItems.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static <B extends Block> RegistryObject<B> registerBlockWithoutItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = BLOCKS.register(name, supplier);
        BLOCK_TRANSLATIONS.add(block);
        return block;
    }

    private static BlockBehaviour.Properties registerFlowerPot(FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return properties;
    }
}

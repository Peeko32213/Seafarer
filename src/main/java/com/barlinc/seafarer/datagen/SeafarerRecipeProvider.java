package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerItems;
import com.barlinc.seafarer.registry.tags.SeafarerItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.common.crafting.conditions.OrCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.barlinc.seafarer.registry.SeafarerBlocks.*;
import static net.minecraft.data.recipes.RecipeCategory.*;

public class SeafarerRecipeProvider extends RecipeProvider {

    public SeafarerRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {

        // fishing net
        conditionalRecipe(ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, FISHING_NET.get(), 16).define('#', Items.STRING).pattern("###").pattern("###").unlockedBy(getHasName(Items.STRING), has(Items.STRING)), new OrCondition(new NotCondition(new ModLoadedCondition("farmersdelight")), new NotCondition(new ModLoadedCondition("supplementaries"))), consumer, getSaveLocation("fishing_net_from_string"));
        conditionalRecipe(ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, FISHING_NET.get(), 16).define('#', SeafarerItemTags.ROPES).pattern("###").pattern("###").unlockedBy(getHasName(Items.STRING), has(SeafarerItemTags.ROPES)), new OrCondition(new ModLoadedCondition("farmersdelight"), new ModLoadedCondition("supplementaries")), consumer, getSaveLocation("fishing_net_from_rope"));

        flowerToDye(SEA_THRIFT.get(), Items.PINK_DYE, consumer);
        flowerToDye(SEA_HOLLY.get(), Items.BLUE_DYE, consumer);
        flowerToDye(COASTAL_LAVENDER.get(), Items.PURPLE_DYE, consumer);
        flowerToDye(COASTAL_WILDFLOWER.get(), Items.YELLOW_DYE, consumer);
        flowerToDye(FIERY_DUSTER.get(), Items.ORANGE_DYE, consumer);
        flowerToDye(SILK_LILIES.get(), Items.WHITE_DYE, consumer);
        flowerToDye(TWILIGHT_BLADE.get(), Items.RED_DYE, consumer);
        flowerToDye(WIDOWBLOOM.get(), Items.ORANGE_DYE, consumer);
        flowerToDye(ORANGE_VOLCANIC_GRASS.get(), Items.ORANGE_DYE, consumer);
        flowerToDye(YELLOW_VOLCANIC_GRASS.get(), Items.YELLOW_DYE, consumer);
        flowerToDye(BLUE_VOLCANIC_GRASS.get(), Items.BLUE_DYE, consumer);

        flowerToDye(BLACK_CHRISTMAS_TREE_WORM.get(), Items.BLACK_DYE, consumer);
        flowerToDye(WHITE_CHRISTMAS_TREE_WORM.get(), Items.WHITE_DYE, consumer);
        flowerToDye(RED_CHRISTMAS_TREE_WORM.get(), Items.RED_DYE, consumer);
        flowerToDye(YELLOW_CHRISTMAS_TREE_WORM.get(), Items.YELLOW_DYE, consumer);
        flowerToDye(BLUE_CHRISTMAS_TREE_WORM.get(), Items.BLUE_DYE, consumer);

        flowerToDye(RED_ZOA.get(), Items.RED_DYE, consumer);
        flowerToDye(ORANGE_ZOA.get(), Items.ORANGE_DYE, consumer);
        flowerToDye(CYAN_ZOA.get(), Items.CYAN_DYE, consumer);
        flowerToDye(PURPLE_ZOA.get(), Items.PURPLE_DYE, consumer);

        tallFlowerToDye(DAWNFLAME.get(), Items.LIGHT_BLUE_DYE, consumer);
        tallFlowerToDye(SAPPHIRE_COWBELL.get(), Items.BLUE_DYE, consumer);

        // spiky shell
        shellBlockset(SPIKY_SHELL.get(), SPIKY_SHELL_BRICKS.get(), SPIKY_SHELL_BRICK_SLAB.get(), SPIKY_SHELL_BRICK_STAIRS.get(), SPIKY_SHELL_PILLAR.get(), consumer);

        // clam shell
        shellBlockset(CLAM_SHELL.get(), CLAM_SHELL_BRICKS.get(), CLAM_SHELL_BRICK_SLAB.get(), CLAM_SHELL_BRICK_STAIRS.get(), CLAM_SHELL_PILLAR.get(), consumer);

        // horn shell
        shellBlockset(HORN_SHELL.get(), HORN_SHELL_BRICKS.get(), HORN_SHELL_BRICK_SLAB.get(), HORN_SHELL_BRICK_STAIRS.get(), HORN_SHELL_PILLAR.get(), consumer);

        // swirl shell
        shellBlockset(SWIRL_SHELL.get(), SWIRL_SHELL_BRICKS.get(), SWIRL_SHELL_BRICK_SLAB.get(), SWIRL_SHELL_BRICK_STAIRS.get(), SWIRL_SHELL_PILLAR.get(), consumer);

        // spiral shell
        shellBlockset(SPIRAL_SHELL.get(), SPIRAL_SHELL_BRICKS.get(), SPIRAL_SHELL_BRICK_SLAB.get(), SPIRAL_SHELL_BRICK_STAIRS.get(), SPIRAL_SHELL_PILLAR.get(), consumer);

        // pyramid shell
        shellBlockset(PYRAMID_SHELL.get(), PYRAMID_SHELL_BRICKS.get(), PYRAMID_SHELL_BRICK_SLAB.get(), PYRAMID_SHELL_BRICK_STAIRS.get(), PYRAMID_SHELL_PILLAR.get(), consumer);

        // coraline sandstone
        blockset(null, CORALINE_SANDSTONE.get(), CHISELED_CORALINE_SANDSTONE.get(), CORALINE_SANDSTONE_SLAB.get(), CORALINE_SANDSTONE_STAIRS.get(), CORALINE_SANDSTONE_WALL.get(), true, consumer);
        blockset(null, SMOOTH_CORALINE_SANDSTONE.get(), null, SMOOTH_CORALINE_SANDSTONE_SLAB.get(), SMOOTH_CORALINE_SANDSTONE_STAIRS.get(), null, true, consumer);
        blockset(CORALINE_SANDSTONE.get(), CUT_CORALINE_SANDSTONE.get(), null, CUT_CORALINE_SANDSTONE_SLAB.get(), null, null, true, consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(CORALINE_SANDSTONE.get()), BUILDING_BLOCKS, SMOOTH_CORALINE_SANDSTONE.get(), 0.1F, 200).unlockedBy(getHasName(CORALINE_SANDSTONE.get()), has(CORALINE_SANDSTONE.get())).save(consumer, getSaveLocation(SMOOTH_CORALINE_SANDSTONE.get()));

        // volcanic sandstone
        blockset(null, VOLCANIC_SANDSTONE.get(), CHISELED_VOLCANIC_SANDSTONE.get(), VOLCANIC_SANDSTONE_SLAB.get(), VOLCANIC_SANDSTONE_STAIRS.get(), VOLCANIC_SANDSTONE_WALL.get(), true, consumer);
        blockset(null, SMOOTH_VOLCANIC_SANDSTONE.get(), null, SMOOTH_VOLCANIC_SANDSTONE_SLAB.get(), SMOOTH_VOLCANIC_SANDSTONE_STAIRS.get(), null, true, consumer);
        blockset(VOLCANIC_SANDSTONE.get(), CUT_VOLCANIC_SANDSTONE.get(), null, CUT_VOLCANIC_SANDSTONE_SLAB.get(), null, null, true, consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(VOLCANIC_SANDSTONE.get()), BUILDING_BLOCKS, SMOOTH_VOLCANIC_SANDSTONE.get(), 0.1F, 200).unlockedBy(getHasName(VOLCANIC_SANDSTONE.get()), has(VOLCANIC_SANDSTONE.get())).save(consumer, getSaveLocation(SMOOTH_VOLCANIC_SANDSTONE.get()));

        // scoria
        blockset(null, SCORIA.get(), null, SCORIA_SLAB.get(), SCORIA_STAIRS.get(), SCORIA_WALL.get(), true, consumer);
        blockset(SCORIA.get(), POLISHED_SCORIA.get(), null, POLISHED_SCORIA_SLAB.get(), POLISHED_SCORIA_STAIRS.get(), POLISHED_SCORIA_WALL.get(), true, consumer);
        blockset(POLISHED_SCORIA.get(), SCORIA_BRICKS.get(), CHISELED_SCORIA_BRICKS.get(), SCORIA_BRICK_SLAB.get(), SCORIA_BRICK_STAIRS.get(), SCORIA_BRICK_WALL.get(), true, consumer);
        blockset(null, SMOOTH_SCORIA.get(), null, SMOOTH_SCORIA_SLAB.get(), SMOOTH_SCORIA_STAIRS.get(), SMOOTH_SCORIA_WALL.get(), true, consumer);

        // sea glass
        seaGlassBlockset(Items.WHITE_DYE, WHITE_PEBBLED_SEA_GLASS.get(), WHITE_SEA_GLASS_BRICKS.get(), WHITE_SEA_GLASS_BRICK_SLAB.get(), WHITE_SEA_GLASS_BRICK_STAIRS.get(), WHITE_SEA_GLASS.get(), WHITE_SEA_GLASS_PANE.get(), WHITE_SEA_GLASS_LAMP.get(), WHITE_NETTED_SEA_GLASS_LAMP.get(), WHITE_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.LIGHT_GRAY_DYE, LIGHT_GRAY_PEBBLED_SEA_GLASS.get(), LIGHT_GRAY_SEA_GLASS_BRICKS.get(), LIGHT_GRAY_SEA_GLASS_BRICK_SLAB.get(), LIGHT_GRAY_SEA_GLASS_BRICK_STAIRS.get(), LIGHT_GRAY_SEA_GLASS.get(), LIGHT_GRAY_SEA_GLASS_PANE.get(), LIGHT_GRAY_SEA_GLASS_LAMP.get(), LIGHT_GRAY_NETTED_SEA_GLASS_LAMP.get(), LIGHT_GRAY_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.GRAY_DYE, GRAY_PEBBLED_SEA_GLASS.get(), GRAY_SEA_GLASS_BRICKS.get(), GRAY_SEA_GLASS_BRICK_SLAB.get(), GRAY_SEA_GLASS_BRICK_STAIRS.get(), GRAY_SEA_GLASS.get(), GRAY_SEA_GLASS_PANE.get(), GRAY_SEA_GLASS_LAMP.get(), GRAY_NETTED_SEA_GLASS_LAMP.get(), GRAY_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.BLACK_DYE, BLACK_PEBBLED_SEA_GLASS.get(), BLACK_SEA_GLASS_BRICKS.get(), BLACK_SEA_GLASS_BRICK_SLAB.get(), BLACK_SEA_GLASS_BRICK_STAIRS.get(), BLACK_SEA_GLASS.get(), BLACK_SEA_GLASS_PANE.get(), BLACK_SEA_GLASS_LAMP.get(), BLACK_NETTED_SEA_GLASS_LAMP.get(), BLACK_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.BROWN_DYE, BROWN_PEBBLED_SEA_GLASS.get(), BROWN_SEA_GLASS_BRICKS.get(), BROWN_SEA_GLASS_BRICK_SLAB.get(), BROWN_SEA_GLASS_BRICK_STAIRS.get(), BROWN_SEA_GLASS.get(), BROWN_SEA_GLASS_PANE.get(), BROWN_SEA_GLASS_LAMP.get(), BROWN_NETTED_SEA_GLASS_LAMP.get(), BROWN_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.RED_DYE, RED_PEBBLED_SEA_GLASS.get(), RED_SEA_GLASS_BRICKS.get(), RED_SEA_GLASS_BRICK_SLAB.get(), RED_SEA_GLASS_BRICK_STAIRS.get(), RED_SEA_GLASS.get(), RED_SEA_GLASS_PANE.get(), RED_SEA_GLASS_LAMP.get(), RED_NETTED_SEA_GLASS_LAMP.get(), RED_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.ORANGE_DYE, ORANGE_PEBBLED_SEA_GLASS.get(), ORANGE_SEA_GLASS_BRICKS.get(), ORANGE_SEA_GLASS_BRICK_SLAB.get(), ORANGE_SEA_GLASS_BRICK_STAIRS.get(), ORANGE_SEA_GLASS.get(), ORANGE_SEA_GLASS_PANE.get(), ORANGE_SEA_GLASS_LAMP.get(), ORANGE_NETTED_SEA_GLASS_LAMP.get(), ORANGE_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.YELLOW_DYE, YELLOW_PEBBLED_SEA_GLASS.get(), YELLOW_SEA_GLASS_BRICKS.get(), YELLOW_SEA_GLASS_BRICK_SLAB.get(), YELLOW_SEA_GLASS_BRICK_STAIRS.get(), YELLOW_SEA_GLASS.get(), YELLOW_SEA_GLASS_PANE.get(), YELLOW_SEA_GLASS_LAMP.get(), YELLOW_NETTED_SEA_GLASS_LAMP.get(), YELLOW_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.LIME_DYE, LIME_PEBBLED_SEA_GLASS.get(), LIME_SEA_GLASS_BRICKS.get(), LIME_SEA_GLASS_BRICK_SLAB.get(), LIME_SEA_GLASS_BRICK_STAIRS.get(), LIME_SEA_GLASS.get(), LIME_SEA_GLASS_PANE.get(), LIME_SEA_GLASS_LAMP.get(), LIME_NETTED_SEA_GLASS_LAMP.get(), LIME_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.GREEN_DYE, GREEN_PEBBLED_SEA_GLASS.get(), GREEN_SEA_GLASS_BRICKS.get(), GREEN_SEA_GLASS_BRICK_SLAB.get(), GREEN_SEA_GLASS_BRICK_STAIRS.get(), GREEN_SEA_GLASS.get(), GREEN_SEA_GLASS_PANE.get(), GREEN_SEA_GLASS_LAMP.get(), GREEN_NETTED_SEA_GLASS_LAMP.get(), GREEN_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.CYAN_DYE, CYAN_PEBBLED_SEA_GLASS.get(), CYAN_SEA_GLASS_BRICKS.get(), CYAN_SEA_GLASS_BRICK_SLAB.get(), CYAN_SEA_GLASS_BRICK_STAIRS.get(), CYAN_SEA_GLASS.get(), CYAN_SEA_GLASS_PANE.get(), CYAN_SEA_GLASS_LAMP.get(), CYAN_NETTED_SEA_GLASS_LAMP.get(), CYAN_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.LIGHT_BLUE_DYE, LIGHT_BLUE_PEBBLED_SEA_GLASS.get(), LIGHT_BLUE_SEA_GLASS_BRICKS.get(), LIGHT_BLUE_SEA_GLASS_BRICK_SLAB.get(), LIGHT_BLUE_SEA_GLASS_BRICK_STAIRS.get(), LIGHT_BLUE_SEA_GLASS.get(), LIGHT_BLUE_SEA_GLASS_PANE.get(), LIGHT_BLUE_SEA_GLASS_LAMP.get(), LIGHT_BLUE_NETTED_SEA_GLASS_LAMP.get(), LIGHT_BLUE_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.BLUE_DYE, BLUE_PEBBLED_SEA_GLASS.get(), BLUE_SEA_GLASS_BRICKS.get(), BLUE_SEA_GLASS_BRICK_SLAB.get(), BLUE_SEA_GLASS_BRICK_STAIRS.get(), BLUE_SEA_GLASS.get(), BLUE_SEA_GLASS_PANE.get(), BLUE_SEA_GLASS_LAMP.get(), BLUE_NETTED_SEA_GLASS_LAMP.get(), BLUE_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.PURPLE_DYE, PURPLE_PEBBLED_SEA_GLASS.get(), PURPLE_SEA_GLASS_BRICKS.get(), PURPLE_SEA_GLASS_BRICK_SLAB.get(), PURPLE_SEA_GLASS_BRICK_STAIRS.get(), PURPLE_SEA_GLASS.get(), PURPLE_SEA_GLASS_PANE.get(), PURPLE_SEA_GLASS_LAMP.get(), PURPLE_NETTED_SEA_GLASS_LAMP.get(), PURPLE_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.MAGENTA_DYE, MAGENTA_PEBBLED_SEA_GLASS.get(), MAGENTA_SEA_GLASS_BRICKS.get(), MAGENTA_SEA_GLASS_BRICK_SLAB.get(), MAGENTA_SEA_GLASS_BRICK_STAIRS.get(), MAGENTA_SEA_GLASS.get(), MAGENTA_SEA_GLASS_PANE.get(), MAGENTA_SEA_GLASS_LAMP.get(), MAGENTA_NETTED_SEA_GLASS_LAMP.get(), MAGENTA_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
        seaGlassBlockset(Items.PINK_DYE, PINK_PEBBLED_SEA_GLASS.get(), PINK_SEA_GLASS_BRICKS.get(), PINK_SEA_GLASS_BRICK_SLAB.get(), PINK_SEA_GLASS_BRICK_STAIRS.get(), PINK_SEA_GLASS.get(), PINK_SEA_GLASS_PANE.get(), PINK_SEA_GLASS_LAMP.get(), PINK_NETTED_SEA_GLASS_LAMP.get(), PINK_MOSAIC_SEA_GLASS_LAMP.get(), consumer);
    }

    private static void conditionalRecipe(RecipeBuilder recipe, ICondition condition, Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        ConditionalRecipe.builder().addCondition(condition).addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath())).build(consumer, id);
    }

    private static void blockset(ItemLike ingredient, Block block, Block chiseledBlock, Block slab, Block stairs, Block wall, boolean stonecutter, Consumer<FinishedRecipe> consumer) {
        if (ingredient != null) {
            ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, block, 4).define('#', ingredient).pattern("##").pattern("##").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(block));
        }

        if (chiseledBlock != null) {
            ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, chiseledBlock).define('#', slab).pattern("#").pattern("#").unlockedBy(getHasName(block), has(block)).save(consumer, getSaveLocation(chiseledBlock));
            if (stonecutter) {
                stonecutting(block, chiseledBlock, 1, consumer);
            }
        }

        if (slab != null) {
            slab(block, slab, consumer);
            if (stonecutter) {
                stonecutting(block, slab, 2, consumer);
            }
        }

        if (stairs != null) {
            stairs(block, stairs, consumer);
            if (stonecutter) {
                stonecutting(block, stairs, 1, consumer);
            }
        }

        if (wall != null) {
            wall(block, wall, consumer);
            if (stonecutter) {
                stonecutting(block, wall, 1, consumer);
            }
        }
    }

    private static void shellBlockset(ItemLike shell, Block block, Block slab, Block stairs, Block pillar, Consumer<FinishedRecipe> consumer) {
        blockset(shell, block, null, slab, stairs, null, true, consumer);
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, pillar, 2).define('#', block).pattern("#").pattern("#").unlockedBy(getHasName(block), has(block)).save(consumer, getSaveLocation(getName(pillar)));
        stonecutting(block, pillar, 1, consumer);
    }

    private static void seaGlassBlockset(ItemLike dye, Block pebbledBlock, Block bricks, Block brickSlab, Block brickStairs, Block seaGlass, Block seaGlassPane, Block lamp, Block nettedLamp, Block mosaicLamp, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, pebbledBlock, 1).define('#', SeafarerItems.SEA_GLASS_PEBBLES.get()).define('D', dye).pattern("###").pattern("#D#").pattern("###").unlockedBy(getHasName(SeafarerItems.SEA_GLASS_PEBBLES.get()), has(SeafarerItems.SEA_GLASS_PEBBLES.get())).save(consumer, getSaveLocation(pebbledBlock));
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, bricks, 4).define('#', pebbledBlock).pattern("##").pattern("##").unlockedBy(getHasName(pebbledBlock), has(pebbledBlock)).save(consumer, getSaveLocation(bricks));
        slab(bricks, brickSlab, consumer);
        stonecutting(bricks, brickSlab, 2, consumer);
        stairs(bricks, brickStairs, consumer);
        stonecutting(bricks, brickStairs, 1, consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(pebbledBlock), BUILDING_BLOCKS, seaGlass, 0.1F, 200).unlockedBy(getHasName(pebbledBlock), has(pebbledBlock)).save(consumer, getSaveLocation(seaGlass));
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, seaGlassPane, 16).define('#', seaGlass).pattern("###").pattern("###").unlockedBy(getHasName(seaGlass), has(seaGlass)).save(consumer, getSaveLocation(getName(seaGlassPane)));
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, lamp, 4).define('#', seaGlass).define('X', Items.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").unlockedBy(getHasName(seaGlass), has(seaGlass)).save(consumer, getSaveLocation(getName(lamp)));
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, nettedLamp, 1).define('#', FISHING_NET.get()).define('X', lamp).pattern("###").pattern("#X#").pattern("###").unlockedBy(getHasName(lamp), has(lamp)).save(consumer, getSaveLocation(getName(nettedLamp)));
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, mosaicLamp, 1).define('#', Items.IRON_NUGGET).define('X', lamp).pattern("###").pattern("#X#").pattern("###").unlockedBy(getHasName(lamp), has(lamp)).save(consumer, getSaveLocation(getName(mosaicLamp)));
    }

    private static void stonecutting(ItemLike ingredient, ItemLike result, int amount, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), BUILDING_BLOCKS, result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(ingredient) + "_from_" + getName(result) + "_stonecutting"));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, stairs, 4).define('#', ingredient).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(stairs)));
    }

    private static void wall(ItemLike ingredient, ItemLike wall, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, wall, 6).define('#', ingredient).pattern("###").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(wall)));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, slab, 6).define('#', ingredient).pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(slab)));
    }

    private static void cooking(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), FOOD, result, .35f, 200).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(result));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), FOOD, result, .35f, 600).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(result) + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), FOOD, result, .35f, 100).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(getName(result) + "_from_smoking"));
    }

    private static void flowerToDye(Block flower, Item dye, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(MISC, dye).group(getName(dye)).requires(flower).unlockedBy(getHasName(flower), has(flower)).save(consumer, getSaveLocation(getName(dye) + "_from_" + getName(flower)));
    }

    private static void tallFlowerToDye(Block flower, Item dye, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, dye, 2).group(getName(dye)).requires(flower).unlockedBy(getHasName(flower), has(flower)).save(consumer, getSaveLocation(getName(dye) + "_from_" + getName(flower)));
    }

    private static String getName(ItemLike object) {
        return ForgeRegistries.ITEMS.getKey(object.asItem()).getPath();
    }

    private static ResourceLocation getSaveLocation(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem());
    }

    private static ResourceLocation getSaveLocation(String name) {
        return Seafarer.modPrefix(name);
    }
}

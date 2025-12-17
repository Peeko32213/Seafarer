package com.barlinc.seafarer.registry;

import net.minecraft.world.food.FoodProperties;

public class SeafarerFoodValues {

    public static final FoodProperties COOKED_STARFISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).meat().build();

    // Condiment
    public static final FoodProperties SOY_SAUCE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();

}

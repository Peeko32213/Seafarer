package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.items.SeafarerDrinkableItem;
import com.barlinc.seafarer.items.SeafarerMobBucketItem;
import com.barlinc.seafarer.items.*;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SeafarerItems {

    public static List<RegistryObject<? extends Item>> ITEM_TRANSLATIONS = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Seafarer.MOD_ID);

    public static final RegistryObject<Item> SEAFARER = registerItem("seafarer", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> SEA_GLASS_PEBBLES = registerItem("sea_glass_pebbles", () -> new Item(new Item.Properties()));

    // horseshoe crab
    public static final RegistryObject<Item> HORSESHOE_CRAB_SPAWN_EGG = registerSpawnEgg("horseshoe_crab", SeafarerEntities.HORSESHOE_CRAB , 0x251a13, 0x473d2c);
    public static final RegistryObject<Item> HORSESHOE_CRAB_BUCKET = registerItemNoLang("horseshoe_crab_bucket", () -> new SeafarerMobBucketItem(SeafarerEntities.HORSESHOE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RAW_HORSESHOE_CRAB = registerItemNoLang("horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_HORSESHOE_CRAB)));
    public static final RegistryObject<Item> COOKED_HORSESHOE_CRAB = registerItem("cooked_horseshoe_crab", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_HORSESHOE_CRAB)));

    // magmaw
    public static final RegistryObject<Item> MAGMAW_SPAWN_EGG = registerSpawnEgg("magmaw", SeafarerEntities.MAGMAW , 0x131613, 0xbd7f0d);

    // manta ray
    public static final RegistryObject<Item> MANTA_RAY_SPAWN_EGG = registerSpawnEgg("manta_ray", SeafarerEntities.MANTA_RAY , 0x070708, 0xedf5f5);

    // shore crab
    public static final RegistryObject<Item> SHORE_CRAB_SPAWN_EGG = registerSpawnEgg("shore_crab", SeafarerEntities.SHORE_CRAB, 0xf3901f, 0x92fedb);
    public static final RegistryObject<Item> SHORE_CRAB_BUCKET = registerItemNoLang("shore_crab_bucket", () -> new SeafarerMobBucketItem(SeafarerEntities.SHORE_CRAB, () -> Fluids.WATER, false, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RAW_SHORE_CRAB_LEG = registerItemNoLang("shore_crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.RAW_SHORE_CRAB)));
    public static final RegistryObject<Item> COOKED_SHORE_CRAB_LEG = registerItem("cooked_shore_crab_leg", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_SHORE_CRAB)));

    // snake mackerel
    public static final RegistryObject<Item> SNAKE_MACKEREL_SPAWN_EGG = registerSpawnEgg("snake_mackerel", SeafarerEntities.SNAKE_MACKEREL, 0x1f1526, 0x355450);

    // sunfish
    public static final RegistryObject<Item> SUNFISH_SPAWN_EGG = registerSpawnEgg("sunfish", SeafarerEntities.SUNFISH , 0x628398, 0x33436b);

    public static final RegistryObject<Item> DRIED_STARFISH = registerItem("dried_starfish", () -> new Item(new Item.Properties().food(SeafarerFoodValues.COOKED_STARFISH)));

    // spices and sauces
    public static final RegistryObject<Item> SOY_SAUCE = registerItem("soy_sauce", () -> new SeafarerDrinkableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(SeafarerFoodValues.SOY_SAUCE), false, false));

    // amber coral
    public static final RegistryObject<Item> AMBER_CORAL_FAN = registerItemNoLang("amber_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.AMBER_CORAL_FAN.get(), SeafarerBlocks.AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_AMBER_CORAL_FAN = registerItemNoLang("dead_amber_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_AMBER_CORAL_FAN.get(), SeafarerBlocks.DEAD_AMBER_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    // cerulean coral
    public static final RegistryObject<Item> CERULEAN_CORAL_FAN = registerItemNoLang("cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.CERULEAN_CORAL_FAN.get(), SeafarerBlocks.CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_CERULEAN_CORAL_FAN = registerItemNoLang("dead_cerulean_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_CERULEAN_CORAL_FAN.get(), SeafarerBlocks.DEAD_CERULEAN_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    // maroon coral
    public static final RegistryObject<Item> MAROON_CORAL_FAN = registerItemNoLang("maroon_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.MAROON_CORAL_FAN.get(), SeafarerBlocks.MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_MAROON_CORAL_FAN = registerItemNoLang("dead_maroon_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_MAROON_CORAL_FAN.get(), SeafarerBlocks.DEAD_MAROON_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    // olive coral
    public static final RegistryObject<Item> OLIVE_CORAL_FAN = registerItemNoLang("olive_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.OLIVE_CORAL_FAN.get(), SeafarerBlocks.OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_OLIVE_CORAL_FAN = registerItemNoLang("dead_olive_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_OLIVE_CORAL_FAN.get(), SeafarerBlocks.DEAD_OLIVE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    // turquoise coral
    public static final RegistryObject<Item> TURQUOISE_CORAL_FAN = registerItemNoLang("turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.TURQUOISE_CORAL_FAN.get(), SeafarerBlocks.TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_TURQUOISE_CORAL_FAN = registerItemNoLang("dead_turquoise_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_TURQUOISE_CORAL_FAN.get(), SeafarerBlocks.DEAD_TURQUOISE_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    // verdant coral
    public static final RegistryObject<Item> VERDANT_CORAL_FAN = registerItemNoLang("verdant_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.VERDANT_CORAL_FAN.get(), SeafarerBlocks.VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEAD_VERDANT_CORAL_FAN = registerItemNoLang("dead_verdant_coral_fan", () -> new StandingAndWallBlockItem(SeafarerBlocks.DEAD_VERDANT_CORAL_FAN.get(), SeafarerBlocks.DEAD_VERDANT_CORAL_WALL_FAN.get(), new Item.Properties(), Direction.DOWN));

    public static RegistryObject<Item> registerSpawnEgg(String name, RegistryObject type, int baseColor, int spotColor) {
        return registerItem(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, baseColor, spotColor, new Item.Properties()));
    }

    public static <I extends Item> RegistryObject<I> registerItemNoLang(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        return item;
    }

    public static <I extends Item> RegistryObject<I> registerItem(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = ITEMS.register(name, supplier);
        ITEM_TRANSLATIONS.add(item);
        return item;
    }
}

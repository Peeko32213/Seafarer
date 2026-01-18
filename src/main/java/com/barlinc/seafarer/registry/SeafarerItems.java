package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.items.SeafarerDrinkableItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
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

    // magmaw
//    public static final RegistryObject<Item> MAGMAW_SPAWN_EGG = registerSpawnEgg("magmaw", SeafarerEntities.MAGMAW , 0x1f1e18, 0xded255);

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

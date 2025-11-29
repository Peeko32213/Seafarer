package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public final class SeafarerPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Seafarer.MOD_ID);
    public static Map<String, String> PAINTING_TRANSLATIONS = new HashMap<>();

    // Paintings
    public static final RegistryObject<PaintingVariant> REEF = painting("reef", "OmayPaty", 16, 32);
    public static final RegistryObject<PaintingVariant> TROPICAL = painting("tropical", "OmayPaty", 16, 32);
    public static final RegistryObject<PaintingVariant> BEACHCOMBER = painting("beachcomber", "OmayPaty", 32, 32);
    public static final RegistryObject<PaintingVariant> COLLECTOR = painting("collector", "OmayPaty", 32, 32);

    public static RegistryObject<PaintingVariant> painting(String name, String author, int width, int height) {
        PAINTING_TRANSLATIONS.put(name, author);
        return PAINTING_VARIANTS.register(name, () -> new PaintingVariant(width, height));
    }
}
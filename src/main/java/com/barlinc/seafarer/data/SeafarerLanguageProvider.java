package com.barlinc.seafarer.data;

import com.barlinc.seafarer.SeafarerTab;
import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerBlocks;
import com.barlinc.seafarer.registry.SeafarerItems;
import com.barlinc.seafarer.registry.SeafarerPaintings;
import com.barlinc.seafarer.registry.SeafarerSoundEvents;
import com.barlinc.seafarer.registry.*;
import com.barlinc.seafarer.registry.worldgen.SeafarerBiomes;
import com.barlinc.seafarer.utils.SeafarerTextUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public class SeafarerLanguageProvider extends LanguageProvider {

    public SeafarerLanguageProvider(PackOutput output) {
        super(output, Seafarer.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations(){
        translateCreativeTab(SeafarerTab.SEAFARER_TAB.get(), "Seafarer");

        SeafarerBlocks.BLOCK_TRANSLATIONS.forEach(this::forBlocks);
        SeafarerItems.ITEM_TRANSLATIONS.forEach(this::forItems);
        SeafarerPaintings.PAINTING_TRANSLATIONS.forEach(this::translatePainting);

        // Raw food
        this.addItem(SeafarerItems.RAW_HORSESHOE_CRAB, "Raw Horseshoe Crab");
        this.addItem(SeafarerItems.RAW_SHORE_CRAB_LEG, "Raw Shore Crab Leg");

        this.addItem(SeafarerItems.SHORE_CRAB_BUCKET, "Bucket of Shore Crab");
        this.addItem(SeafarerItems.HORSESHOE_CRAB_BUCKET, "Bucket of Horseshoe Crab");

        this.translateBiome(SeafarerBiomes.FLOWERING_BEACH);
        this.translateBiome(SeafarerBiomes.VOLCANIC_ISLAND);
        this.translateBiome(SeafarerBiomes.GLASS_BEACH);

        this.translateSound(SeafarerSoundEvents.FISH_IDLE, "Fish gurgles");
        this.translateSound(SeafarerSoundEvents.FISH_DEATH, "Fish dies");
        this.translateSound(SeafarerSoundEvents.FISH_HURT, "Fish hurts");
        this.translateSound(SeafarerSoundEvents.FISH_FLOP, "Fish flops");
        this.translateSound(SeafarerSoundEvents.FISH_JUMP, "Fish jumps");
    }

    @Override
    public @NotNull String getName() {
        return  Seafarer.MOD_ID + " Languages: en_us";
    }

    public void translateSound(Supplier<? extends SoundEvent> key, String name){
        add(Seafarer.MOD_ID + ".sound.subtitle." + key.get().getLocation().getPath(), name);
    }

    public void translateCreativeTab(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void translateEnchantmentWithDescription(String description, Enchantment enchantment){
        add(enchantment.getDescriptionId() + ".desc", description);
    }

    private void translateBiome(ResourceKey<Biome> biome) {
        String name = biome.location().getPath();
        this.add("biome." + Seafarer.MOD_ID + "." + name, SeafarerTextUtils.createTranslation(name));
    }

    public void translatePotion(Supplier<? extends Potion> key, String name, String regName) {
        add("registerItemNoLang.minecraft.potion.effect." + regName, name);
        add("registerItemNoLang.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("registerItemNoLang.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }

    protected void translatePainting(String name, String author) {
        add("painting." + Seafarer.MOD_ID + "." + name + ".title",  SeafarerTextUtils.createTranslation(name));
        add("painting." + Seafarer.MOD_ID + "." + name + ".author",  author);
    }

    protected void forBlocks(Supplier<? extends Block> block) {
        addBlock(block, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItems(Supplier<? extends Item> item) {
        addItem(item, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }
}

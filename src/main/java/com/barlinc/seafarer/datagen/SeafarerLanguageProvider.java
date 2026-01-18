package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.SeafarerTab;
import com.barlinc.seafarer.registry.*;
import com.barlinc.seafarer.utils.SeafarerTextUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public class SeafarerLanguageProvider extends LanguageProvider {

    public SeafarerLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), Seafarer.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations(){
        translateCreativeTab(SeafarerTab.SEAFARER_TAB.get(), "Seafarer");

        SeafarerBlocks.BLOCK_TRANSLATIONS.forEach(this::forBlocks);
        SeafarerItems.ITEM_TRANSLATIONS.forEach(this::forItems);
        SeafarerPaintings.PAINTING_TRANSLATIONS.forEach(this::translatePainting);

        this.forEntity(SeafarerEntities.CLUTCH);
        this.forEntity(SeafarerEntities.MAGMAW);

        this.translateBiome(SeafarerBiomes.VOLCANIC_ISLAND);

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
        this.add(Seafarer.MOD_ID + ".sound.subtitle." + key.get().getLocation().getPath(), name);
    }

    public void translateCreativeTab(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    private void translateBiome(ResourceKey<Biome> biome) {
        String name = biome.location().getPath();
        this.add("biome." + Seafarer.MOD_ID + "." + name, SeafarerTextUtils.createTranslation(name));
    }

    protected void translatePainting(String name, String author) {
        this.add("painting." + Seafarer.MOD_ID + "." + name + ".title",  SeafarerTextUtils.createTranslation(name));
        this.add("painting." + Seafarer.MOD_ID + "." + name + ".author",  author);
    }

    protected void forBlocks(Supplier<? extends Block> block) {
        this.addBlock(block, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    protected void forItems(Supplier<? extends Item> item) {
        this.addItem(item, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }

    private void forEntity(Supplier<? extends EntityType<?>> entity) {
        this.addEntityType(entity, SeafarerTextUtils.createTranslation(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.get())).getPath()));
    }
}

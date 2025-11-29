package com.barlinc.seafarer.data;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerPaintings;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SeafarerPaintingTagProvider extends PaintingVariantTagsProvider {

    public SeafarerPaintingTagProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, Seafarer.MOD_ID, helper);
    }

    @Override
    protected void addTags(@NotNull Provider provider) {
        TagAppender<PaintingVariant> appender = this.tag(PaintingVariantTags.PLACEABLE);
        for (RegistryObject<PaintingVariant> variant : SeafarerPaintings.PAINTING_VARIANTS.getEntries()) {
            appender.add(variant.getKey());
        }
    }
}

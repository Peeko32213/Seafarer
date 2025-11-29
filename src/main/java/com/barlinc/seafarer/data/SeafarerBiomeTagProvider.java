package com.barlinc.seafarer.data;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.tags.SeafarerBiomeTags;
import com.barlinc.seafarer.registry.worldgen.SeafarerBiomes;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class SeafarerBiomeTagProvider extends BiomeTagsProvider {

    public SeafarerBiomeTagProvider(PackOutput output, CompletableFuture<Provider> provider, ExistingFileHelper helper) {
        super(output, provider, Seafarer.MOD_ID, helper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.addTags();
    }

    protected void addTags() {

        this.tag(SeafarerBiomeTags.HAS_VOLCANOES).add(SeafarerBiomes.VOLCANIC_ISLAND);

        this.tag(BiomeTags.IS_OVERWORLD).add(
                SeafarerBiomes.VOLCANIC_ISLAND,
                SeafarerBiomes.FLOWERING_BEACH,
                SeafarerBiomes.GLASS_BEACH
        );
    }
}

package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.tags.SeafarerEntityTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class SeafarerEntityTagProvider extends EntityTypeTagsProvider {

    public SeafarerEntityTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, Seafarer.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {

        this.tag(SeafarerEntityTags.COLLIDES_WITH_FISHING_NETS).add(
                EntityType.AXOLOTL,
                EntityType.FROG
        );
    }

    @Override
    public String getName() {
        return Seafarer.MOD_ID + " Entity type tags provider";
    }
}

package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.tags.SeafarerBlockTags;
import com.barlinc.seafarer.registry.tags.SeafarerItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SeafarerItemTagProvider extends ItemTagsProvider {

    public SeafarerItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, completableFuture, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        this.copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
//        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        this.copy(SeafarerBlockTags.SEA_GLASS, SeafarerItemTags.SEA_GLASS);
        this.copy(SeafarerBlockTags.SEA_GLASS_PANES, SeafarerItemTags.SEA_GLASS_PANES);

        this.tag(Tags.Items.GLASS).addTag(SeafarerItemTags.SEA_GLASS);
        this.tag(Tags.Items.GLASS_PANES).addTag(SeafarerItemTags.SEA_GLASS_PANES);

        this.copy(Tags.Blocks.GLASS_WHITE, Tags.Items.GLASS_WHITE);
        this.copy(Tags.Blocks.GLASS_LIGHT_GRAY, Tags.Items.GLASS_LIGHT_GRAY);
        this.copy(Tags.Blocks.GLASS_GRAY, Tags.Items.GLASS_GRAY);
        this.copy(Tags.Blocks.GLASS_BLACK, Tags.Items.GLASS_BLACK);
        this.copy(Tags.Blocks.GLASS_BROWN, Tags.Items.GLASS_BROWN);
        this.copy(Tags.Blocks.GLASS_RED, Tags.Items.GLASS_RED);
        this.copy(Tags.Blocks.GLASS_ORANGE, Tags.Items.GLASS_ORANGE);
        this.copy(Tags.Blocks.GLASS_YELLOW, Tags.Items.GLASS_YELLOW);
        this.copy(Tags.Blocks.GLASS_LIME, Tags.Items.GLASS_LIME);
        this.copy(Tags.Blocks.GLASS_GREEN, Tags.Items.GLASS_GREEN);
        this.copy(Tags.Blocks.GLASS_CYAN, Tags.Items.GLASS_CYAN);
        this.copy(Tags.Blocks.GLASS_LIGHT_BLUE, Tags.Items.GLASS_LIGHT_BLUE);
        this.copy(Tags.Blocks.GLASS_BLUE, Tags.Items.GLASS_BLUE);
        this.copy(Tags.Blocks.GLASS_PURPLE, Tags.Items.GLASS_PURPLE);
        this.copy(Tags.Blocks.GLASS_MAGENTA, Tags.Items.GLASS_MAGENTA);
        this.copy(Tags.Blocks.GLASS_PINK, Tags.Items.GLASS_PINK);

        this.copy(Tags.Blocks.GLASS_PANES_WHITE, Tags.Items.GLASS_PANES_WHITE);
        this.copy(Tags.Blocks.GLASS_PANES_LIGHT_GRAY, Tags.Items.GLASS_PANES_LIGHT_GRAY);
        this.copy(Tags.Blocks.GLASS_PANES_GRAY, Tags.Items.GLASS_PANES_GRAY);
        this.copy(Tags.Blocks.GLASS_PANES_BLACK, Tags.Items.GLASS_PANES_BLACK);
        this.copy(Tags.Blocks.GLASS_PANES_BROWN, Tags.Items.GLASS_PANES_BROWN);
        this.copy(Tags.Blocks.GLASS_PANES_RED, Tags.Items.GLASS_PANES_RED);
        this.copy(Tags.Blocks.GLASS_PANES_ORANGE, Tags.Items.GLASS_PANES_ORANGE);
        this.copy(Tags.Blocks.GLASS_PANES_YELLOW, Tags.Items.GLASS_PANES_YELLOW);
        this.copy(Tags.Blocks.GLASS_PANES_LIME, Tags.Items.GLASS_PANES_LIME);
        this.copy(Tags.Blocks.GLASS_PANES_GREEN, Tags.Items.GLASS_PANES_GREEN);
        this.copy(Tags.Blocks.GLASS_PANES_CYAN, Tags.Items.GLASS_PANES_CYAN);
        this.copy(Tags.Blocks.GLASS_PANES_LIGHT_BLUE, Tags.Items.GLASS_PANES_LIGHT_BLUE);
        this.copy(Tags.Blocks.GLASS_PANES_BLUE, Tags.Items.GLASS_PANES_BLUE);
        this.copy(Tags.Blocks.GLASS_PANES_PURPLE, Tags.Items.GLASS_PANES_PURPLE);
        this.copy(Tags.Blocks.GLASS_PANES_MAGENTA, Tags.Items.GLASS_PANES_MAGENTA);
        this.copy(Tags.Blocks.GLASS_PANES_PINK, Tags.Items.GLASS_PANES_PINK);

        this.tag(SeafarerItemTags.ROPES)
                .addOptional(new ResourceLocation("supplementaries", "rope"))
                .addOptional(new ResourceLocation("farmersdelight", "rope"));
    }

    @Override
    public String getName() { return Seafarer.MOD_ID + " Item Tags";}
}

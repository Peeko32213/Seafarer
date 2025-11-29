package com.barlinc.seafarer.data;


import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerItemModelProvider extends ItemModelProvider {
    public SeafarerItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Seafarer.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){

        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof SpawnEggItem && ForgeRegistries.ITEMS.getKey(item).getNamespace().equals(Seafarer.MOD_ID)) {
                this.getBuilder(ForgeRegistries.ITEMS.getKey(item).getPath()).parent(getExistingFile(new ResourceLocation("item/template_spawn_egg")));
            }
        }

        this.item(SeafarerItems.SEAFARER);

        this.item(SeafarerItems.SEA_GLASS_PEBBLES);

        this.item(SeafarerItems.RAW_SHORE_CRAB_LEG);
        this.item(SeafarerItems.COOKED_SHORE_CRAB_LEG);
        this.item(SeafarerItems.RAW_HORSESHOE_CRAB);
        this.item(SeafarerItems.COOKED_HORSESHOE_CRAB);
        this.item(SeafarerItems.DRIED_STARFISH);
        this.item(SeafarerItems.SOY_SAUCE);

        this.item(SeafarerItems.SHORE_CRAB_BUCKET);
        this.item(SeafarerItems.HORSESHOE_CRAB_BUCKET);
    }

    private void toBlock(RegistryObject<Block> b) {
        toBlockModel(b, b.getId().getPath());
    }

    private void toBlockModel(RegistryObject<Block> b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void toBlockModel(RegistryObject<Block> b, ResourceLocation model) {
        withExistingParent(b.getId().getPath(), model);
    }

    private ItemModelBuilder item(RegistryObject<Item> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    public static ResourceLocation prefix(String name){
        return new ResourceLocation(Seafarer.MOD_ID, name);
    }
    public static ResourceLocation key(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}

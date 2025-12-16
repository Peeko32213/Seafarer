package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerItemModelProvider extends ItemModelProvider {

    public SeafarerItemModelProvider(GatherDataEvent event) {
        super(event.getGenerator().getPackOutput(), Seafarer.MOD_ID, event.getExistingFileHelper());
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

        this.item(SeafarerItems.DRIED_STARFISH);
        this.item(SeafarerItems.SOY_SAUCE);
    }


    // item
    private ItemModelBuilder item(RegistryObject<?> item) {
        return generated(item.getId().getPath(), modLoc("item/" + item.getId().getPath()));
    }

    // utils
    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
}

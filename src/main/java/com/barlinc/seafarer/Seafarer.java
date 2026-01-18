package com.barlinc.seafarer;

import com.barlinc.seafarer.datagen.*;
import com.barlinc.seafarer.events.ClientEvents;
import com.barlinc.seafarer.registry.*;
import com.barlinc.seafarer.utils.ClientProxy;
import com.barlinc.seafarer.utils.CommonProxy;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Mod(Seafarer.MOD_ID)
public class Seafarer {

    public static final String MOD_ID = "seafarer";
    public static CommonProxy PROXY = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public Seafarer() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientEvents::init));
        bus.addListener(this::dataSetup);

        SeafarerItems.ITEMS.register(bus);
        SeafarerBlocks.BLOCKS.register(bus);
        SeafarerBlockEntities.BLOCK_ENTITIES.register(bus);
        SeafarerTab.CREATIVE_TABS.register(bus);
        SeafarerEntities.ENTITY_TYPES.register(bus);
        SeafarerFeatures.FEATURES.register(bus);
        SeafarerStructureTypes.STRUCTURE_TYPES.register(bus);
        SeafarerStructurePieces.STRUCTURE_PIECES.register(bus);
        SeafarerLootModifiers.LOOT_MODIFIERS.register(bus);
        SeafarerSoundEvents.SOUND_EVENTS.register(bus);
        SeafarerParticles.PARTICLE_TYPES.register(bus);
        SeafarerPaintings.PAINTING_VARIANTS.register(bus);

        PROXY.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PROXY.commonSetup();
            addToComposter(SeafarerBlocks.COASTAL_LAVENDER, 0.7F);
            addToComposter(SeafarerBlocks.COASTAL_WILDFLOWER, 0.3F);
            addToComposter(SeafarerBlocks.SEA_THRIFT, 0.5F);
            addToComposter(SeafarerBlocks.SEA_HOLLY, 0.6F);
            addToComposter(SeafarerBlocks.FIERY_DUSTER, 0.6F);
            addToComposter(SeafarerBlocks.SILK_LILIES, 0.6F);
            addToComposter(SeafarerBlocks.TWILIGHT_BLADE, 0.6F);
            addToComposter(SeafarerBlocks.DAWNFLAME, 0.7F);
        });
    }

    public void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> PROXY.clientSetup());
    }

    private void dataSetup(GatherDataEvent data) {
        DataGenerator generator = data.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = data.getLookupProvider();
        ExistingFileHelper helper = data.getExistingFileHelper();

        boolean server = data.includeServer();

        SeafarerDatapackProvider datapackEntries = new SeafarerDatapackProvider(output, provider);
        generator.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        SeafarerBlockTagProvider blockTags = new SeafarerBlockTagProvider(output, provider, helper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new SeafarerItemTagProvider(output, provider, blockTags.contentsGetter(), helper));
        generator.addProvider(server, new SeafarerEntityTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerBiomeTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerPaintingTagProvider(output, provider, helper));
        generator.addProvider(server, new SeafarerRecipeProvider(output));
        generator.addProvider(server, new SeafarerLootTableProvider(output));
//        generator.addProvider(server, new SeafarerChunkGeneratorModifierProvider(output, provider));

        boolean client = data.includeClient();

        generator.addProvider(client, new SeafarerBlockstateProvider(data));
        generator.addProvider(client, new SeafarerItemModelProvider(data));
        generator.addProvider(client, new SeafarerLanguageProvider(data));
        generator.addProvider(client, new SeafarerSoundDefinitionsProvider(output, helper));
    }

    public static void addToComposter(RegistryObject<Block> item, float amountOfCompost) {
        ComposterBlock.COMPOSTABLES.put(item.get().asItem(), amountOfCompost);
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}

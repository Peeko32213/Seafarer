package com.barlinc.seafarer.events;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.*;
import com.barlinc.seafarer.client.renderer.*;
import com.barlinc.seafarer.registry.*;
import com.barlinc.seafarer.client.models.*;
import com.barlinc.seafarer.client.particles.VolcanicSmokeParticle;
import com.barlinc.seafarer.registry.*;
import com.barlinc.seafarer.client.renderer.*;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(SeafarerItemProperties::addItemProperties);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, world, pos, tintIndex) -> {
                    if (world == null || pos == null) {
                        return FoliageColor.getDefaultColor();
                    }
                    return BiomeColors.getAverageFoliageColor(world, pos);
                },
                SeafarerBlocks.WHITE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.ORANGE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.YELLOW_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.BLUE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.MAGENTA_FLOWERING_JUNGLE_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> {
                    BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
                    return event.getBlockColors().getColor(blockstate, null, null, tintIndex);
                },
                SeafarerBlocks.WHITE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.ORANGE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.YELLOW_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.BLUE_FLOWERING_JUNGLE_LEAVES.get(),
                SeafarerBlocks.MAGENTA_FLOWERING_JUNGLE_LEAVES.get()
        );
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SeafarerParticles.SMALL_VOLCANIC_SMOKE.get(), VolcanicSmokeParticle.SmokeFactory::new);
        event.registerSpriteSet(SeafarerParticles.MEDIUM_VOLCANIC_SMOKE.get(), VolcanicSmokeParticle.SmokeFactory::new);
        event.registerSpriteSet(SeafarerParticles.BIG_VOLCANIC_SMOKE.get(), VolcanicSmokeParticle.LargeSmokeFactory::new);
        event.registerSpriteSet(SeafarerParticles.GIANT_VOLCANIC_SMOKE.get(), VolcanicSmokeParticle.LargeSmokeFactory::new);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SeafarerEntities.MAGMAW.get(), MagmawRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SeafarerModelLayers.MAGMAW, MagmawModel::createBodyLayer);
    }
}

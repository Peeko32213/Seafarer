package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.entities.Magmaw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeafarerEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Seafarer.MOD_ID);

    public static final RegistryObject<EntityType<Magmaw>> MAGMAW = ENTITY_TYPES.register(
            "magmaw", () ->
            EntityType.Builder.of(Magmaw::new, MobCategory.WATER_CREATURE)
                    .sized(1.2F, 1.3F)
                    .clientTrackingRange(10)
                    .fireImmune()
                    .build(new ResourceLocation(Seafarer.MOD_ID, "magmaw").toString())
    );
}

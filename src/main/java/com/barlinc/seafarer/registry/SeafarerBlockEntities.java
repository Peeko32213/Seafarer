package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.blocks.blockentity.VolcanicCoreBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Seafarer.MOD_ID);

    public static final RegistryObject<BlockEntityType<VolcanicCoreBlockEntity>> VOLCANIC_CORE = BLOCK_ENTITIES.register("volcanic_core", () -> BlockEntityType.Builder.of(VolcanicCoreBlockEntity::new, SeafarerBlocks.VOLCANIC_CORE.get()).build(null));
}

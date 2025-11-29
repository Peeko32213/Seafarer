package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.worldgen.structure.VolcanoStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Seafarer.MOD_ID);

    public static final RegistryObject<StructureType<VolcanoStructure>> VOLCANO = STRUCTURE_TYPES.register("volcano", () -> () -> VolcanoStructure.CODEC);

}

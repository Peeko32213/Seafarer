package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class SeafarerDatapackProvider extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder();
//			.add(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, SeafarerBiomeSliceProvider::bootstrap);

	public SeafarerDatapackProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, provider, BUILDER, Set.of(Seafarer.MOD_ID));
	}
}
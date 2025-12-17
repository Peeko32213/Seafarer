package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerSurfaceRules;
import com.teamabnormals.blueprint.common.world.modification.chunk.ChunkGeneratorModifierProvider;
import com.teamabnormals.blueprint.common.world.modification.chunk.modifiers.SurfaceRuleModifier;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public final class SeafarerChunkGeneratorModifierProvider extends ChunkGeneratorModifierProvider {

	public SeafarerChunkGeneratorModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(Seafarer.MOD_ID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		this.entry("seafarer_surface_rule").selects("minecraft:overworld").addModifier(new SurfaceRuleModifier(SeafarerSurfaceRules.getVolcanicIslandRuleSource(), false));
	}
}
package com.barlinc.seafarer.registry.worldgen;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddSpawnsBiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.RemoveFeaturesBiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeafarerBiomeModifierProvider {

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
    }

    @SafeVarargs
    private static void removeFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "remove_feature/" + name, () -> new RemoveFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), featureSet(context, features), Set.of(step)));
    }

    @SafeVarargs
    private static void removeFeatureNoTag(BootstapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "remove_feature/" + name, () -> new RemoveFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), Set.of(step)));
    }

    @SafeVarargs
    private static void addFeature(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), featureSet(context, features), step));
    }

    @SafeVarargs
    private static void addFeatureNoTag(BootstapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), step));
    }

    private static void addSpawn(BootstapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, MobSpawnSettings.SpawnerData... spawns) {
        register(context, "add_spawn/" + name, () -> new AddSpawnsBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), List.of(spawns)));
    }

    private static void register(BootstapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Seafarer.MOD_ID, name)), modifier.get());
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(BootstapContext<?> context, ResourceKey<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(placedFeatureKey -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeatureKey)).collect(Collectors.toList()));
    }
}
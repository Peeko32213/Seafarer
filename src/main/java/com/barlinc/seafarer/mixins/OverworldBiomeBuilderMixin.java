package com.barlinc.seafarer.mixins;

import com.barlinc.seafarer.registry.worldgen.SeafarerBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public abstract class OverworldBiomeBuilderMixin {

    @Unique
    private final Climate.Parameter seafarer$mushroomIslandTemperature = Climate.Parameter.span(-1.0F, 0.24F);

    @Unique
    private final Climate.Parameter seafarer$volcanicIslandTemperature = Climate.Parameter.span(0.24F, 1.0F);

    @Shadow
    protected abstract void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter, Climate.Parameter parameter1, Climate.Parameter parameter2, Climate.Parameter parameter3, Climate.Parameter parameter4, float v, ResourceKey<Biome> biome);

    @Redirect(method = "addOffCoastBiomes", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/OverworldBiomeBuilder;addSurfaceBiome(Ljava/util/function/Consumer;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;Lnet/minecraft/world/level/biome/Climate$Parameter;FLnet/minecraft/resources/ResourceKey;)V"))
    private void seafarer$redirectAddOffCoastBiomes(OverworldBiomeBuilder self, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, float weirdness, ResourceKey<Biome> biomeKey) {
        if (biomeKey == Biomes.MUSHROOM_FIELDS) {
            this.addSurfaceBiome(consumer, this.seafarer$mushroomIslandTemperature, humidity, continentalness, erosion, depth, weirdness, Biomes.MUSHROOM_FIELDS);
            this.addSurfaceBiome(consumer, this.seafarer$volcanicIslandTemperature, humidity, continentalness, erosion, depth, weirdness, SeafarerBiomes.VOLCANIC_ISLAND);
        } else {
            this.addSurfaceBiome(consumer, temperature, humidity, continentalness, erosion, depth, weirdness, biomeKey);
        }
    }
}

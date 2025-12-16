package com.barlinc.seafarer.mixins;

import com.barlinc.seafarer.registry.SeafarerBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public abstract class OverworldBiomeBuilderMixin {

    @Shadow
    @Final
    private Climate.Parameter FULL_RANGE;

    @Shadow
    @Final
    private Climate.Parameter mushroomFieldsContinentalness;

    @Shadow
    protected abstract void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter, Climate.Parameter parameter1, Climate.Parameter parameter2, Climate.Parameter parameter3, Climate.Parameter parameter4, float v, ResourceKey<Biome> biomeKey);

    @Unique
    private final Climate.Parameter seafarer$volcanicIslandTemperature = Climate.Parameter.span(0.24F, 1.0F);

    @Inject(method = "addOffCoastBiomes", at = @At("HEAD"))
    private void seafarer$addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
        this.addSurfaceBiome(consumer, seafarer$volcanicIslandTemperature, FULL_RANGE, mushroomFieldsContinentalness, FULL_RANGE, FULL_RANGE, 0.0F, SeafarerBiomes.VOLCANIC_ISLAND);
    }
}
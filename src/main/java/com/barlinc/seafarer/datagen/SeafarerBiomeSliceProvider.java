package com.barlinc.seafarer.datagen;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.registry.SeafarerBiomes;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.world.modification.ModdedBiomeSlice;
import com.teamabnormals.blueprint.core.registry.BlueprintBiomes;
import com.teamabnormals.blueprint.core.registry.BlueprintDataPackRegistries;
import com.teamabnormals.blueprint.core.util.BiomeUtil;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SeafarerBiomeSliceProvider {

    public static final ResourceKey<ModdedBiomeSlice> VOLCANIC_ISLAND_SLICE = createKey("volcanic_island");

    public static final ResourceKey<Biome> VOLCANIC_ISLAND_AREA = SeafarerBiomes.createKey("volcanic_island_area");

    public static void bootstrap(BootstapContext<ModdedBiomeSlice> context) {
        List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> entries = new ArrayList<>();
        new SeafarerBiomeBuilder().addBiomes(entries::add);

        context.register(VOLCANIC_ISLAND_SLICE, new ModdedBiomeSlice(1000, BiomeUtil.MultiNoiseModdedBiomeProvider.builder().biomes(entries::forEach)
                .area(VOLCANIC_ISLAND_AREA, SeafarerBiomes.VOLCANIC_ISLAND)
                .build(), LevelStem.OVERWORLD));
    }

    public static ResourceKey<ModdedBiomeSlice> createKey(String name) {
        return ResourceKey.create(BlueprintDataPackRegistries.MODDED_BIOME_SLICES, Seafarer.modPrefix(name));
    }

    // Modified version of OverworldBiomeBuilder to simplify Seafarer's biome slice
    @SuppressWarnings("unchecked")
    private static final class SeafarerBiomeBuilder {

        private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
        private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
        private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
        private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
        private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
        private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
        private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
        private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
        private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
        private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
        private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
        private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
        private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
        private final ResourceKey<Biome> VANILLA = BlueprintBiomes.ORIGINAL_SOURCE_MARKER;

        private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};

        private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}};

        private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA},
                {VANILLA, VANILLA, VANILLA, VANILLA, VANILLA}};

        private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}};

        private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}};

        private void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addOffCoastBiomes(consumer);
            this.addInlandBiomes(consumer);
            this.addUndergroundBiomes(consumer);
        }

        // Add Volcanic Island
        private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addSurfaceBiome(consumer, Climate.Parameter.span(-1.0F, 0.2F), this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(0.2F, 1.0F), this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VOLCANIC_ISLAND_AREA);

            for (Climate.Parameter parameter : this.temperatures) {
                this.addSurfaceBiome(consumer, parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
                this.addSurfaceBiome(consumer, parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
            }
        }

        private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addMidSlice(consumer, Climate.Parameter.span(-1.0F, -0.93333334F));
            this.addHighSlice(consumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
            this.addPeaks(consumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
            this.addHighSlice(consumer, Climate.Parameter.span(-0.56666666F, -0.4F));
            this.addMidSlice(consumer, Climate.Parameter.span(-0.4F, -0.26666668F));
            this.addLowSlice(consumer, Climate.Parameter.span(-0.26666668F, -0.05F));
            this.addValleys(consumer, Climate.Parameter.span(-0.05F, 0.05F));
            this.addLowSlice(consumer, Climate.Parameter.span(0.05F, 0.26666668F));
            this.addMidSlice(consumer, Climate.Parameter.span(0.26666668F, 0.4F));
            this.addHighSlice(consumer, Climate.Parameter.span(0.4F, 0.56666666F));
            this.addPeaks(consumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
            this.addHighSlice(consumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
            this.addMidSlice(consumer, Climate.Parameter.span(0.93333334F, 1.0F));
        }

        private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
            for (int i = 0; i < this.temperatures.length; i++) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                for (int j = 0; j < this.humidities.length; j++) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey4);
                    ResourceKey<Biome> resourcekey6 = this.pickPeakBiome(i, j, parameter);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
                }
            }
        }

        private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
            for (int i = 0; i < this.temperatures.length; i++) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                for (int j = 0; j < this.humidities.length; j++) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                    ResourceKey<Biome> resourcekey3 = this.pickPlateauBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey4 = this.pickShatteredBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey);
                    ResourceKey<Biome> resourcekey6 = this.pickSlopeBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey7 = this.pickPeakBiome(i, j, parameter);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[0], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, resourcekey7);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[1], parameter, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
                }
            }
        }

        private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);

            for (int i = 0; i < this.temperatures.length; i++) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                for (int j = 0; j < this.humidities.length; j++) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                    ResourceKey<Biome> resourcekey3 = this.pickShatteredBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey4 = this.pickPlateauBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey5 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey6 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey);
                    ResourceKey<Biome> resourcekey7 = this.pickShatteredCoastBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey8 = this.pickSlopeBiome(i, j, parameter);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, resourcekey8);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], parameter, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[1], parameter, 0.0F, i == 0 ? resourcekey8 : resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[2], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.midInlandContinentalness, this.erosions[2], parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.farInlandContinentalness, this.erosions[2], parameter, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], parameter, 0.0F, resourcekey1);
                    if (parameter.max() < 0L) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[4], parameter, 0.0F, resourcekey5);
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    } else {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    }

                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], parameter, 0.0F, resourcekey7);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], parameter, 0.0F, resourcekey6);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey3);
                    if (parameter.max() < 0L) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], parameter, 0.0F, resourcekey5);
                    } else {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], parameter, 0.0F, resourcekey);
                    }

                    if (i == 0) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
                    }
                }
            }
        }

        private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
            this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);

            for (int i = 0; i < this.temperatures.length; i++) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                for (int j = 0; j < this.humidities.length; j++) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiome(i, j, parameter);
                    ResourceKey<Biome> resourcekey1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    ResourceKey<Biome> resourcekey2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                    ResourceKey<Biome> resourcekey3 = this.pickBeachBiome(i, j);
                    ResourceKey<Biome> resourcekey4 = this.maybePickWindsweptSavannaBiome(i, j, parameter, resourcekey);
                    ResourceKey<Biome> resourcekey5 = this.pickShatteredCoastBiome(i, j, parameter);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, resourcekey2);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, resourcekey1);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), parameter, 0.0F, resourcekey3);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[5], parameter, 0.0F, resourcekey5);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.nearInlandContinentalness, this.erosions[5], parameter, 0.0F, resourcekey4);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, resourcekey);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, this.coastContinentalness, this.erosions[6], parameter, 0.0F, resourcekey3);
                    if (i == 0) {
                        this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, resourcekey);
                    }
                }
            }
        }

        private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);
            this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, VANILLA);

            for (int i = 0; i < this.temperatures.length; i++) {
                Climate.Parameter climate$parameter = this.temperatures[i];
                for (int j = 0; j < this.humidities.length; j++) {
                    Climate.Parameter climate$parameter1 = this.humidities[j];
                    ResourceKey<Biome> resourcekey = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                    this.addSurfaceBiome(consumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, resourcekey);
                }
            }
        }

        private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
            this.addUndergroundBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
            this.addUndergroundBiome(consumer, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, VANILLA);
        }

        private ResourceKey<Biome> pickMiddleBiome(int i, int i1, Climate.Parameter parameter) {
            if (parameter.max() < 0L) {
                return this.MIDDLE_BIOMES[i][i1];
            } else {
                ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[i][i1];
                return resourcekey == null ? this.MIDDLE_BIOMES[i][i1] : resourcekey;
            }
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int i, int i1, Climate.Parameter parameter) {
            return i == 4 ? this.pickBadlandsBiome(i1, parameter) : this.pickMiddleBiome(i, i1, parameter);
        }

        private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int i, int i1, Climate.Parameter parameter) {
            return i == 0 ? this.pickSlopeBiome(i, i1, parameter) : this.pickMiddleBiomeOrBadlandsIfHot(i, i1, parameter);
        }

        private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int i, int i1, Climate.Parameter parameter, ResourceKey<Biome> key) {
            return i > 1 && i1 < 4 && parameter.max() >= 0L ? VANILLA : key;
        }

        private ResourceKey<Biome> pickShatteredCoastBiome(int i, int i1, Climate.Parameter parameter) {
            ResourceKey<Biome> resourcekey = parameter.max() >= 0L ? this.pickMiddleBiome(i, i1, parameter) : this.pickBeachBiome(i, i1);
            return this.maybePickWindsweptSavannaBiome(i, i1, parameter, resourcekey);
        }

        private ResourceKey<Biome> pickBeachBiome(int i, int i1) {
            return VANILLA;
        }

        private ResourceKey<Biome> pickBadlandsBiome(int i, Climate.Parameter parameter) {
            return VANILLA;
        }

        private ResourceKey<Biome> pickPlateauBiome(int i, int i1, Climate.Parameter parameter) {
            if (parameter.max() >= 0L) {
                ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[i][i1];
                if (resourcekey != null) {
                    return resourcekey;
                }
            }
            return this.PLATEAU_BIOMES[i][i1];
        }

        private ResourceKey<Biome> pickPeakBiome(int i, int i1, Climate.Parameter parameter) {
            if (i <= 2) {
                return VANILLA;
            } else {
                return i == 3 ? VANILLA : this.pickBadlandsBiome(i1, parameter);
            }
        }

        private ResourceKey<Biome> pickSlopeBiome(int i, int i1, Climate.Parameter parameter) {
            if (i >= 3) {
                return this.pickPlateauBiome(i, i1, parameter);
            } else {
                return VANILLA;
            }
        }

        private ResourceKey<Biome> pickShatteredBiome(int i, int i1, Climate.Parameter parameter) {
            ResourceKey<Biome> resourcekey = this.SHATTERED_BIOMES[i][i1];
            return resourcekey == null ? this.pickMiddleBiome(i, i1, parameter) : resourcekey;
        }

        private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter, Climate.Parameter parameter1, Climate.Parameter parameter2, Climate.Parameter parameter3, Climate.Parameter parameter4, float v, ResourceKey<Biome> key) {
            consumer.accept(Pair.of(Climate.parameters(parameter, parameter1, parameter2, parameter3, Climate.Parameter.point(0.0F), parameter4, v), key));
            consumer.accept(Pair.of(Climate.parameters(parameter, parameter1, parameter2, parameter3, Climate.Parameter.point(1.0F), parameter4, v), key));
        }

        private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter, Climate.Parameter parameter1, Climate.Parameter parameter2, Climate.Parameter parameter3, Climate.Parameter parameter4, float v, ResourceKey<Biome> key) {
            consumer.accept(Pair.of(Climate.parameters(parameter, parameter1, parameter2, parameter3, Climate.Parameter.span(0.2F, 0.9F), parameter4, v), key));
        }
    }
}

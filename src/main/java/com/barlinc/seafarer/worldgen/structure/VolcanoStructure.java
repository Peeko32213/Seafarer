package com.barlinc.seafarer.worldgen.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.barlinc.seafarer.registry.SeafarerStructureTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class VolcanoStructure extends Structure {

    public static final Codec<VolcanoStructure> CODEC = RecordCodecBuilder.create(volcano -> volcano.group(
            settingsCodec(volcano),
            HeightProvider.CODEC.fieldOf("start_height").forGetter(volcanoStructure -> volcanoStructure.start_height),
            IntProvider.CODEC.fieldOf("radius").forGetter(volcanoStructure -> volcanoStructure.radius)
    ).apply(volcano, VolcanoStructure::new));

    private final HeightProvider start_height;
    private final IntProvider radius;

    public VolcanoStructure(StructureSettings settings, HeightProvider startHeight, IntProvider radius) {
        super(settings);
        this.start_height = startHeight;
        this.radius = radius;
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        WorldgenRandom random = context.random();
        int startHeight = this.start_height.sample(random, new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
        int radiusX = this.radius.sample(random);
        int radiusZ = this.radius.sample(random);
        boolean wide = random.nextFloat() <= 0.45F;
        boolean overgrown = random.nextFloat() <= 0.1F;
        long noiseSeed = random.nextLong();

        BlockPos pos = new BlockPos(chunkPos.getMinBlockX() + 8, startHeight, chunkPos.getMinBlockZ() + 8);
        return Optional.of(new GenerationStub(pos, builder -> builder.addPiece(new VolcanoStructurePiece(context.heightAccessor(), pos, radiusX, radiusZ, noiseSeed, wide, overgrown))));
    }

    @Override
    public StructureType<?> type() {
        return SeafarerStructureTypes.VOLCANO.get();
    }
}
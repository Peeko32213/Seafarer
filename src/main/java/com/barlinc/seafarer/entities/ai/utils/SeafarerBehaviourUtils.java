package com.barlinc.seafarer.entities.ai.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class SeafarerBehaviourUtils {

    @Nullable
    public static Vec3 getRandomSwimmableLavaPos(PathfinderMob pathfinderMob, int j, int k) {
        Vec3 vec3 = DefaultRandomPos.getPos(pathfinderMob, j, k);

        for(int i = 0; vec3 != null && !pathfinderMob.level().getFluidState(BlockPos.containing(vec3)).is(FluidTags.LAVA) && i++ < 10; vec3 = DefaultRandomPos.getPos(pathfinderMob, j, k)) {
        }

        return vec3;
    }

    @Nullable
    public static Vec3 getRandomSwimmableLavaOrWaterPos(PathfinderMob pathfinderMob, int j, int k) {
        Vec3 vec3 = DefaultRandomPos.getPos(pathfinderMob, j, k);

        for(int i = 0; vec3 != null && (!pathfinderMob.level().getFluidState(BlockPos.containing(vec3)).is(FluidTags.LAVA) || !pathfinderMob.level().getFluidState(BlockPos.containing(vec3)).is(FluidTags.WATER)) && i++ < 10; vec3 = DefaultRandomPos.getPos(pathfinderMob, j, k)) {
        }

        return vec3;
    }
}

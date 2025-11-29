package com.barlinc.seafarer.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class SeafarerBlockPos {
    public static BlockPos fromCoords(double x, double y, double z){
        return new BlockPos((int) x, (int) y, (int) z);
    }

    public static BlockPos fromVec3(Vec3 vec3){
        return fromCoords(vec3.x, vec3.y, vec3.z);
    }
}

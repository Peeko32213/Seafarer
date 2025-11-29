package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SeafarerModelLayers {

    public static final ModelLayerLocation HORSESHOE_CRAB = main("horseshoe_crab");
    public static final ModelLayerLocation MAGMAW = main("magmaw");
    public static final ModelLayerLocation MANTA_RAY = main("manta_ray");
    public static final ModelLayerLocation SHORE_CRAB = main("shore_crab");
    public static final ModelLayerLocation SNAKE_MACKEREL = main("snake_mackerel");
    public static final ModelLayerLocation SUNFISH = main("sunfish");

    private static ModelLayerLocation register(String id, String name) {
        return new ModelLayerLocation(new ResourceLocation(Seafarer.MOD_ID, id), name);
    }

    private static ModelLayerLocation main(String id) {
        return register(id, "main");
    }
}

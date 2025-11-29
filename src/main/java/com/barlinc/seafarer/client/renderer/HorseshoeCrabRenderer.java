package com.barlinc.seafarer.client.renderer;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.HorseshoeCrabModel;
import com.barlinc.seafarer.entities.HorseshoeCrab;
import com.barlinc.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class HorseshoeCrabRenderer extends MobRenderer<HorseshoeCrab, HorseshoeCrabModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/horseshoe_crab.png");

    public HorseshoeCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new HorseshoeCrabModel(context.bakeLayer(SeafarerModelLayers.HORSESHOE_CRAB)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(HorseshoeCrab entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(HorseshoeCrab entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}
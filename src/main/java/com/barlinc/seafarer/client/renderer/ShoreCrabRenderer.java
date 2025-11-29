package com.barlinc.seafarer.client.renderer;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.ShoreCrabModel;
import com.barlinc.seafarer.entities.ShoreCrab;
import com.barlinc.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ShoreCrabRenderer extends MobRenderer<ShoreCrab, ShoreCrabModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/shore_crab.png");

    public ShoreCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new ShoreCrabModel(context.bakeLayer(SeafarerModelLayers.SHORE_CRAB)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(ShoreCrab entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(ShoreCrab entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }

}
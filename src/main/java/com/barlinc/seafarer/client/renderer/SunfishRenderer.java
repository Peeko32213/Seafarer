package com.barlinc.seafarer.client.renderer;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.SunfishModel;
import com.barlinc.seafarer.entities.Sunfish;
import com.barlinc.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class SunfishRenderer extends MobRenderer<Sunfish, SunfishModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/sunfish.png");

    public SunfishRenderer(EntityRendererProvider.Context context) {
        super(context, new SunfishModel(context.bakeLayer(SeafarerModelLayers.SUNFISH)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(Sunfish entity) {
        return TEXTURE;
    }

    @Override
    protected @Nullable RenderType getRenderType(Sunfish entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(TEXTURE);
    }
}
package com.barlinc.seafarer.client.renderer;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.MagmawModel;
import com.barlinc.seafarer.client.renderer.layer.MagmawGlowLayer;
import com.barlinc.seafarer.entities.Magmaw;
import com.barlinc.seafarer.registry.SeafarerModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class MagmawRenderer extends MobRenderer<Magmaw, MagmawModel> {

    private static final ResourceLocation MAGMAW = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/magmaw/magmaw.png");
    private static final ResourceLocation MAGMAW_GLOW = new ResourceLocation(Seafarer.MOD_ID, "textures/entity/magmaw/magmaw_glow.png");

    public MagmawRenderer(EntityRendererProvider.Context context) {
        super(context, new MagmawModel(context.bakeLayer(SeafarerModelLayers.MAGMAW)), 0.7F);
        this.addLayer(new MagmawGlowLayer(this, MAGMAW_GLOW, (entity, p_234802_, p_234803_) -> Math.max(0.5F, Mth.cos(p_234803_ * 0.04F + (float) Math.PI * 0.25F)), MagmawModel::getPulsatingLayerModelParts));

    }

    @Override
    public ResourceLocation getTextureLocation(Magmaw entity) {
        return MAGMAW;
    }

    @Override
    protected @Nullable RenderType getRenderType(Magmaw entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutoutNoCull(MAGMAW);
    }
}
package com.barlinc.seafarer.client.renderer.layer;

import com.barlinc.seafarer.Seafarer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.barlinc.seafarer.client.models.MagmawModel;
import com.barlinc.seafarer.entities.Magmaw;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class MagmawGlowLayer extends RenderLayer<Magmaw, MagmawModel> {

    private static final RenderType GLOW_TEXTURE = RenderType.eyes(Seafarer.modPrefix("textures/entity/magmaw/magmaw_glow.png"));

    public MagmawGlowLayer(RenderLayerParent<Magmaw, MagmawModel> parentModel) {
        super(parentModel);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, MultiBufferSource multiBufferSource, int i, @NotNull Magmaw entity, float f, float g, float h, float j, float k, float l) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(GLOW_TEXTURE);
        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 0xFFFFFF, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}



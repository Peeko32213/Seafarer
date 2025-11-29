package com.barlinc.seafarer.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.client.models.SnakeMackerelModel;
import com.barlinc.seafarer.entities.SnakeMackerel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SnakeMackerelEyeLayer extends RenderLayer<SnakeMackerel, SnakeMackerelModel> {

    private static final RenderType GLOW_TEXTURE = RenderType.entityTranslucentEmissive(new ResourceLocation(Seafarer.MOD_ID, "textures/entity/snake_mackerel/snake_mackerel_eyes.png"));

    public SnakeMackerelEyeLayer(RenderLayerParent<SnakeMackerel, SnakeMackerelModel> parentModel) {
        super(parentModel);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, SnakeMackerel entity, float f, float g, float h, float j, float k, float l) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(GLOW_TEXTURE);
        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 0xFFFFFF, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}



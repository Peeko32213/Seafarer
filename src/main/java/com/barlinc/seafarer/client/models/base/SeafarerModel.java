package com.barlinc.seafarer.client.models.base;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Function;

public abstract class SeafarerModel<E extends Entity> extends HierarchicalModel<E> {

    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

    public SeafarerModel() {
        this(RenderType::entityCutoutNoCull);
    }

    public SeafarerModel(Function<ResourceLocation, RenderType> renderType) {
        super(renderType);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    protected void animateIdle(AnimationState animationState, AnimationDefinition definition, float ageInTicks, float speed, float limbSwingAmount) {
        float scale = Math.max(0, Math.min(1 - Math.abs(limbSwingAmount), 1));
        animationState.updateTime(ageInTicks, speed);
        animationState.ifStarted((state) -> KeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), scale, SeafarerModel.ANIMATION_VECTOR_CACHE));
    }

    @Override
    protected void animate(@NotNull AnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks) {
        this.animate(animationState, definition, ageInTicks, 1.0F);
    }

    @Override
    protected void animateWalk(@NotNull AnimationDefinition definition, float limbSwing, float limbSwingAmount, float maxAnimationSpeed, float animationScaleFactor) {
        if (limbSwing != 0 && limbSwingAmount != 0) {
            long i = (long) (limbSwing * 50.0F * maxAnimationSpeed);
            float f = Math.min(limbSwingAmount * animationScaleFactor, 1.0F);
            KeyframeAnimations.animate(this, definition, i, f, SeafarerModel.ANIMATION_VECTOR_CACHE);
        }
    }

    @Override
    protected void animate(AnimationState animationState, @NotNull AnimationDefinition definition, float ageInTicks, float speed) {
        animationState.updateTime(ageInTicks, speed);
        animationState.ifStarted((state) -> KeyframeAnimations.animate(this, definition, state.getAccumulatedTime(), 1.0F, SeafarerModel.ANIMATION_VECTOR_CACHE));
    }

    @Override
    protected void applyStatic(@NotNull AnimationDefinition definition) {
        KeyframeAnimations.animate(this, definition, 0L, 1.0F, SeafarerModel.ANIMATION_VECTOR_CACHE);
    }
}
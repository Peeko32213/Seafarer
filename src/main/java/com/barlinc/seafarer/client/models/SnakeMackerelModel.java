package com.barlinc.seafarer.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.barlinc.seafarer.client.animations.SnakeMackerelAnimations;
import com.barlinc.seafarer.entities.SnakeMackerel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class SnakeMackerelModel extends HierarchicalModel<SnakeMackerel> {

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart left_fin;
	private final ModelPart right_fin;
	private final ModelPart back_body;
	private final ModelPart tail;

	public SnakeMackerelModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.left_fin = this.body.getChild("left_fin");
		this.right_fin = this.body.getChild("right_fin");
		this.back_body = this.body.getChild("back_body");
		this.tail = this.back_body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.5F, -1.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.5F, -3.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(16, 9).addBox(0.0F, 0.5F, -3.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -1.5F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(-1.0F, -0.5F, -8.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(10, 19).addBox(0.025F, -0.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.75F, -2.0F, 0.3927F, 0.6545F, 0.0F));

		PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(10, 19).mirror().addBox(-0.025F, -0.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 0.75F, -2.0F, 0.3927F, -0.6545F, 0.0F));

		PartDefinition back_body = body.addOrReplaceChild("back_body", CubeListBuilder.create().texOffs(18, 6).addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

		PartDefinition tail = back_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 18).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(SnakeMackerel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(entity.swimmingAnimationState, SnakeMackerelAnimations.SWIM, ageInTicks, 0.5F + limbSwingAmount * 1.5F);

		float prevOnLandProgress = entity.prevOnLandProgress;
		float onLandProgress = entity.onLandProgress;
		float partialTicks = ageInTicks - entity.tickCount;
		float landProgress = prevOnLandProgress + (onLandProgress - prevOnLandProgress) * partialTicks;

		this.root.xRot = headPitch * (Mth.DEG_TO_RAD);
		this.root.zRot += landProgress * ((float) Math.toRadians(-90) / 5.0F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}
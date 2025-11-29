package com.barlinc.seafarer.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.barlinc.seafarer.client.animations.SunfishAnimations;
import com.barlinc.seafarer.entities.Sunfish;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class SunfishModel extends HierarchicalModel<Sunfish> {

	private final ModelPart root;
	private final ModelPart body_main;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart left_fin;
	private final ModelPart right_fin;
	private final ModelPart top_fin;
	private final ModelPart bottom_fin;

	public SunfishModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body_main = this.root.getChild("body_main");
		this.body = this.body_main.getChild("body");
		this.tail = this.body.getChild("tail");
		this.left_fin = this.body.getChild("left_fin");
		this.right_fin = this.body.getChild("right_fin");
		this.top_fin = this.body.getChild("top_fin");
		this.bottom_fin = this.body.getChild("bottom_fin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, -2.0F));

		PartDefinition body_main = root.addOrReplaceChild("body_main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition body = body_main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(51, 22).addBox(-4.5F, -17.0F, -18.0F, 9.0F, 9.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(0, 55).addBox(-4.5F, -8.0F, -16.0F, 9.0F, 2.0F, 31.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.5F, -6.0F, -18.0F, 9.0F, 22.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 47).addBox(0.0F, -16.0F, 0.0F, 0.0F, 31.0F, 8.0F, new CubeDeformation(0.0025F)), PartPose.offset(0.0F, 0.0F, 15.0F));

		PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(4.5F, -5.0F, -4.0F));

		PartDefinition cube_r1 = left_fin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 48).addBox(0.0F, -1.0F, -1.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.7418F, 0.0F));

		PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-4.5F, -5.0F, -4.0F));

		PartDefinition cube_r2 = right_fin.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 48).mirror().addBox(0.0F, -1.0F, -1.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, -0.7418F, 0.0F));

		PartDefinition top_fin = body.addOrReplaceChild("top_fin", CubeListBuilder.create().texOffs(51, 0).addBox(-1.0F, -20.0F, -6.0F, 2.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 9.0F));

		PartDefinition bottom_fin = body.addOrReplaceChild("bottom_fin", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 9.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Sunfish entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (entity.isInWaterOrBubble()) {
			this.animate(entity.swimmingAnimationState, SunfishAnimations.SWIM, ageInTicks, (1 + (limbSwingAmount * 2.0F)));
		} else {
			this.animate(entity.flopAnimationState, SunfishAnimations.FLOP, ageInTicks);
		}

		float prevOnLandProgress = entity.prevOnLandProgress;
		float onLandProgress = entity.onLandProgress;
		float partialTicks = ageInTicks - entity.tickCount;
		float landProgress = prevOnLandProgress + (onLandProgress - prevOnLandProgress) * partialTicks;

		this.root.xRot = headPitch * (Mth.DEG_TO_RAD) / 4;
		this.body.zRot += landProgress * ((float) Math.toRadians(-90) / 10F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}
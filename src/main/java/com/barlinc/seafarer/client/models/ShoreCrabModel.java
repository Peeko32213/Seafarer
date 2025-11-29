package com.barlinc.seafarer.client.models;

import com.barlinc.seafarer.client.animations.ShoreCrabAnimations;
import com.barlinc.seafarer.entities.ShoreCrab;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ShoreCrabModel extends HierarchicalModel<ShoreCrab> {

	private final ModelPart root;
	private final ModelPart body_main;
	private final ModelPart body;
	private final ModelPart left_eye;
	private final ModelPart right_eye;
	private final ModelPart left_claw;
	private final ModelPart right_claw;
	private final ModelPart left_leg1;
	private final ModelPart left_leg2;
	private final ModelPart left_leg3;
	private final ModelPart left_leg4;
	private final ModelPart right_leg1;
	private final ModelPart right_leg2;
	private final ModelPart right_leg3;
	private final ModelPart right_leg4;

	public ShoreCrabModel(ModelPart root) {
		this.root = root.getChild("root");
		this.body_main = this.root.getChild("body_main");
		this.body = this.body_main.getChild("body");
		this.left_eye = this.body.getChild("left_eye");
		this.right_eye = this.body.getChild("right_eye");
		this.left_claw = this.body.getChild("left_claw");
		this.right_claw = this.body.getChild("right_claw");
		this.left_leg1 = this.body_main.getChild("left_leg1");
		this.left_leg2 = this.body_main.getChild("left_leg2");
		this.left_leg3 = this.body_main.getChild("left_leg3");
		this.left_leg4 = this.body_main.getChild("left_leg4");
		this.right_leg1 = this.body_main.getChild("right_leg1");
		this.right_leg2 = this.body_main.getChild("right_leg2");
		this.right_leg3 = this.body_main.getChild("right_leg3");
		this.right_leg4 = this.body_main.getChild("right_leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body_main = root.addOrReplaceChild("body_main", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition body = body_main.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_eye = body.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, -1.475F, -3.475F));

		PartDefinition right_eye = body.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -1.475F, -3.475F));

		PartDefinition left_claw = body.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(9, 15).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0025F))
				.texOffs(17, 17).addBox(-1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 17).addBox(1.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.0F, -4.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition right_claw = body.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(9, 15).mirror().addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 16).mirror().addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false)
				.texOffs(17, 17).mirror().addBox(0.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(17, 17).mirror().addBox(-2.0F, 1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 2.0F, -4.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition left_leg1 = body_main.addOrReplaceChild("left_leg1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0025F)), PartPose.offsetAndRotation(3.0F, 2.0F, -2.0F, 0.3491F, 0.3491F, 0.0F));

		PartDefinition left_leg2 = body_main.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0025F)), PartPose.offsetAndRotation(3.0F, 2.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_leg3 = body_main.addOrReplaceChild("left_leg3", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0025F)), PartPose.offsetAndRotation(3.5F, 2.0F, 0.35F, 0.3491F, -0.3491F, 0.0F));

		PartDefinition left_leg4 = body_main.addOrReplaceChild("left_leg4", CubeListBuilder.create().texOffs(10, 10).addBox(-0.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0025F)), PartPose.offsetAndRotation(3.5F, 2.0F, 2.0F, 0.3491F, -0.6109F, 0.0F));

		PartDefinition right_leg1 = body_main.addOrReplaceChild("right_leg1", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 2.0F, -2.0F, 0.3491F, -0.3491F, 0.0F));

		PartDefinition right_leg2 = body_main.addOrReplaceChild("right_leg2", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-5.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 2.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition right_leg3 = body_main.addOrReplaceChild("right_leg3", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 2.0F, 0.35F, 0.3491F, 0.3491F, 0.0F));

		PartDefinition right_leg4 = body_main.addOrReplaceChild("right_leg4", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(-3.5F, -2.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 2.0F, 2.0F, 0.3491F, 0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(ShoreCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ShoreCrabAnimations.WALK, limbSwing, limbSwingAmount, 4, 8);
		this.animate(entity.idleAnimationState, ShoreCrabAnimations.IDLE, ageInTicks);

		this.body.xRot = headPitch * (Mth.DEG_TO_RAD) / 4;
		this.body.zRot = netHeadYaw * (Mth.DEG_TO_RAD) / 4;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}
package com.barlinc.seafarer.client.models;

import com.barlinc.seafarer.client.animations.MantaRayAnimations;
import com.barlinc.seafarer.entities.MantaRay;
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
public class MantaRayModel<T extends MantaRay> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart swim_control;
	private final ModelPart body;
	private final ModelPart left_wing;
	private final ModelPart left_wingtip;
	private final ModelPart right_wing;
	private final ModelPart right_wingtip;
	private final ModelPart left_thingy;
	private final ModelPart right_thingy;
	private final ModelPart Tail;

	public MantaRayModel(ModelPart root) {
		this.root = root.getChild("root");
		this.swim_control = this.root.getChild("swim_control");
		this.body = this.swim_control.getChild("body");
		this.left_wing = this.body.getChild("left_wing");
		this.left_wingtip = this.left_wing.getChild("left_wingtip");
		this.right_wing = this.body.getChild("right_wing");
		this.right_wingtip = this.right_wing.getChild("right_wingtip");
		this.left_thingy = this.body.getChild("left_thingy");
		this.right_thingy = this.body.getChild("right_thingy");
		this.Tail = this.body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition swim_control = root.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition body = swim_control.addOrReplaceChild("body", CubeListBuilder.create().texOffs(173, 0).addBox(-0.5F, -12.0F, 14.0F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-17.0F, -9.0F, -17.0F, 34.0F, 16.0F, 34.0F, new CubeDeformation(0.0F))
				.texOffs(13, 140).addBox(-15.0F, -8.0F, -16.5F, 30.0F, 14.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 50).mirror().addBox(0.0F, -2.5F, -16.0F, 28.0F, 5.0F, 29.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(14.925F, -3.5F, 3.15F));

		PartDefinition left_wingtip = left_wing.addOrReplaceChild("left_wingtip", CubeListBuilder.create().texOffs(0, 84).mirror().addBox(0.0F, -2.0F, -8.0F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(28.0F, -0.5F, -8.0F));

		PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 50).addBox(-28.0F, -2.5F, -16.0F, 28.0F, 5.0F, 29.0F, new CubeDeformation(0.01F)), PartPose.offset(-14.925F, -3.5F, 3.15F));

		PartDefinition right_wingtip = right_wing.addOrReplaceChild("right_wingtip", CubeListBuilder.create().texOffs(0, 84).addBox(-17.0F, -2.0F, -8.0F, 17.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-28.0F, -0.5F, -8.0F));

		PartDefinition left_thingy = body.addOrReplaceChild("left_thingy", CubeListBuilder.create().texOffs(0, 104).mirror().addBox(-12.0F, -2.0F, -8.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0025F)).mirror(false)
				.texOffs(24, 104).mirror().addBox(0.0F, -2.0F, -8.0F, 0.0F, 9.0F, 8.0F, new CubeDeformation(0.0025F)).mirror(false), PartPose.offset(14.0F, 4.0F, -17.0F));

		PartDefinition right_thingy = body.addOrReplaceChild("right_thingy", CubeListBuilder.create().texOffs(0, 104).addBox(0.0F, -2.0F, -8.0F, 12.0F, 11.0F, 0.0F, new CubeDeformation(0.0025F))
				.texOffs(24, 104).addBox(0.0F, -2.0F, -8.0F, 0.0F, 9.0F, 8.0F, new CubeDeformation(0.0025F)), PartPose.offset(-14.0F, 4.0F, -17.0F));

		PartDefinition Tail = body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(173, 210).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 17.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(MantaRay entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (entity.isInWaterOrBubble()) {
			this.animate(entity.swimmingAnimationState, MantaRayAnimations.SWIM, ageInTicks, (1 + limbSwingAmount));
			this.animate(entity.roll1AnimationState, MantaRayAnimations.ROLL1, ageInTicks);
			this.animate(entity.roll2AnimationState, MantaRayAnimations.ROLL2, ageInTicks);
			this.animate(entity.loopingAnimationState, MantaRayAnimations.LOOP, ageInTicks);
		} else {
			this.animate(entity.flopAnimationState, MantaRayAnimations.FLOP, ageInTicks);
		}

		float prevOnLandProgress = entity.prevOnLandProgress;
		float onLandProgress = entity.onLandProgress;
		float partialTicks = ageInTicks - entity.tickCount;
		float landProgress = prevOnLandProgress + (onLandProgress - prevOnLandProgress) * partialTicks;

		this.root.xRot = headPitch * (Mth.DEG_TO_RAD) / 2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return this.root;
	}
}
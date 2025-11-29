package com.barlinc.seafarer.client.models;

import com.barlinc.seafarer.client.animations.HorseshoeCrabAnimations;
import com.barlinc.seafarer.entities.HorseshoeCrab;
import net.minecraft.client.model.HierarchicalModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class HorseshoeCrabModel extends HierarchicalModel<HorseshoeCrab> {

	private final ModelPart root;
	private final ModelPart tail;

	public HorseshoeCrabModel(ModelPart root) {
		this.root = root.getChild("root");
		this.tail = this.root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 18).addBox(-6.0F, -1.0F, -1.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -1.0F, -8.0F, 12.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 10).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(19, 10).addBox(-5.0F, 1.0F, 3.0F, 10.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull HorseshoeCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(HorseshoeCrabAnimations.WALK, limbSwing, limbSwingAmount, 4, 8);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public @NotNull ModelPart root() {
		return this.root;
	}
}
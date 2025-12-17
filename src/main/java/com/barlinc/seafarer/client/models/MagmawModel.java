package com.barlinc.seafarer.client.models;

import com.barlinc.seafarer.client.animations.MagmawAnimations;
import com.barlinc.seafarer.client.models.base.SeafarerModel;
import com.barlinc.seafarer.entities.Magmaw;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class MagmawModel extends SeafarerModel<Magmaw> {

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart dorsal_fin;
    private final ModelPart left_fin;
    private final ModelPart back_left_fin;
    private final ModelPart tail;
    private final ModelPart tail_fin;
    private final ModelPart top_tail_fin;
    private final ModelPart bottom_tail_fin;
    private final ModelPart right_fin;
    private final ModelPart back_right_fin;

	public MagmawModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("head");
        this.jaw = this.root.getChild("jaw");
        this.dorsal_fin = this.root.getChild("dorsal_fin");
        this.left_fin = this.root.getChild("left_fin");
        this.back_left_fin = this.root.getChild("back_left_fin");
        this.tail = this.root.getChild("tail");
        this.tail_fin = this.tail.getChild("tail_fin");
        this.top_tail_fin = this.tail_fin.getChild("top_tail_fin");
        this.bottom_tail_fin = this.tail_fin.getChild("bottom_tail_fin");
        this.right_fin = this.root.getChild("right_fin");
        this.back_right_fin = this.root.getChild("back_right_fin");
	}

	public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, -11.0F, -8.0F, 17.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 0).addBox(-6.5F, 0.0F, -16.0F, 13.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 39).addBox(-6.5F, -7.0F, -16.0F, 13.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -8.0F));

        PartDefinition jaw = root.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 64).addBox(-6.5F, 0.0F, -16.0F, 13.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(66, 19).addBox(-6.5F, -4.0F, -16.0F, 13.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, -8.0F));

        PartDefinition dorsal_fin = root.addOrReplaceChild("dorsal_fin", CubeListBuilder.create().texOffs(28, 99).addBox(-1.0F, 2.0F, 5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(58, 66).addBox(-1.0F, -22.0F, -3.0F, 2.0F, 26.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(46, 95).addBox(-1.0F, -22.0F, 5.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 6.0F));

        PartDefinition left_fin = root.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(78, 66).addBox(0.0F, -1.0F, -3.0F, 15.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(16, 100).addBox(0.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, 11.0F, -4.0F));

        PartDefinition back_left_fin = root.addOrReplaceChild("back_left_fin", CubeListBuilder.create().texOffs(28, 95).addBox(0.0F, 0.0F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(56, 100).addBox(0.0F, 0.0F, 1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, 11.0F, 6.5F));

        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(62, 39).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(28, 83).addBox(0.0F, -7.5F, 9.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0025F))
                .texOffs(78, 91).addBox(0.0F, 3.5F, 6.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0025F)), PartPose.offset(0.0F, 2.5F, 8.0F));

        PartDefinition tail_fin = tail.addOrReplaceChild("tail_fin", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 18.0F));

        PartDefinition top_tail_fin = tail_fin.addOrReplaceChild("top_tail_fin", CubeListBuilder.create().texOffs(44, 83).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(78, 74).addBox(-1.0F, -8.0F, 4.0F, 2.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 100).addBox(-1.0F, -3.0F, 14.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bottom_tail_fin = tail_fin.addOrReplaceChild("bottom_tail_fin", CubeListBuilder.create().texOffs(94, 91).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 83).addBox(-1.0F, 3.0F, 4.0F, 2.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(8, 100).addBox(-1.0F, 0.0F, 14.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_fin = root.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(78, 66).mirror().addBox(-15.0F, -1.0F, -3.0F, 15.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(16, 100).mirror().addBox(-2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.5F, 11.0F, -4.0F));

        PartDefinition back_right_fin = root.addOrReplaceChild("back_right_fin", CubeListBuilder.create().texOffs(28, 95).mirror().addBox(-6.0F, 0.0F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(56, 100).mirror().addBox(-2.0F, 0.0F, 1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.5F, 11.0F, 6.5F));

        return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Magmaw entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
        if (entity.isInLava() || entity.isInWaterOrBubble()) {
            this.animateWalk(MagmawAnimations.SWIM, limbSwing, limbSwingAmount, 1.5F, 3);
        }
		this.animateIdle(entity.swimIdleAnimationState, MagmawAnimations.IDLE, ageInTicks, 1, limbSwingAmount * 3);
		this.animate(entity.flopAnimationState, MagmawAnimations.FLOP, ageInTicks);
		this.root.xRot = headPitch * (Mth.DEG_TO_RAD);
	}

	public @NotNull ModelPart root() {
		return this.root;
	}
}
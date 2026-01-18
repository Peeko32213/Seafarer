package com.barlinc.seafarer.client.models;

import com.barlinc.seafarer.client.animations.ClutchAnimations;
import com.barlinc.seafarer.client.models.base.SeafarerModel;
import com.barlinc.seafarer.entities.Clutch;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("FieldCanBeLocal, unused")
public class ClutchModel extends SeafarerModel<Clutch> {

    private final ModelPart root;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart mouth;
    private final ModelPart upper_jaw;
    private final ModelPart lower_jaw;
    private final ModelPart dorsal_fin;
    private final ModelPart pelvic_fin;
    private final ModelPart tail;
    private final ModelPart tail_fin;

	public ClutchModel(ModelPart root) {
        this.root = root.getChild("root");
        this.swim_control = this.root.getChild("swim_control");
        this.body = this.swim_control.getChild("body");
        this.mouth = this.body.getChild("mouth");
        this.upper_jaw = this.mouth.getChild("upper_jaw");
        this.lower_jaw = this.mouth.getChild("lower_jaw");
        this.dorsal_fin = this.body.getChild("dorsal_fin");
        this.pelvic_fin = this.body.getChild("pelvic_fin");
        this.tail = this.body.getChild("tail");
        this.tail_fin = this.tail.getChild("tail_fin");
	}

	public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 3.6667F, 1.2222F));

        PartDefinition swim_control = root.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, -1.1667F, -0.2222F));

        PartDefinition body = swim_control.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 0).addBox(-2.5F, -6.5F, -2.0F, 5.0F, 13.0F, 4.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition upper_jaw = mouth.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -2.0F, -9.0F, 5.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-2.5F, 2.0F, -9.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 0.0F));

        PartDefinition lower_jaw = mouth.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -9.0F, 5.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(29, 32).addBox(-2.5F, -4.0F, -9.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 0.0F));

        PartDefinition dorsal_fin = body.addOrReplaceChild("dorsal_fin", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, -8.0F, -3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, -1.0F));

        PartDefinition pelvic_fin = body.addOrReplaceChild("pelvic_fin", CubeListBuilder.create().texOffs(13, 44).addBox(0.0F, -1.0F, -3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, -1.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(33, 18).addBox(-1.0F, -1.5F, -0.9167F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(26, 44).addBox(0.0F, -5.5F, -0.9167F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.9167F));

        PartDefinition tail_fin = tail.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(35, 44).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0833F));

        return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Clutch entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
        if (entity.isInWater()) {
            this.animateWalk(ClutchAnimations.SWIM, limbSwing, limbSwingAmount, 1.5F, 3);
        }
		this.animateIdle(entity.swimIdleAnimationState, ClutchAnimations.IDLE, ageInTicks, 1, limbSwingAmount * 4);
		this.animate(entity.flopAnimationState, ClutchAnimations.FLOP, ageInTicks);
		this.swim_control.xRot = headPitch * ((float) Math.PI / 180F);
        this.root.y = 17;
	}

    @Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}
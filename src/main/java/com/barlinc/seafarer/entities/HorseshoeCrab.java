package com.barlinc.seafarer.entities;

import com.barlinc.seafarer.entities.ai.goal.LeaveWaterGoal;
import com.barlinc.seafarer.entities.ai.goal.SeafloorWanderGoal;
import com.barlinc.seafarer.registry.SeafarerItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HorseshoeCrab extends Animal implements Bucketable {

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(HorseshoeCrab.class, EntityDataSerializers.BOOLEAN);

    public HorseshoeCrab(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 0.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.12F)
                .add(Attributes.ARMOR, 3.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 5, 1.25D, 1, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(2, new LeaveWaterGoal(this, 500));
        this.goalSelector.addGoal(3, new SeafloorWanderGoal(this, 1, 10, 20));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Override
    public void travel(Vec3 travelVec) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            if (this.jumping) {
                this.setDeltaMovement(this.getDeltaMovement().scale(1.0D));
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.42D, 0.0D));
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.4D));
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.025D, 0.0D));
            }
        } else {
            super.travel(travelVec);
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public @NotNull MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return null;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag compoundnbt = bucket.getOrCreateTag();
        Bucketable.saveDefaultDataToBucketTag(this, bucket);
        compoundnbt.putFloat("Health", this.getHealth());
        if (this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
    }

    @Override
    public void loadFromBucketTag(CompoundTag compoundTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, compoundTag);
    }

    @Override
    public ItemStack getBucketItemStack() {
        ItemStack stack = new ItemStack(SeafarerItems.HORSESHOE_CRAB_BUCKET.get());
        if (this.hasCustomName()) {
            stack.setHoverName(this.getCustomName());
        }
        return stack;
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_EMPTY_FISH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.01F, 1.25F);
    }

    public static boolean canSpawn(EntityType<HorseshoeCrab> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return isBrightEnoughToSpawn(level, pos);
    }
}

package com.barlinc.seafarer.entities;

import com.barlinc.seafarer.entities.ai.goal.CustomRandomSwimGoal;
import com.barlinc.seafarer.entities.ai.goal.FollowSchoolLeaderGoal;
import com.barlinc.seafarer.entities.base.SchoolingFishMob;
import com.barlinc.seafarer.registry.SeafarerEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class SnakeMackerel extends SchoolingFishMob {

    public SnakeMackerel(EntityType<? extends SchoolingFishMob> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 1000, 5, 0.02F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 4);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.2F);
    }

    @Override
    public int getMaxSchoolSize() {
        return 5;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(3, new CustomRandomSwimGoal(this, 1.0D, 10, 20, 20, 3));
        this.goalSelector.addGoal(4, new FollowSchoolLeaderGoal(this));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag compoundTag) {
        spawnData = super.finalizeSpawn(level, difficulty, spawnType, spawnData, compoundTag);

        if (spawnType == MobSpawnType.CHUNK_GENERATION || spawnType == MobSpawnType.NATURAL) {
            int schoolCount = (int) (this.getMaxSchoolSize() * this.getRandom().nextFloat());
            if (schoolCount > 0 && !this.level().isClientSide()) {
                for (int i = 0; i < schoolCount; i++) {
                    float distance = 1.5F;
                    SnakeMackerel entity = new SnakeMackerel(SeafarerEntities.SNAKE_MACKEREL.get(), this.level());
                    entity.moveTo(this.getX() + this.getRandom().nextFloat() * distance, this.getY() + this.getRandom().nextFloat() * distance, this.getZ() + this.getRandom().nextFloat() * distance);
                    entity.startFollowing(this);
                    this.level().addFreshEntity(entity);
                }
            }
        }
        return spawnData;
    }
}

package com.barlinc.seafarer.entities.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class SeafloorWanderGoal extends RandomStrollGoal {

    private final int waterChance;
    private final int landChance;

    public SeafloorWanderGoal(PathfinderMob mob, double speed, int waterChance, int landChance) {
        super(mob, speed, waterChance);
        this.waterChance = waterChance;
        this.landChance = landChance;
    }

    public boolean canUse() {
        interval = mob.isInWater() ? waterChance : landChance;
        return super.canUse();
    }

    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    @Nullable
    protected Vec3 getPosition() {
        if (this.mob.isInWater()) {
            BlockPos blockpos = null;
            final RandomSource random = this.mob.getRandom();
            for (int i = 0; i < 15; i++) {
                BlockPos blockPos = this.mob.blockPosition().offset(random.nextInt(5) - 5 / 2, 3, random.nextInt(5) - 5 / 2);
                while ((this.mob.level().isEmptyBlock(blockPos) || this.mob.level().getFluidState(blockPos).is(FluidTags.WATER)) && blockPos.getY() > 1) {
                    blockPos = blockPos.below();
                }
                if (isBottomOfSeafloor(this.mob.level(), blockPos.above())) {
                    blockpos = blockPos;
                }
            }
            return blockpos != null ? new Vec3(blockpos.getX() + 0.5F, blockpos.getY() + 0.5F, blockpos.getZ() + 0.5F) : null;
        } else {
            return super.getPosition();

        }
    }

    private boolean isBottomOfSeafloor(LevelAccessor level, BlockPos pos) {
        return level.getFluidState(pos).is(FluidTags.WATER) && level.getFluidState(pos.below()).isEmpty() && level.getBlockState(pos.below()).canOcclude();
    }
}

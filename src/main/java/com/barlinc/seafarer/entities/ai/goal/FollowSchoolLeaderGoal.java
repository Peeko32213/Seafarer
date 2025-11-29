package com.barlinc.seafarer.entities.ai.goal;

import com.mojang.datafixers.DataFixUtils;
import com.barlinc.seafarer.entities.base.SchoolingFishMob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowSchoolLeaderGoal extends Goal {

    private final SchoolingFishMob mob;
    private int timeToRecalcPath;
    private int nextStartTick;

    public FollowSchoolLeaderGoal(SchoolingFishMob fish) {
        this.mob = fish;
        this.nextStartTick = this.nextStartTick(fish);
    }

    protected int nextStartTick(SchoolingFishMob fish) {
        return reducedTickDelay(200 + fish.getRandom().nextInt(200) % 20);
    }

    public boolean canUse() {
        if (this.mob.hasFollowers()) {
            return false;
        } else if (this.mob.isFollower()) {
            return true;
        } else if (this.nextStartTick > 0) {
            --this.nextStartTick;
            return false;
        } else {
            this.nextStartTick = this.nextStartTick(this.mob);
            Predicate<SchoolingFishMob> predicate = (fish1) -> fish1.canBeFollowed() || !fish1.isFollower();
            List<? extends SchoolingFishMob> list = this.mob.level().getEntitiesOfClass(this.mob.getClass(), this.mob.getBoundingBox().inflate(10.0D, 10.0D, 10.0D), predicate);
            SchoolingFishMob schoolingWaterAnimal = DataFixUtils.orElse(list.stream().filter(SchoolingFishMob::canBeFollowed).findAny(), this.mob);
            schoolingWaterAnimal.addFollowers(list.stream().filter((fish2) -> !fish2.isFollower()));
            return this.mob.isFollower();
        }
    }

    public boolean canContinueToUse() {
        return this.mob.isFollower() && this.mob.inRangeOfLeader();
    }

    public void start() {
        this.timeToRecalcPath = 0;
    }

    public void stop() {
        this.mob.stopFollowing();
    }

    public void tick() {
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = this.adjustedTickDelay(10);
            this.mob.pathToLeader();
        }
    }
}

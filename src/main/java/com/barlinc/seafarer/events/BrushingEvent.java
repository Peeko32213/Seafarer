package com.barlinc.seafarer.events;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

public class BrushingEvent extends Event {

    private final Level level;
    private final ItemStack item;
    private final Player player;

    public BrushingEvent(Level level, ItemStack item, Player player) {
        this.level = level;
        this.item = item;
        this.player = player;
    }

    public Level getLevel() {
        return level;
    }

    public ItemStack getItem() {
        return item;
    }

    public Player getPlayer() {
        return player;
    }

    public HumanoidArm getArm() {
        return getPlayer().getUsedItemHand() == InteractionHand.MAIN_HAND ? getPlayer().getMainArm() : getPlayer().getMainArm().getOpposite();
    }

    public Vec3 getVec() {
        return getPlayer().getViewVector(0.0F);
    }

    @Cancelable
    public static class Block extends BrushingEvent {
        private final BlockHitResult blockHitResult;
        private final BlockPos pos;

        public Block(Level level, ItemStack item, Player player, BlockHitResult blockHitResult, BlockPos pos) {
            super(level, item, player);
            this.blockHitResult = blockHitResult;
            this.pos = pos;
        }

        public BlockHitResult getBlockHitResult() {
            return blockHitResult;
        }

        public BlockState getBlockState() {
            return getLevel().getBlockState(getPos());
        }

        public BlockPos getPos() {
            return pos;
        }

        public SoundEvent getSoundEvent() {
            net.minecraft.world.level.block.Block block = getBlockState().getBlock();
            if(block instanceof BrushingEventSound event) {
                return event.getBrushingSound();
            }

            if (block instanceof BrushableBlock) {
                BrushableBlock brushableblock = (BrushableBlock)block;
                return brushableblock.getBrushSound();
            } else {
                return SoundEvents.BRUSH_GENERIC;
            }
        }
    }

    @Cancelable
    public static class Entity extends BrushingEvent {
        private final EntityHitResult entityHitResult;
        private final net.minecraft.world.entity.Entity targetEntity;
        private final BlockPos pos;

        public Entity(Level level, ItemStack item, Player player, EntityHitResult entityHitResult, net.minecraft.world.entity.Entity targetEntity, BlockPos pos) {
            super(level, item, player);
            this.entityHitResult = entityHitResult;
            this.targetEntity = targetEntity;
            this.pos = pos;
        }

        public EntityHitResult getEntityHitResult() {
            return entityHitResult;
        }

        public net.minecraft.world.entity.Entity getTargetEntity() {
            return targetEntity;
        }

        public SoundEvent getSoundEvent() {
            net.minecraft.world.entity.Entity entity = getTargetEntity();
            if(entity instanceof BrushingEventSound event) {
                return event.getBrushingSound();
            }
            else {
                return SoundEvents.BRUSH_GENERIC;
            }
        }

        public BlockPos getPos() {
            return pos;
        }
    }
}

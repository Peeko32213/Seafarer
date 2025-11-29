package com.barlinc.seafarer.entities.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface Brushable {

    void startBrusing();
    void endBrushing();

    default boolean isBrushable(Player player, @NotNull ItemStack item, Level level, BlockPos pos)
    {
        return true;
    }
    List<ItemStack> brush(long gameTime, Player player, Direction direction , ItemStack stack, Level level, BlockPos pos, int fortune);


    @Nullable
    SoundEvent brushSound();
}

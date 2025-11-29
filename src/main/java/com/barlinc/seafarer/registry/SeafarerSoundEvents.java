package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeafarerSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Seafarer.MOD_ID);

    public static final RegistryObject<SoundEvent> FISH_IDLE = registerSoundEvent("fish_idle");
    public static final RegistryObject<SoundEvent> FISH_HURT = registerSoundEvent("fish_hurt");
    public static final RegistryObject<SoundEvent> FISH_DEATH = registerSoundEvent("fish_death");
    public static final RegistryObject<SoundEvent> FISH_FLOP = registerSoundEvent("fish_flop");
    public static final RegistryObject<SoundEvent> FISH_JUMP = registerSoundEvent("fish_jump");

    private static RegistryObject<SoundEvent> registerSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Seafarer.MOD_ID, soundName)));
    }
}

package com.barlinc.seafarer.utils;

import net.minecraftforge.fml.ModList;

import java.lang.reflect.InvocationTargetException;

public class CommonProxy {

    public void init() {
    }

    public void commonSetup() {
        if (ModList.get().isLoaded("terrablender")) {
            try {
                Class<?> clazz = Class.forName("com.barlinc.seafarer.integration.terrablender.TerraBlenderIntegration");
                clazz.getMethod("register").invoke(null);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public void clientSetup() {
    }
}

package com.luis.flightwings.util;

import net.minecraftforge.fml.ModList;

public enum ExternalMods {
    JEI("jei");

    private final boolean loaded;

    ExternalMods(String modid) {
        this.loaded = ModList.get() != null && ModList.get().getModContainerById(modid).isPresent();
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}

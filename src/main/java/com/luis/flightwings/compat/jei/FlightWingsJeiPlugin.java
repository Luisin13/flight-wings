package com.luis.flightwings.compat.jei;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.compat.jei.description.ItemsDescription;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class FlightWingsJeiPlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(FlightWings.MOD_ID, "default");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        new ItemsDescription(registry);
    }
}

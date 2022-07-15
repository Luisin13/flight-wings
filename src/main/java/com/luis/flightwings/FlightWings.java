package com.luis.flightwings;

import com.luis.flightwings.compat.jei.FlightWingsJeiPlugin;
import com.luis.flightwings.config.ServerConfig;
import com.luis.flightwings.items.ModItems;
import com.luis.flightwings.util.ExternalMods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(FlightWings.MOD_ID)
public class FlightWings {
    public static final String MOD_ID = "flightwings";

    public static final CreativeModeTab FLIGHTWINGS_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.FLIGHT_WING_GOLD.get());
        }
    };

    public FlightWings() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC, "flightwings-server.toml");

        if(ExternalMods.JEI.isLoaded())
            new FlightWingsJeiPlugin();
    }
}

package com.luis.flightwings.items;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.config.ServerConfig;
import com.luis.flightwings.items.custom.FlightWingGold;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FlightWings.MOD_ID);

    public static final RegistryObject<Item> FLIGHT_WING_GOLD = register("flight_wing_gold",
            () -> new FlightWingGold(new Item.Properties().tab(FlightWings.FLIGHTWINGS_TAB).rarity(Rarity.EPIC).stacksTo(1)));

    private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<? extends T> item) {
        return ITEMS.register(name, item);
    };
}

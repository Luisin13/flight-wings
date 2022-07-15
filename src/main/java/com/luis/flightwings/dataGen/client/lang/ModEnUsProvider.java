package com.luis.flightwings.dataGen.client.lang;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

    public ModEnUsProvider(DataGenerator generator) {
        super(generator, FlightWings.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Item groups
        add("itemGroup.flightwings", "Flight Wings");

        // Items
        add(ModItems.FLIGHT_WING_GOLD.get(), "Golden Flight Wing");

        // Tooltips
        add("tooltip.flight_wings_gold.shift.down.1", "Fly like creative!");
        add("tooltip.flight_wings_gold.shift.down.2", "Now in pure §6gold§r.");
        add("tooltip.flight_wings_gold.shift.down.special", "§6SHIFT-Right Click§r activates special ability, but uses %s XP levels!");
        add("tooltip.flight_wings_gold.shift.down.special.no_cost", "§6SHIFT-Right Click§r activates special ability!");
        add("tooltip.flight_wings_gold.shift", "Press §6SHIFT§r for more information.");

        // System/chat messages
        add("message.flight_wing_gold.not_enough_xp", "You can't use the wing effect now, not enough experience level!");

        // Advancements
        add("advancements.flightwings.flight_wing_gold.title", "Fly like creative!");
        add("advancements.flightwings.flight_wing_gold.description", "Now in pure §6gold§r.");

        // JEI descriptions
        add("description.flight_wings_gold", "Makes you fly like in the creative, now in pure §6gold§r!");
        add("description.flight_wings_gold.ability", "§6SHIFT-Right Click§r activates special ability, but uses %s XP levels!");
        add("description.flight_wings_gold.ability.no_cost", "§6SHIFT-Right Click§r activates special ability!");
    }
}

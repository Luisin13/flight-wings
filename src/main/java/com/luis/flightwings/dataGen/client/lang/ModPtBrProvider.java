package com.luis.flightwings.dataGen.client.lang;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModPtBrProvider extends LanguageProvider {

    public ModPtBrProvider(DataGenerator generator) {
        super(generator, FlightWings.MOD_ID, "pt_br");
    }

    @Override
    protected void addTranslations() {
        // Item groups
        add("itemGroup.flightwings", "Flight Wings");

        // Items
        add(ModItems.FLIGHT_WING_GOLD.get(), "Asa de Voo Dourada");

        // Tooltips
        add("tooltip.flight_wings_gold.shift.down.1", "Voe como no criativo!");
        add("tooltip.flight_wings_gold.shift.down.2", "Agora em §6ouro§r puro.");
        add("tooltip.flight_wings_gold.shift.down.special", "§6SHIFT-Botão Direito§r ativa a habilidade especial, mas usa %s leveis de XP!");
        add("tooltip.flight_wings_gold.shift.down.special.no_cost", "§6SHIFT-Botão Direito§r ativa a habilidade especial!");
        add("tooltip.flight_wings_gold.shift", "Aperte §6SHIFT§r para mais informações.");

        // System/chat messages
        add("message.flight_wing_gold.not_enough_xp", "Você não pode usar o efeito de asa agora, não há nível de experiência suficiente!");

        // Advancements
        add("advancements.flightwings.flight_wing_gold.title", "Voe como no criativo!");
        add("advancements.flightwings.flight_wing_gold.description", "Agora em §6ouro§r puro.");

        // JEI descriptions
        add("description.flight_wings_gold", "Faz você voar como no criativo, agora em §6ouro§r puro!");
        add("description.flight_wings_gold.ability", "§6SHIFT-Botão Direito§r ativa a habilidade especial, mas usa %s leveis de XP!");
        add("description.flight_wings_gold.ability.no_cost", "§6SHIFT-Botão Direito§r ativa a habilidade especial!");
    }
}

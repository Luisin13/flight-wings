package com.luis.flightwings.compat.jei.description;

import com.luis.flightwings.config.ServerConfig;
import com.luis.flightwings.items.ModItems;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;

public class ItemsDescription {
    public ItemsDescription(IRecipeRegistration registry) {
        IIngredientManager ingredientManager = registry.getIngredientManager();

        IIngredientType<ItemStack> itemType = ingredientManager.getIngredientType(ItemStack.class);

        registry.addIngredientInfo(new ItemStack(ModItems.FLIGHT_WING_GOLD.get()), itemType, new TranslatableComponent("description.flight_wings_gold"), ServerConfig.WINGS_EFFECT_CONSUME_XP.get() ? new TranslatableComponent("description.flight_wings_gold.ability", ServerConfig.WINGS_EFFECT_USE_XP.get()) : new TranslatableComponent("description.flight_wings_gold.ability.no_cost"));
    }
}

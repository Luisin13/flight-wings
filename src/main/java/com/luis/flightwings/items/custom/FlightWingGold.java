package com.luis.flightwings.items.custom;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.config.ServerConfig;
import com.luis.flightwings.items.ModItems;
import com.luis.flightwings.util.Flight;
import com.luis.flightwings.util.InventoryUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class FlightWingGold extends Item {
    public FlightWingGold(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack,
                                @Nullable Level pLevel,
                                @NotNull List<Component> pTooltipComponent,
                                @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponent.add(new TranslatableComponent("tooltip.flight_wings_gold.shift.down.1"));
            pTooltipComponent.add(new TranslatableComponent("tooltip.flight_wings_gold.shift.down.2"));
            if(ServerConfig.WINGS_EFFECT.get()) {
                if (ServerConfig.WINGS_EFFECT_CONSUME_XP.get()) {
                    pTooltipComponent.add(new TranslatableComponent("tooltip.flight_wings_gold.shift.down.special", ServerConfig.WINGS_EFFECT_USE_XP.get()));
                } else {
                    pTooltipComponent.add(new TranslatableComponent("tooltip.flight_wings_gold.shift.down.special.no_cost"));
                }
            }
        } else {
            pTooltipComponent.add(new TranslatableComponent("tooltip.flight_wings_gold.shift"));
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        if(entity instanceof Player player) {
            Flight.StopFlight(player);

        }

        if (stack.hasTag()) {
            CompoundTag data = new CompoundTag();
            data.putBoolean(FlightWings.MOD_ID + ".isActive", false);

            stack.setTag(data);

        }

        return super.onEntitySwing(getDefaultInstance(), entity);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level,
                                                           @NotNull Player player,
                                                           @NotNull InteractionHand interactionHand) {
        if(player.isCrouching()) {
            if(!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND && ServerConfig.WINGS_EFFECT.get()) {
                if(ServerConfig.WINGS_EFFECT_CONSUME_XP.get()) {
                    if(player.experienceLevel >= ServerConfig.WINGS_EFFECT_USE_XP.get()) {
                        player.giveExperienceLevels(-ServerConfig.WINGS_EFFECT_USE_XP.get());
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, ServerConfig.WINGS_EFFECT_DURATION.get() * 20, ServerConfig.WINGS_EFFECT_AMPLIFIER.get() - 1));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, ServerConfig.WINGS_EFFECT_DURATION.get() * 20, ServerConfig.WINGS_EFFECT_AMPLIFIER.get() - 1));
                    } else {
                        ((ServerPlayer) player).sendMessage(new TranslatableComponent("message.flight_wing_gold.not_enough_xp"), ChatType.GAME_INFO, player.getUUID());
                    }
                } else {
                    player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, ServerConfig.WINGS_EFFECT_DURATION.get() * 20, ServerConfig.WINGS_EFFECT_AMPLIFIER.get() - 1));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, ServerConfig.WINGS_EFFECT_DURATION.get() * 20, ServerConfig.WINGS_EFFECT_AMPLIFIER.get() - 1));
                }
            }
        } else {
            if(!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND) {
                ItemStack stack;

                int itemAmount = InventoryUtil.itemAmount(player, ModItems.FLIGHT_WING_GOLD.get());
                boolean hasItem = itemAmount > 0;
                if(hasItem) {
                    stack = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.FLIGHT_WING_GOLD.get()));
                } else {
                    stack = player.getItemInHand(interactionHand);
                }

                boolean isActive;
                if(stack.hasTag()) {
                    isActive = !stack.getTag().getBoolean(FlightWings.MOD_ID + ".isActive");
                } else {
                    isActive = true;
                }

                CompoundTag data = new CompoundTag();
                data.putBoolean(FlightWings.MOD_ID + ".isActive", isActive);

                stack.setTag(data);

                if(isActive) {
                    Flight.StartFlight(player);
                } else  {
                    Flight.StopFlight(player);
                }

                player.getCooldowns().addCooldown(this, 10);
            }
        }
        return super.use(level, player, interactionHand);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        boolean isActive;
        if (stack.hasTag()) {
            isActive = stack.getTag().getBoolean(FlightWings.MOD_ID + ".isActive");
        } else {
            isActive = false;
        }
        return isActive;
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack stack, Player player) {
        CompoundTag data = new CompoundTag();
        data.putBoolean(FlightWings.MOD_ID + ".isActive", false);

        stack.setTag(data);

        Flight.StopFlight(player);
        return super.onDroppedByPlayer(stack, player);
    }
}

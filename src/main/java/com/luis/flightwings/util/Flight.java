package com.luis.flightwings.util;

import net.minecraft.world.entity.player.Player;

public class Flight {

    public static void StartFlight(Player player) {
        if(player.isCreative() || player.isSpectator()) return;

        player.getAbilities().mayfly = true;
        player.onUpdateAbilities();
    }

    public static void StopFlight(Player player) {
        if(player.isCreative() || player.isSpectator()) return;

        player.getAbilities().flying = false;
        player.getAbilities().mayfly = false;
        player.onUpdateAbilities();
    }
}

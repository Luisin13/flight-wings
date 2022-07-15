package com.luis.flightwings.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue WINGS_EFFECT;
    public static final ForgeConfigSpec.IntValue WINGS_EFFECT_DURATION;
    public static final ForgeConfigSpec.IntValue WINGS_EFFECT_AMPLIFIER;
    public static final ForgeConfigSpec.BooleanValue WINGS_EFFECT_CONSUME_XP;
    public static final ForgeConfigSpec.IntValue WINGS_EFFECT_USE_XP;

    static {
        BUILDER.push("Configuration for Flight Wings mod");

        WINGS_EFFECT = BUILDER.comment("Wings can give potion effect on hotkey press")
                .define("Wings give potion effect", false);

        WINGS_EFFECT_DURATION = BUILDER.comment("Wings effect duration, only affect if wings effects is activated")
                .defineInRange("Wings potion effect duration", 30, 5, 300);

        WINGS_EFFECT_AMPLIFIER = BUILDER.comment("Wings effect amplifier, only affect if wings effects is activated")
                .defineInRange("Wings potion effect amplifier", 1, 1, 3);

        WINGS_EFFECT_CONSUME_XP = BUILDER.comment("Wings when used the potion effect consume XP, only affect if wings effects is activated")
                .define("Wings effect consume XP", false);

        WINGS_EFFECT_USE_XP = BUILDER.comment("Wings effect xp consumption, only affect if wings effects consume XP is activated")
                .defineInRange("Wings effect consumption by use", 1, 1, 10);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}

package com.luis.flightwings.dataGen;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.dataGen.client.ModItemModelProvider;
import com.luis.flightwings.dataGen.client.lang.ModEnUsProvider;
import com.luis.flightwings.dataGen.client.lang.ModPtBrProvider;
import com.luis.flightwings.dataGen.server.ModBlockTagsProvider;
import com.luis.flightwings.dataGen.server.ModItemTagsProvider;
import com.luis.flightwings.dataGen.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = FlightWings.MOD_ID, bus = Bus.MOD)
public class FlightWingsDataGeneration {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            // Client data gen
            generator.addProvider(new ModItemModelProvider(generator, helper));
            generator.addProvider(new ModEnUsProvider(generator));
            generator.addProvider(new ModPtBrProvider(generator));
        }

        if(event.includeServer()) {

            ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);

            // Server data gen
            generator.addProvider(new ModRecipeProvider(generator));
            generator.addProvider(blockTags);
            generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
        }
    }
}

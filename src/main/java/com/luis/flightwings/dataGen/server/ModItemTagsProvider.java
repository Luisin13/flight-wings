package com.luis.flightwings.dataGen.server;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.items.ModItems;
import com.luis.flightwings.tags.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
        super(generator, blocks, FlightWings.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Items.FLIGHT_WING).add(ModItems.FLIGHT_WING_GOLD.get());
    }
}
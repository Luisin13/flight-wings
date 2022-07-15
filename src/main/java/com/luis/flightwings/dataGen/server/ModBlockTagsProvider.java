package com.luis.flightwings.dataGen.server;

import com.luis.flightwings.FlightWings;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, FlightWings.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
    }

}
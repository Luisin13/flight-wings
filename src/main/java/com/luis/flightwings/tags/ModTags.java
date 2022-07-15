package com.luis.flightwings.tags;

import com.luis.flightwings.FlightWings;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {

        private static TagKey<Block> modTag(String path) {
            return BlockTags.create(new ResourceLocation(FlightWings.MOD_ID, path));
        }

        private static TagKey<Block> forgeTag(String path)  {
            return BlockTags.create(new ResourceLocation("forge", path));
        }
    }

    public static final class Items {

        public static final TagKey<Item> FLIGHT_WING = modTag("flight_wing");

        private static TagKey<Item> modTag(String path) {
            return ItemTags.create(new ResourceLocation(FlightWings.MOD_ID, path));
        }

        private static TagKey<Item> forgeTag(String path)  {
            return ItemTags.create(new ResourceLocation("forge", path));
        }
    }
}
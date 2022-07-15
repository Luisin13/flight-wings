package com.luis.flightwings.dataGen.client;

import com.luis.flightwings.FlightWings;
import com.luis.flightwings.items.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    // Maybe used
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, FlightWings.MOD_ID, helper);
    }

    protected void simpleBlockItem(Item item) {
        getBuilder(item.getRegistryName().toString()).parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
    }

    private ItemModelBuilder complexBlock(Block block) {
        return withExistingParent(block.getRegistryName().getPath(), new ResourceLocation(FlightWings.MOD_ID,
                "block/" + block.getRegistryName().getPath()));
    }

    protected void oneLayerItem(Item item, ResourceLocation texture) {
        ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
        if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
            getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
        } else {
            System.out.println("Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
        }
    }

    protected void oneLayerItem(Item item) {
        oneLayerItem(item, item.getRegistryName());
    }

    @Override
    protected void registerModels() {
        // Blocks

        // Items
    }
}

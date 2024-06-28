package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.FIRST_ITEM);
        simpleItem(ModItems.FIRST_STICK);

        saplingItem(ModBlocks.FIRST_SAPLING);

        simpleBlockItem(ModBlocks.FIRST_DOOR);
        fenceItem(ModBlocks.FIRST_FENCE, ModBlocks.FIRST_PLANKS);
        buttonItem(ModBlocks.FIRST_BUTTON, ModBlocks.FIRST_PLANKS);

        evenSimplerBlockItem(ModBlocks.FIRST_STAIRS);
        evenSimplerBlockItem(ModBlocks.FIRST_SLAB);
        evenSimplerBlockItem(ModBlocks.FIRST_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.FIRST_FENCE_GATE);
        trapdoorItem(ModBlocks.FIRST_TRAPDOOR);
        simpleItem(ModItems.FIRST_SIGN);
        simpleItem(ModItems.FIRST_HANGING_SIGN);
        simpleItem(ModItems.FIRST_BOAT);
        simpleItem(ModItems.FIRST_CHEST_BOAT);
    }

    private ItemModelBuilder simpleItem (RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(FirstMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(FirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}

package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FIRST_ORE);


        logBlock(((RotatedPillarBlock) ModBlocks.FIRST_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.FIRST_WOOD.get()), blockTexture(ModBlocks.FIRST_LOG.get()), blockTexture(ModBlocks.FIRST_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_FIRST_LOG.get()), blockTexture(ModBlocks.STRIPPED_FIRST_LOG.get()),
                new ResourceLocation(FirstMod.MOD_ID, "block/stripped_first_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_FIRST_WOOD.get()), blockTexture(ModBlocks.STRIPPED_FIRST_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_FIRST_LOG.get()));

        blockItem(ModBlocks.FIRST_LOG);
        blockItem(ModBlocks.FIRST_WOOD);
        blockItem(ModBlocks.STRIPPED_FIRST_LOG);
        blockItem(ModBlocks.STRIPPED_FIRST_WOOD);

        blockWithItem(ModBlocks.FIRST_PLANKS);

        leavesBlock(ModBlocks.FIRST_LEAVES);


    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(FirstMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

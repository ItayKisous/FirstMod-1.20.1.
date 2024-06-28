package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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
        blockWithItem(ModBlocks.VOLCANIC_ROCK);
        blockWithItem(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK);
        blockWithItem(ModBlocks.COOLER_VOLCANIC_ROCK);
        blockWithItem(ModBlocks.COOLED_VOLCANIC_ROCK);


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
        saplingBlock(ModBlocks.FIRST_SAPLING);

        simpleBlockWithItem(ModBlocks.CHIPPING_TABLE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/chipping_table")));

        stairsBlock(((StairBlock) ModBlocks.FIRST_STAIRS.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.FIRST_SLAB.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.FIRST_BUTTON.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.FIRST_PRESSURE_PLATE.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.FIRST_FENCE.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.FIRST_FENCE_GATE.get()), blockTexture(ModBlocks.FIRST_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.FIRST_DOOR.get()), modLoc("block/first_door_bottom"), modLoc("block/first_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.FIRST_TRAPDOOR.get()), modLoc("block/first_trapdoor"), true, "cutout");

        signBlock(((StandingSignBlock) ModBlocks.FIRST_SIGN.get()), ((WallSignBlock) ModBlocks.FIRST_WALL_SIGN.get()),
                blockTexture(ModBlocks.FIRST_PLANKS.get()));

        hangingSignBlock(ModBlocks.FIRST_HANGING_SIGN.get(), ModBlocks.FIRST_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.FIRST_PLANKS.get()));
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

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }


    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

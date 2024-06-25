package net.itaykisous.firstmod.datagen.loot;

import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {


        this.add(ModBlocks.FIRST_ORE.get(),
                block -> createOreDrop(ModBlocks.FIRST_ORE.get(), ModItems.RAW_FIRST.get()));


        this.dropSelf(ModBlocks.FIRST_LOG.get());
        this.dropSelf(ModBlocks.FIRST_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_FIRST_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_FIRST_WOOD.get());
        this.dropSelf(ModBlocks.FIRST_PLANKS.get());
        this.dropSelf(ModBlocks.FIRST_SAPLING.get());

        this.add(ModBlocks.FIRST_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.FIRST_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
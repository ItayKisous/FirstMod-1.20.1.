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
        this.dropSelf(ModBlocks.VOLCANIC_ROCK.get());
        this.dropSelf(ModBlocks.COOLER_VOLCANIC_ROCK.get());
        this.dropSelf(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK.get());
        this.dropSelf(ModBlocks.COOLED_VOLCANIC_ROCK.get());
        this.dropSelf(ModBlocks.CHIPPING_TABLE.get());
        this.dropSelf(ModBlocks.FIRST_FENCE.get());
        this.dropSelf(ModBlocks.FIRST_FENCE_GATE.get());
        this.dropSelf(ModBlocks.FIRST_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.FIRST_STAIRS.get());
        this.dropSelf(ModBlocks.FIRST_TRAPDOOR.get());
        this.dropSelf(ModBlocks.FIRST_BUTTON.get());

        this.add(ModBlocks.FIRST_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.FIRST_SLAB.get()));
        this.add(ModBlocks.FIRST_DOOR.get(),
                block -> createDoorTable(ModBlocks.FIRST_DOOR.get()));


        this.add(ModBlocks.FIRST_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.FIRST_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.FIRST_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIRST_SIGN.get()));
        this.add(ModBlocks.FIRST_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIRST_SIGN.get()));

        this.add(ModBlocks.FIRST_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIRST_HANGING_SIGN.get()));
        this.add(ModBlocks.FIRST_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.FIRST_HANGING_SIGN.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Here we add the custom mod tags.

        this.tag(Tags.Blocks.ORES).add(ModBlocks.FIRST_ORE.get());

        // Tool Tags
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.FIRST_ORE.get());

        // Mining Level Tags
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.FIRST_ORE.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.FIRST_LOG.get())
                .add(ModBlocks.FIRST_WOOD.get())
                .add(ModBlocks.STRIPPED_FIRST_LOG.get())
                .add(ModBlocks.STRIPPED_FIRST_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.FIRST_PLANKS.get());
    }
}

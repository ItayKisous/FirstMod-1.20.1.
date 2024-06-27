package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.FIRST_LOGS)
                .add(ModBlocks.FIRST_LOG.get().asItem())
                .add(ModBlocks.FIRST_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_FIRST_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_FIRST_LOG.get().asItem());


        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.FIRST_LOG.get().asItem())
                .add(ModBlocks.FIRST_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_FIRST_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_FIRST_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.FIRST_PLANKS.get().asItem());
    }
}

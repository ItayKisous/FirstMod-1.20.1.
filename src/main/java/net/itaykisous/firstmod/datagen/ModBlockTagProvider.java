package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // Here we add the custom mod tags.

        this.tag(Tags.Blocks.ORES).add(ModBlocks.FIRST_ORE.get());

        this.tag(ModTags.Blocks.VOLCANIC_ROCKS).add(ModBlocks.VOLCANIC_ROCK.get())
                .add(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK.get())
                .add(ModBlocks.COOLER_VOLCANIC_ROCK.get())
                .add(ModBlocks.COOLED_VOLCANIC_ROCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(ModBlocks.VOLCANIC_ROCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.COOLED_VOLCANIC_ROCK.get());

        // Tool Tags
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.FIRST_ORE.get())
                .add(ModBlocks.VOLCANIC_ROCK.get())
                .add(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK.get())
                .add(ModBlocks.COOLER_VOLCANIC_ROCK.get())
                .add(ModBlocks.COOLED_VOLCANIC_ROCK.get());

        // Mining Level Tags
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.FIRST_ORE.get())
                .add(ModBlocks.COOLER_VOLCANIC_ROCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.FIRST_LOG.get())
                .add(ModBlocks.FIRST_WOOD.get())
                .add(ModBlocks.STRIPPED_FIRST_LOG.get())
                .add(ModBlocks.STRIPPED_FIRST_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.FIRST_PLANKS.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.FIRST_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.FIRST_FENCE_GATE.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.FIRST_FENCE.get());

        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.FIRST_BUTTON.get()).addTag(BlockTags.WOODEN_BUTTONS);

        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.FIRST_TRAPDOOR.get()).addTag(BlockTags.WOODEN_TRAPDOORS);

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.FIRST_DOOR.get()).addTag(BlockTags.WOODEN_DOORS);

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.FIRST_STAIRS.get()).addTag(BlockTags.WOODEN_STAIRS);

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.FIRST_SLAB.get()).addTag(BlockTags.WOODEN_SLABS);

        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.FIRST_PRESSURE_PLATE.get()).addTag(BlockTags.WOODEN_PRESSURE_PLATES);
    }
}

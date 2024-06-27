package net.itaykisous.firstmod.util;

import net.itaykisous.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> VOLCANIC_ROCKS = tag("volcanic_rocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FIRST_LOGS = tag("first_logs");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FirstMod.MOD_ID, name));
        }
    }
}

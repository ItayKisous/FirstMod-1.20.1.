package net.itaykisous.firstmod.datagen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.item.ModItems;
import net.itaykisous.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> FIRST_SMELTABLES = List.of(ModItems.RAW_FIRST.get(),
            ModBlocks.FIRST_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWritter) {
        oreBlasting(pWritter, FIRST_SMELTABLES, RecipeCategory.MISC, ModItems.FIRST_ITEM.get(), 0.25f, 100, "first");
        oreSmelting(pWritter, FIRST_SMELTABLES, RecipeCategory.MISC, ModItems.FIRST_ITEM.get(), 0.25f, 200, "first");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRST_STICK.get())
                .pattern("S ")
                .pattern(" S")
                .define('S', ModBlocks.FIRST_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.FIRST_PLANKS.get()), has(ModBlocks.FIRST_PLANKS.get()))
                .save(pWritter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.FIRST_PLANKS.get(), 2)
                .requires(ModTags.Items.FIRST_LOGS)
                .unlockedBy(getHasName(ModBlocks.FIRST_LOG.get()), has(ModBlocks.FIRST_LOG.get()))
                .save(pWritter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FIRST_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.FIRST_LOG.get())
                .unlockedBy(getHasName(ModBlocks.FIRST_LOG.get()), has(ModBlocks.FIRST_LOG.get()))
                .save(pWritter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_FIRST_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.STRIPPED_FIRST_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_FIRST_LOG.get()), has(ModBlocks.STRIPPED_FIRST_LOG.get()))
                .save(pWritter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

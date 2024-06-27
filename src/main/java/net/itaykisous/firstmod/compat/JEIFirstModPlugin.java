package net.itaykisous.firstmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.custom.ChippingTableBlock;
import net.itaykisous.firstmod.recipe.ChippingTableRecipe;
import net.itaykisous.firstmod.screen.ChippingTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIFirstModPlugin implements IModPlugin {


    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(FirstMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ChippingTableCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ChippingTableRecipe> chippingRecipes = recipeManager.getAllRecipesFor(ChippingTableRecipe.Type.INSTANCE);
        registration.addRecipes(ChippingTableCategory.CHIPPING_TYPE, chippingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ChippingTableScreen.class, 80, 30, 20, 30, ChippingTableCategory.CHIPPING_TYPE);
    }
}
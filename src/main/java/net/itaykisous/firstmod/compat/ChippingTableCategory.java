package net.itaykisous.firstmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.recipe.ChippingTableRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ChippingTableCategory implements IRecipeCategory<ChippingTableRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(FirstMod.MOD_ID, "chipping_table");
    public static final ResourceLocation TEXTURE = new ResourceLocation(FirstMod.MOD_ID, "textures/gui/chipping_table_gui.png");

    public static RecipeType<ChippingTableRecipe> CHIPPING_TYPE =
            new RecipeType<>(UID, ChippingTableRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ChippingTableCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CHIPPING_TABLE.get()));
    }


    @Override
    public RecipeType<ChippingTableRecipe> getRecipeType() {
        return CHIPPING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.firstmod.chipping_table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ChippingTableRecipe chippingTableRecipe, IFocusGroup iFocusGroup) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(chippingTableRecipe.getIngredients().get(0));

            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(chippingTableRecipe.getResultItem(null));
    }
}

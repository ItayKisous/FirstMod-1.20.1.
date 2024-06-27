package net.itaykisous.firstmod.recipe;

import net.itaykisous.firstmod.FirstMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FirstMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ChippingTableRecipe>> CHIPPING_TABLE_SERIALIZER =
            SERIALIZERS.register("chipping", () -> ChippingTableRecipe.Serializer.INSTANCE);

    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

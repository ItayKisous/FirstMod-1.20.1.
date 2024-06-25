package net.itaykisous.firstmod.item;

import net.itaykisous.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> FIRST_ITEM = ITEMS.register("first",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_FIRST = ITEMS.register("raw_first",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIRST_STICK = ITEMS.register("first_stick",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

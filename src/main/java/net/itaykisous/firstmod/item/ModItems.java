package net.itaykisous.firstmod.item;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.entity.custom.ModBoatEntity;
import net.itaykisous.firstmod.item.custom.ModBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
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

    public static final RegistryObject<Item> FIRST_SIGN = ITEMS.register("first_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.FIRST_SIGN.get(), ModBlocks.FIRST_WALL_SIGN.get()));
    public static final RegistryObject<Item> FIRST_HANGING_SIGN = ITEMS.register("first_hanging_sign",
            () -> new HangingSignItem( ModBlocks.FIRST_HANGING_SIGN.get(), ModBlocks.FIRST_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> FIRST_BOAT = ITEMS.register("first_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.FIRST, new Item.Properties()));

    public static final RegistryObject<Item> FIRST_CHEST_BOAT = ITEMS.register("first_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.FIRST, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

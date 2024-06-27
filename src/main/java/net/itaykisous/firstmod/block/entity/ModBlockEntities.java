package net.itaykisous.firstmod.block.entity;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.block.custom.ChippingTableBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FirstMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ChippingTableBlockEntity>> CHIPPING_TABLE_BE =
            BLOCK_ENTITIES.register("chipping_table_be", () ->
                    BlockEntityType.Builder.of(ChippingTableBlockEntity::new,
                            ModBlocks.CHIPPING_TABLE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

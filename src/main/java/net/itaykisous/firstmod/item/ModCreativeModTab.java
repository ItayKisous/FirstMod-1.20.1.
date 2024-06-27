package net.itaykisous.firstmod.item;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRST_TAB = CREATIVE_MODE_TABS.register("first",
            () -> CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.FIRST_ITEM.get()))
                    .title(Component.translatable("creativetab.first_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FIRST_ITEM.get());
                        output.accept(ModBlocks.FIRST_ORE.get());
                        output.accept(ModItems.RAW_FIRST.get());
                        output.accept(ModItems.FIRST_STICK.get());

                        output.accept(ModBlocks.FIRST_LOG.get());
                        output.accept(ModBlocks.FIRST_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_FIRST_LOG.get());
                        output.accept(ModBlocks.STRIPPED_FIRST_WOOD.get());
                        output.accept(ModBlocks.FIRST_LEAVES.get());
                        output.accept(ModBlocks.FIRST_PLANKS.get());
                        output.accept(ModBlocks.FIRST_SAPLING.get());
                        output.accept(ModBlocks.VOLCANIC_ROCK.get());
                        output.accept(ModBlocks.SLIGHTLY_COOLED_VOLCANIC_ROCK.get());
                        output.accept(ModBlocks.COOLER_VOLCANIC_ROCK.get());
                        output.accept(ModBlocks.COOLED_VOLCANIC_ROCK.get());
                        output.accept(ModBlocks.CHIPPING_TABLE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

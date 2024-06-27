package net.itaykisous.firstmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.itaykisous.firstmod.item.ModItems;
import net.itaykisous.firstmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.CHIPPING_VILLAGER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.FIRST_STICK.get(), 3),
                    10, 8, .02f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.FIRST_ITEM.get(), 2),
                    5, 10, .02f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    new ItemStack(ModBlocks.FIRST_SAPLING.get().asItem(), 1),
                    3, 20, .05f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModBlocks.VOLCANIC_ROCK.get().asItem(), 6),
                    new ItemStack(Items.EMERALD, 20),
                    6, 15, .1f));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        // Add trades to rare/generic trades here:
    }
}

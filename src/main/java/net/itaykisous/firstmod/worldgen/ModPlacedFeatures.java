package net.itaykisous.firstmod.worldgen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FIRST_ORE_PLACED_KEY = registerKey("first_ore_placed");

    public static final ResourceKey<PlacedFeature> FIRST_WOOD_PLACED_KEY = registerKey("first_wood_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, FIRST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_FIRST_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(12))));


        register(context, FIRST_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FIRST_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(32), ModBlocks.FIRST_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FirstMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

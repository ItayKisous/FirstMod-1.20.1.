package net.itaykisous.firstmod.worldgen;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_FIRST_ORE_KEY = registerKey("first_ore");

    public static final ResourceKey<ConfiguredFeature<?,?>> FIRST_KEY = registerKey("first");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldFirstOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.FIRST_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.FIRST_ORE.get().defaultBlockState())); // TODO: Add Deepslate Ore

        register(context, OVERWORLD_FIRST_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFirstOres, 9));

        register(context, FIRST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.FIRST_LOG.get()),
                new StraightTrunkPlacer(3, 1, 3),
                BlockStateProvider.simple(ModBlocks.FIRST_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static ResourceKey<ConfiguredFeature<?,?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FirstMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?,?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?,?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

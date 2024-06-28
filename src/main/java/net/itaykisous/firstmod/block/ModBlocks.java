package net.itaykisous.firstmod.block;

import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.custom.*;
import net.itaykisous.firstmod.block.entity.ModSignBlockEntity;
import net.itaykisous.firstmod.item.ModItems;
import net.itaykisous.firstmod.util.ModWoodTypes;
import net.itaykisous.firstmod.worldgen.tree.FirstTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);


    public static final RegistryObject<Block> FIRST_ORE = registerBlock("first_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> VOLCANIC_ROCK = registerBlock("volcanic_rock",
            () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                            .requiresCorrectToolForDrops()
                            .sound(Blocks.BASALT.getSoundType(Blocks.BASALT.defaultBlockState()))));

    public static final RegistryObject<Block> SLIGHTLY_COOLED_VOLCANIC_ROCK = registerBlock("slightly_cooled_volcanic_rock",
            () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                            .requiresCorrectToolForDrops()
                            .sound(Blocks.BASALT.getSoundType(Blocks.BASALT.defaultBlockState()))));

    public static final RegistryObject<Block> COOLER_VOLCANIC_ROCK = registerBlock("cooler_volcanic_rock",
            () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)
                            .requiresCorrectToolForDrops()
                            .sound(Blocks.BASALT.getSoundType(Blocks.BASALT.defaultBlockState()))));

    public static final RegistryObject<Block> COOLED_VOLCANIC_ROCK = registerBlock("cooled_volcanic_rock",
            () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED,
            BlockBehaviour.Properties.copy(Blocks.BASALT).requiresCorrectToolForDrops()));


    // FIRST WOOD

    public static final RegistryObject<Block> FIRST_LOG = registerBlock("first_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> STRIPPED_FIRST_LOG = registerBlock("stripped_first_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));

    public static final RegistryObject<Block> FIRST_WOOD = registerBlock("first_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final RegistryObject<Block> FIRST_SAPLING = registerBlock("first_sapling",
            () -> new SaplingBlock(new FirstTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> STRIPPED_FIRST_WOOD = registerBlock("stripped_first_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final RegistryObject<Block> FIRST_PLANKS = registerBlock("first_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> FIRST_LEAVES = registerBlock("first_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 50;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> CHIPPING_TABLE = registerBlock("chipping_table",
            () -> new ChippingTableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> FIRST_STAIRS = registerBlock("first_stairs",
            () -> new StairBlock(() -> ModBlocks.FIRST_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> FIRST_SLAB = registerBlock("first_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> FIRST_BUTTON = registerBlock("first_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 30, true));

    public static final RegistryObject<Block> FIRST_PRESSURE_PLATE = registerBlock("first_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> FIRST_FENCE = registerBlock("first_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> FIRST_FENCE_GATE = registerBlock("first_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> FIRST_DOOR = registerBlock("first_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> FIRST_TRAPDOOR = registerBlock("first_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> FIRST_SIGN = BLOCKS.register("first_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.FIRST));
    public static final RegistryObject<Block> FIRST_WALL_SIGN = BLOCKS.register("first_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.FIRST));

    public static final RegistryObject<Block> FIRST_HANGING_SIGN = BLOCKS.register("first_hanging_sign",
            () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), ModWoodTypes.FIRST));
    public static final RegistryObject<Block> FIRST_WALL_HANGING_SIGN = BLOCKS.register("first_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), ModWoodTypes.FIRST));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

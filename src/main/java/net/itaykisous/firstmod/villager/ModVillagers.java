package net.itaykisous.firstmod.villager;

import com.google.common.collect.ImmutableSet;
import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, FirstMod.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, FirstMod.MOD_ID);


    public static final RegistryObject<PoiType> CHIPPING_POI = POI_TYPES.register("chipping_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CHIPPING_TABLE.get().getStateDefinition().getPossibleStates()), 1, 5));

    public static final RegistryObject<VillagerProfession> CHIPPING_VILLAGER =
            VILLAGER_PROFESSION.register("chipping_villager",
                    () -> new VillagerProfession("chipping_villager", holder -> holder.get() == CHIPPING_POI.get(), holder -> holder.get() == CHIPPING_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

    public static void register (IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}

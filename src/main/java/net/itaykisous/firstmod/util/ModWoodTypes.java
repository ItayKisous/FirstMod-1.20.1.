package net.itaykisous.firstmod.util;

import net.itaykisous.firstmod.FirstMod;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType FIRST = WoodType.register(new WoodType(FirstMod.MOD_ID + ":first", BlockSetType.OAK));
}

package net.itaykisous.firstmod.entity.client;

import net.itaykisous.firstmod.FirstMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation FIRST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(FirstMod.MOD_ID, "boat/first"), "main");

    public static final ModelLayerLocation FIRST_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(FirstMod.MOD_ID, "chest_boat/first"), "main");
}

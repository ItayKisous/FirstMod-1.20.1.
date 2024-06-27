package net.itaykisous.firstmod.screen;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.itaykisous.firstmod.FirstMod;
import net.itaykisous.firstmod.screen.elements.ITooltipWidget;
import net.itaykisous.firstmod.screen.info.InfoArea;
import net.itaykisous.firstmod.util.ResettableLazy;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.itaykisous.firstmod.screen.info.EnergyInfoArea;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChippingTableScreen extends AbstractContainerScreen<ChippingTableMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(FirstMod.MOD_ID, "textures/gui/chipping_table_gui.png");

    private final ResettableLazy<List<InfoArea>> infoAreas;

    private EnergyInfoArea energyInfoArea;



    public ChippingTableScreen(ChippingTableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.infoAreas = new ResettableLazy<>(this::makeInfoAreas);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
        assignEnergyInfoArea();
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        energyInfoArea = new EnergyInfoArea(x + 156, y + 11, menu.blockEntity.getEnergyStorage());
    }

    @Nonnull
    protected List<InfoArea> makeInfoAreas() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        return ImmutableList.of(
                energyInfoArea
        );
    }


    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        for(InfoArea area : infoAreas.get())
            area.draw(guiGraphics);

        energyInfoArea.draw(guiGraphics);


        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 85, y + 30, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, title, titleLabelX, titleLabelY, 0xfff78034, true);
        pGuiGraphics.drawString(this.font, playerInventoryTitle, inventoryLabelX, inventoryLabelY, 0xfff78034, true);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);

        List<Component> tooltip = new ArrayList<>();
        for (InfoArea area : infoAreas.get())
            area.fillTooltip(mouseX, mouseY, tooltip);

        for (GuiEventListener w : children())
            if (w.isMouseOver(mouseX, mouseY) && w instanceof ITooltipWidget tww)
                tww.gatherTooltip(mouseX, mouseY, tooltip);
        if(!tooltip.isEmpty())
            guiGraphics.renderTooltip(font, tooltip, Optional.empty(), mouseX, mouseY);
        else
            this.renderTooltip(guiGraphics, mouseX, mouseY);;
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        for (GuiEventListener w : children())
            if (w.isMouseOver(pMouseX, pMouseY) && w instanceof ITooltipWidget tww)
                return true;
        return false;
    }

}

package com.ewyboy.terrifictransportation.Render.Renders;

import com.ewyboy.terrifictransportation.Blocks.Technical.MTBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class ConveyorRender implements ISimpleBlockRenderingHandler {

    private int renderID;

    public ConveyorRender() {
        renderID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);

        GL11.glPushMatrix();

        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0F, 1F, 0F);
        renderer.renderFaceYPos(block, 0, 0, 0, block.getIcon(1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
        tessellator.draw();

        GL11.glPopMatrix();
    }

    private void renderPlate(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Plate
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderPlateHollow(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        block.setBlockBounds(0.0F, 0.0F, 0.70F, 1.0F, 0.05F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 0.30F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        block.setBlockBounds(0.0F, 0.0F, 0.30F, 0.30F, 0.05F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        block.setBlockBounds(0.70F, 0.0F, 0.30F, 1.0F, 0.05F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderRail01(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Rail01
        block.setBlockBounds(0.0F, 0.05F, 0.0F, 0.05F, 0.15F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderRail02(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Rail02
        block.setBlockBounds(0.95F, 0.05F, 0.0F, 1.0F, 0.15F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderRail03(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Rail03
        block.setBlockBounds(0.0F, 0.05F, 0.0F, 1.0F, 0.15F, 0.05F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderRail04(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Rail04
        block.setBlockBounds(0.0F, 0.05F, 0.95F, 1.0F, 0.15F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderIPortFramePosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Top
        block.setBlockBounds(0.0F, 0.95F, 0.75F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar01
        block.setBlockBounds(0.0F, 0.15F, 0.75F, 0.05F, 0.95F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar02
        block.setBlockBounds(0.95F, 0.15F, 0.75F, 1.0F, 0.95F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderIPortFrameNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Top
        block.setBlockBounds(0.0F, 0.95F, 0.0F, 1.0F, 1.0F, 0.25F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar01
        block.setBlockBounds(0.0F, 0.15F, 0.0F, 0.05F, 0.95F, 0.25F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar02
        block.setBlockBounds(0.95F, 0.15F, 0.0F, 1.0F, 0.95F, 0.25F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderIPortFramePosX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Top
        block.setBlockBounds(0.75F, 0.95F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar01
        block.setBlockBounds(0.75F, 0.15F, 0.0F, 1.0F, 0.95F, 0.05F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar02
        block.setBlockBounds(0.75F, 0.15F, 0.95F, 1.0F, 0.95F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }
    private void renderIPortFrameNegX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Top
        block.setBlockBounds(0.0F, 0.95F, 0.0F, 0.25F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar01
        block.setBlockBounds(0.0F, 0.15F, 0.0F, 0.25F, 0.95F, 0.05F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //SideBar02
        block.setBlockBounds(0.0F, 0.15F, 0.95F, 0.25F, 0.95F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //RenderRails
        if (world.getBlock(x,y,z+1) == MTBlocks.Conveyor || !(world.getBlock(x,y,z-1) == MTBlocks.Conveyor)) {
            renderRail01(world, x, y, z, block, modelId, renderer);
            renderRail02(world, x, y, z, block, modelId, renderer);
        } else if (world.getBlock(x+1,y,z) == MTBlocks.Conveyor || world.getBlock(x-1,y,z) == MTBlocks.Conveyor) {
            renderRail03(world, x, y, z, block, modelId, renderer);
            renderRail04(world, x, y, z, block, modelId, renderer);
        } else {
            renderRail01(world, x, y, z, block, modelId, renderer);
            renderRail02(world, x, y, z, block, modelId, renderer);
            renderRail03(world, x, y, z, block, modelId, renderer);
            renderRail04(world, x, y, z, block, modelId, renderer);
        }

        //RenderBase
        if (world.getBlock(x,y-1,z) == Blocks.hopper) {
            renderPlateHollow(world, x, y, z, block, modelId, renderer);
        } else {
            renderPlate(world, x, y, z, block, modelId, renderer);
        }

        //RenderIPort
        if (world.getTileEntity(x+1,y,z) instanceof IInventory) {
            renderIPortFramePosX(world, x, y, z, block, modelId, renderer);
        }
        if (world.getTileEntity(x-1,y,z) instanceof IInventory) {
            renderIPortFrameNegX(world, x, y, z, block, modelId, renderer);
        }
        if (world.getTileEntity(x,y,z+1) instanceof IInventory) {
            renderIPortFramePosZ(world, x, y, z, block, modelId, renderer);
        }
        if (world.getTileEntity(x,y,z-1) instanceof IInventory) {
            renderIPortFrameNegZ(world, x, y, z, block, modelId, renderer);
        }
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return renderID;
    }
}

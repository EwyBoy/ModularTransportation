package com.ewyboy.terrifictransportation.Render.Renders;

import com.ewyboy.terrifictransportation.Blocks.Technical.MTBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class MonitorRender implements ISimpleBlockRenderingHandler {

    public MonitorRender() {
        renderID = RenderingRegistry.getNextAvailableRenderId();
    }

    private int renderID;

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

    private void renderBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        //Plate
        block.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.05F, 0.75F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //Foot
        block.setBlockBounds(0.35F, 0.0F, 0.45F, 0.45F, 0.5F, 0.55F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        //Screen
        block.setBlockBounds(0.45F, 0.20F, 0.0F, 0.55F, 0.85F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y, z);

        if (world.getBlock(x,y,z+1) == MTBlocks.PropertyInscriber) {
            //WireIn
            block.setBlockBounds(0.10F, 0.0F, 0.53F, 0.15F, 0.03F, 1.2F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);

        } else if (world.getBlock(x,y,z-1) == MTBlocks.PropertyInscriber) {
            //WireIn
            block.setBlockBounds(0.10F, 0.0F, -0.20F, 0.15F, 0.03F, 0.47F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);
        }

        if (world.getBlock(x,y,z+1) == MTBlocks.PropertyBinder || world.getBlock(x,y,z-1) == MTBlocks.PropertyBinder || world.getBlock(x,y,z-1) == MTBlocks.PropertyInscriber || world.getBlock(x,y,z+1) == MTBlocks.PropertyInscriber) {
            //WireOut
            block.setBlockBounds(0.10F, 0.0F, 0.47F, 0.25F, 0.03F, 0.53F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderBlock(world, x, y, z, block, modelId, renderer);

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

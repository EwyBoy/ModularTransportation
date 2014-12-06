package com.ewyboy.terrifictransportation.Render.Renders;

import com.ewyboy.terrifictransportation.Blocks.Technical.TTBlocks;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class PropertyBinderRender implements ISimpleBlockRenderingHandler {

    private int renderID;

    public PropertyBinderRender() {
        renderID = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);

        renderer.renderBlockAsItem(Blocks.redstone_torch, 1 , 1F);

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

    private void renderBlockXAxis(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        renderer.renderBlockAllFaces(Blocks.redstone_torch, x,y,z);

        //MainBox
        block.setBlockBounds(0.20F, 0.0F, 0.10F, 0.80F, 0.30F, 0.90F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Top Long01
        block.setBlockBounds(0.55F, 0.30F, 0.20F, 0.70F, 0.40F, 0.80F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Top Long02
        block.setBlockBounds(0.30F, 0.30F, 0.20F, 0.45F, 0.40F, 0.80F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Top Short01
        block.setBlockBounds(0.45F, 0.30F, 0.20F, 0.55F, 0.40F, 0.30F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Top Short02
        block.setBlockBounds(0.45F, 0.30F, 0.70F, 0.55F, 0.40F, 0.80F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //OutPut Plug
        block.setBlockBounds(0.05F, 0.0F, 0.40F, 0.20F, 0.10F, 0.60F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Front Panel
        block.setBlockBounds(0.80F, 0.0F, 0.30F, 0.95F, 0.05F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Front Panel Top
        block.setBlockBounds(0.80F, 0.20F, 0.30F, 0.85F, 0.25F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Front Panel Side01
        block.setBlockBounds(0.80F, 0.05F, 0.30F, 0.85F, 0.20F, 0.35F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        //Front Panel Side02
        block.setBlockBounds(0.80F, 0.05F, 0.65F, 0.85F, 0.20F, 0.70F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);

        if(world.getBlock(x,y,z+1) == TTBlocks.Monitor) {
            //WireIn
            block.setBlockBounds(0.10F, 0.0F, 0.47F, 0.15F, 0.03F, 1.47F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);
        } else if (world.getBlock(x,y,z-1) == TTBlocks.Monitor) {
            //WireIn
            block.setBlockBounds(0.10F, 0.0F, -0.47F, 0.15F, 0.03F, 0.53F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);
        }
        if (world.getBlock(x,y,z+1) == TTBlocks.PropertyInscriber) {
            //WireOut
            block.setBlockBounds(0.15F, 0.0F, 0.47F, 0.25F, 0.03F, 0.53F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);

        } else if (world.getBlock(x,y,z-1) == TTBlocks.PropertyInscriber) {
            //WireOut
            block.setBlockBounds(0.15F, 0.0F, 0.47F, 0.25F, 0.03F, 0.53F);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlock(block, x, y, z);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderBlockXAxis(world, x, y, z, block, modelId, renderer);
        return true;
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

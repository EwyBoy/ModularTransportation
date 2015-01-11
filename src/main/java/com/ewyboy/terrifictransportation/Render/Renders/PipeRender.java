package com.ewyboy.terrifictransportation.Render.Renders;

import com.ewyboy.terrifictransportation.Blocks.Technical.TTBlocks;
import com.ewyboy.terrifictransportation.Utillity.Handlers.Debugger;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class PipeRender implements ISimpleBlockRenderingHandler {

    private int renderID;

    public int ConnectionTrue = 1;

    public boolean canPipeConnect() {
        if(ConnectionTrue == 1) {
            return true;
        } else {
            return false;
        }
    }

    public PipeRender() {
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

    //Set the lighting stuff, so it changes it's brightness properly.
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
        Tessellator tess = Tessellator.instance;
        //float brightness = block.getBlockBrightness(world, i, j, k);
        //As of MC 1.7+ block.getBlockBrightness() has become block.getLightValue():
        float brightness = block.getLightValue(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
    }

    private void renderDefault(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        block.setBlockBounds(0.40F, 0.40F, 0.40F, 0.60F, 0.60F, 0.60F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderIPortPosX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.95F, 0.30F, 0.30F, 1.05F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x + 1, y, z) instanceof IInventory || world.getBlock(x+1,y,z) == TTBlocks.Router) {
                block.setBlockBounds(0.90F, 0.30F, 0.30F, 1.0F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderIPortNegX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(-0.05F, 0.30F, 0.30F, 0.05F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x - 1, y, z) instanceof IInventory || world.getBlock(x-1,y,z) == TTBlocks.Router) {
                block.setBlockBounds(0F, 0.30F, 0.30F, 0.10F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    private void renderIPortPosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.30F, 0.30F, 0.95F, 0.70F, 0.70F, 1.05F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getBlock(x,y,z+1) == TTBlocks.Router) {
                block.setBlockBounds(0.30F, 0.30F, 0.90F, 0.70F, 0.70F, 1F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderIPortNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.30F, 0.30F, -0.05F, 0.70F, 0.70F, 0.05F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z - 1) instanceof IInventory || world.getBlock(x,y,z-1) == TTBlocks.Router) {
                block.setBlockBounds(0.30F, 0.30F, 0.0F, 0.70F, 0.70F, 0.10F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    private void renderIPortPosY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getTileEntity(x, y + 1, z) instanceof IInventory || world.getBlock(x,y+1,z) == TTBlocks.Router) {
                block.setBlockBounds(0.30F, 0.90F, 0.30F, 0.70F, 1F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getBlock(x,y+1,z) instanceof BlockLiquid) {
                block.setBlockBounds(0.20F, 1.05F, 0.20F, 0.80F, 1.175F , 0.80F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);

                block.setBlockBounds(0.35F, 0.90F, 0.35F, 0.65F, 1.05F, 0.65F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderIPortNegY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y - 1, z) == net.minecraft.init.Blocks.chest || world.getBlock(x, y - 1, z) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.30F, -0.10F, 0.30F, 0.70F, 0F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x, y - 1, z) instanceof IInventory || world.getBlock(x,y-1,z) == TTBlocks.Router) {
                block.setBlockBounds(0.30F, 0F, 0.30F, 0.70F, 0.10F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getBlock(x,y-1,z) instanceof BlockLiquid) {
                block.setBlockBounds(0.35F, -0.05F, 0.35F, 0.65F, 0.10F, 0.65F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);

                block.setBlockBounds(0.20F, -0.175F, 0.20F, 0.80F, -0.05F, 0.80F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderArmPosX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.60F, 0.40F, 0.40F, 0.95F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x + 1, y, z) instanceof IInventory || world.getBlock(x+1,y,z) == TTBlocks.Router) {
                block.setBlockBounds(0.60F, 0.40F, 0.40F, 0.90F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else {
                block.setBlockBounds(0.60F, 0.40F, 0.40F, 1.0F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }
    private void renderArmNegX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.05F, 0.40F, 0.40F, 0.40F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x - 1, y, z) instanceof IInventory || world.getBlock(x-1,y,z) == TTBlocks.Router) {
                block.setBlockBounds(0.10F, 0.40F, 0.40F, 0.40F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else {
                block.setBlockBounds(0.0F, 0.40F, 0.40F, 0.40F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    private void renderArmPosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.40F, 0.40F, 0.60F, 0.60F, 0.60F, 0.95F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getBlock(x,y,z+1) == TTBlocks.Router) {
                block.setBlockBounds(0.40F, 0.40F, 0.60F, 0.60F, 0.60F, 0.90F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else {
                block.setBlockBounds(0.40F, 0.40F, 0.60F, 0.60F, 0.60F, 1.0F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }
    private void renderArmNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.trapped_chest) {
                block.setBlockBounds(0.40F, 0.40F, 0.05F, 0.60F, 0.60F, 0.40F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z - 1) instanceof IInventory || world.getBlock(x,y,z-1) == TTBlocks.Router) {
                block.setBlockBounds(0.40F, 0.40F, 0.10F, 0.60F, 0.60F, 0.40F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else {
                block.setBlockBounds(0.40F, 0.40F, 0.0F, 0.60F, 0.60F, 0.40F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }
    private void renderArmPosY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x,y+1,z) instanceof BlockLiquid || world.getBlock(x,y+1,z) == TTBlocks.Router) {
                block.setBlockBounds(0.40F, 0.60F, 0.40F, 0.60F, 1.0F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else {
                block.setBlockBounds(0.40F, 0.60F, 0.40F, 0.60F, 1.0F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }
    private void renderArmNegY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x,y-1,z) instanceof BlockLiquid || world.getBlock(x,y-1,z) == TTBlocks.Router) {
                block.setBlockBounds(0.40F, 0.0F, 0.40F, 0.60F, 0.40F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);

            } else {
                block.setBlockBounds(0.40F, 0.0F, 0.40F, 0.60F, 0.40F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (world.getBlock(x, y, z) == TTBlocks.Pipe) {
            renderDefault(world, x, y, z, block, modelId, renderer);

            if (world.getTileEntity(x + 1, y, z) instanceof IInventory || (world.getBlock(x + 1, y, z)) == TTBlocks.Pipe || (world.getBlock(x + 1, y, z)) == TTBlocks.PropertyInscriber || (world.getBlock(x + 1, y, z)) == TTBlocks.Router || (world.getBlock(x + 1,y,z) instanceof BlockLiquid)) {
                renderArmPosX(world, x, y, z, block, modelId, renderer);
                renderIPortPosX(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x - 1, y, z) instanceof IInventory || (world.getBlock(x - 1, y, z)) == TTBlocks.Pipe || (world.getBlock(x - 1, y, z)) == TTBlocks.Router || (world.getBlock(x - 1,y,z) instanceof BlockLiquid)) {
                renderArmNegX(world, x, y, z, block, modelId, renderer);
                renderIPortNegX(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z + 1)) == TTBlocks.Pipe || (world.getBlock(x, y, z + 1)) == TTBlocks.Router || (world.getBlock(x,y,z + 1) instanceof BlockLiquid)) {
                renderArmPosZ(world, x, y, z, block, modelId, renderer);
                renderIPortPosZ(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x, y, z - 1)) == TTBlocks.Pipe || (world.getBlock(x, y, z - 1)) == TTBlocks.Router || (world.getBlock(x,y,z - 1) instanceof BlockLiquid)) {
                renderArmNegZ(world, x, y, z, block, modelId, renderer);
                renderIPortNegZ(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y + 1, z) instanceof IInventory || (world.getBlock(x, y + 1, z)) == TTBlocks.Pipe || (world.getBlock(x, y + 1, z)) == TTBlocks.Router || (world.getBlock(x,y + 1,z) instanceof BlockLiquid)) {
                renderArmPosY(world, x, y, z, block, modelId, renderer);
                renderIPortPosY(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y - 1, z) instanceof IInventory || (world.getBlock(x, y - 1, z)) == TTBlocks.Pipe || (world.getBlock(x, y - 1, z)) == TTBlocks.Router || (world.getBlock(x,y - 1,z) instanceof BlockLiquid)) {
                renderArmNegY(world, x, y, z, block, modelId, renderer);
                renderIPortNegY(world, x, y, z, block, modelId, renderer);
            }
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

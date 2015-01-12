package com.ewyboy.terrifictransportation.Render.Renders;

import com.ewyboy.terrifictransportation.Blocks.Technical.MTBlocks;
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

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);

        GL11.glPopMatrix();
    }

    private void renderDefault(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        block.setBlockBounds(0.40F, 0.40F, 0.40F, 0.60F, 0.60F, 0.60F);
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderStandardBlock(block, x, y ,z);
    }

    private void renderIPortPosX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x + 1, y, z) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.95F, 0.30F, 0.30F, 1.05F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x + 1, y, z) instanceof IInventory || world.getBlock(x+1,y,z) == MTBlocks.Router) {
                block.setBlockBounds(0.90F, 0.30F, 0.30F, 1.0F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderIPortNegX(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x - 1, y, z) == MTBlocks.PropertyCube) {
                block.setBlockBounds(-0.05F, 0.30F, 0.30F, 0.05F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x - 1, y, z) instanceof IInventory || world.getBlock(x-1,y,z) == MTBlocks.Router) {
                block.setBlockBounds(0F, 0.30F, 0.30F, 0.10F, 0.70F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    private void renderIPortPosZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x, y, z + 1) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.30F, 0.30F, 0.95F, 0.70F, 0.70F, 1.05F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getBlock(x,y,z+1) == MTBlocks.Router) {
                block.setBlockBounds(0.30F, 0.30F, 0.90F, 0.70F, 0.70F, 1F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            }
        }
    }

    private void renderIPortNegZ(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x, y, z - 1) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.30F, 0.30F, -0.05F, 0.70F, 0.70F, 0.05F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z - 1) instanceof IInventory || world.getBlock(x,y,z-1) == MTBlocks.Router) {
                block.setBlockBounds(0.30F, 0.30F, 0.0F, 0.70F, 0.70F, 0.10F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            }
        }
    }

    private void renderIPortPosY(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        if (canPipeConnect() == true) {
            if (world.getTileEntity(x, y + 1, z) instanceof IInventory || world.getBlock(x,y+1,z) == MTBlocks.Router) {
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
            if (world.getBlock(x, y - 1, z) == net.minecraft.init.Blocks.chest || world.getBlock(x, y - 1, z) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x, y - 1, z) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.30F, -0.10F, 0.30F, 0.70F, 0F, 0.70F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y, z);
            } else if (world.getTileEntity(x, y - 1, z) instanceof IInventory || world.getBlock(x,y-1,z) == MTBlocks.Router) {
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
            if (world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x + 1, y, z) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x + 1, y, z) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.60F, 0.40F, 0.40F, 0.95F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x + 1, y, z) instanceof IInventory || world.getBlock(x+1,y,z) == MTBlocks.Router) {
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
            if (world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.chest || world.getBlock(x - 1, y, z) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x - 1, y, z) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.05F, 0.40F, 0.40F, 0.40F, 0.60F, 0.60F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x - 1, y, z) instanceof IInventory || world.getBlock(x-1,y,z) == MTBlocks.Router) {
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
            if (world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z + 1) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x, y, z + 1) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.40F, 0.40F, 0.60F, 0.60F, 0.60F, 0.95F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z + 1) instanceof IInventory || world.getBlock(x,y,z+1) == MTBlocks.Router) {
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
            if (world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.chest || world.getBlock(x, y, z - 1) == net.minecraft.init.Blocks.trapped_chest || world.getBlock(x, y, z - 1) == MTBlocks.PropertyCube) {
                block.setBlockBounds(0.40F, 0.40F, 0.05F, 0.60F, 0.60F, 0.40F);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlock(block, x, y ,z);
            } else if (world.getTileEntity(x, y, z - 1) instanceof IInventory || world.getBlock(x,y,z-1) == MTBlocks.Router) {
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
            if (world.getBlock(x,y+1,z) instanceof BlockLiquid || world.getBlock(x,y+1,z) == MTBlocks.Router) {
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
            if (world.getBlock(x,y-1,z) instanceof BlockLiquid || world.getBlock(x,y-1,z) == MTBlocks.Router) {
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
        if (world.getBlock(x, y, z) == MTBlocks.Pipe) {
            renderDefault(world, x, y, z, block, modelId, renderer);

            if (world.getTileEntity(x + 1, y, z) instanceof IInventory || (world.getBlock(x + 1, y, z)) == MTBlocks.Pipe || (world.getBlock(x + 1, y, z)) == MTBlocks.PropertyInscriber || (world.getBlock(x + 1, y, z)) == MTBlocks.Router  || (world.getBlock(x + 1, y, z)) == MTBlocks.PropertyCube || (world.getBlock(x + 1,y,z) instanceof BlockLiquid)) {
                renderArmPosX(world, x, y, z, block, modelId, renderer);
                renderIPortPosX(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x - 1, y, z) instanceof IInventory || (world.getBlock(x - 1, y, z)) == MTBlocks.Pipe || (world.getBlock(x - 1, y, z)) == MTBlocks.Router || (world.getBlock(x - 1, y, z)) == MTBlocks.PropertyCube  ||  (world.getBlock(x - 1,y,z) instanceof BlockLiquid)) {
                renderArmNegX(world, x, y, z, block, modelId, renderer);
                renderIPortNegX(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y, z + 1) instanceof IInventory || (world.getBlock(x, y, z + 1)) == MTBlocks.Pipe || (world.getBlock(x, y, z + 1)) == MTBlocks.Router || (world.getBlock(x, y, z + 1)) == MTBlocks.PropertyCube  ||  (world.getBlock(x,y,z + 1) instanceof BlockLiquid)) {
                renderArmPosZ(world, x, y, z, block, modelId, renderer);
                renderIPortPosZ(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y, z - 1) instanceof IInventory || (world.getBlock(x, y, z - 1)) == MTBlocks.Pipe || (world.getBlock(x, y, z - 1)) == MTBlocks.Router || (world.getBlock(x, y, z - 1)) == MTBlocks.PropertyCube  || (world.getBlock(x,y,z - 1) instanceof BlockLiquid)) {
                renderArmNegZ(world, x, y, z, block, modelId, renderer);
                renderIPortNegZ(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y + 1, z) instanceof IInventory || (world.getBlock(x, y + 1, z)) == MTBlocks.Pipe || (world.getBlock(x, y + 1, z)) == MTBlocks.Router || (world.getBlock(x, y + 1, z)) == MTBlocks.PropertyCube  || (world.getBlock(x,y + 1,z) instanceof BlockLiquid)) {
                renderArmPosY(world, x, y, z, block, modelId, renderer);
                renderIPortPosY(world, x, y, z, block, modelId, renderer);
            }
            if (world.getTileEntity(x, y - 1, z) instanceof IInventory || (world.getBlock(x, y - 1, z)) == MTBlocks.Pipe || (world.getBlock(x, y - 1, z)) == MTBlocks.Router || (world.getBlock(x, y - 1, z)) == MTBlocks.PropertyCube  || (world.getBlock(x,y - 1,z) instanceof BlockLiquid)) {
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

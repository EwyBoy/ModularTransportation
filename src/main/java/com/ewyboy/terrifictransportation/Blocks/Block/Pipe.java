package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.RenderIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Pipe extends Block {

    public Pipe() {
        super(Material.iron);
        setCreativeTab(TTCreativeTabs.TTBlockTab);
        setHardness(1F);
        setLightOpacity(0);
        setLightLevel(1F);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

        setBlockBounds(0.40F, 0.40F, 0.40F, 0.60F, 0.60F, 0.60F);

        if (world.getBlock(x+1,y,z) == this) {
            setBlockBounds(0.40F, 0.40F, 0.40F, 1.0F, 0.60F, 0.60F);
        }
        if (world.getBlock(x-1,y,z) == this) {
            setBlockBounds(0.0F, 0.40F, 0.40F, 0.60F, 0.60F, 0.60F);
        }
        if (world.getBlock(x,y,z+1) == this) {
            setBlockBounds(0.40F, 0.40F, 0.40F, 0.60F, 0.60F, 1.0F);
        }
        if (world.getBlock(x,y,z-1) == this) {
            setBlockBounds(0.40F, 0.40F, 0.0F, 0.60F, 0.60F, 0.60F);
        }
        if (world.getBlock(x,y+1,z) == this) {
            setBlockBounds(0.40F, 0.40F, 0.40F, 0.60F, 1.0F, 0.60F);
        }
        if (world.getBlock(x,y-1,z) == this) {
            setBlockBounds(0.40F, 0.0F, 0.40F, 0.60F, 0.60F, 0.60F);
        }
        if (world.getBlock(x-1,y,z) == this && world.getBlock(x+1,y,z) == this) {
            setBlockBounds(0.0F, 0.40F, 0.40F, 1.0F, 0.60F, 0.60F);
        }
        if (world.getBlock(x,y,z+1) == this && world.getBlock(x,y,z-1) == this) {
            setBlockBounds(0.40F, 0.40F, 0.0F, 0.60F, 0.60F, 1.0F);
        }
        if (world.getBlock(x,y+1,z) == this && world.getBlock(x,y-1,z) == this) {
            setBlockBounds(0.40F, 0.0F, 0.40F, 0.60F, 1.0F, 0.60F);
        }
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, start, end);
    }

    @Override
    public int getRenderType() {
        return RenderIDs.PipeRenderID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.iron_block.getBlockTextureFromSide(1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess iBlockAccess, int x, int y, int z, int i) {
        return true;
    }
}

package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.MTCreativeTabs;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.RenderIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Router extends BlockContainer {

    public Router() {
        super(Material.iron);
        setCreativeTab(MTCreativeTabs.TTBlockTab);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        setBlockBounds(0.20F, 0F, 0.20F, 0.80F, 0.80F, 0.80F);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.20F, 0F, 0.20F, 0.80F, 0.80F, 0.80F);
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
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.iron_block.getBlockTextureFromSide(1);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return RenderIDs.RouterRenderID;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int unknown) {
        return null;
    }
}

package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.MTCreativeTabs;
import com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PropertyCube extends BlockContainer {

    public PropertyCube() {
        super(Material.iron);
        setCreativeTab(MTCreativeTabs.TTBlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new PropertyCubeTile();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        setBlockBounds(0.10F, 0F, 0.10F, 0.90F, 0.85F, 0.90F);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.10F, 0F, 0.10F, 0.90F, 0.80F, 0.80F);
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

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
        return false;
    }
}
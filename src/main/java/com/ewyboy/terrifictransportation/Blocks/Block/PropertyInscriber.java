package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.RenderIDs;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PropertyInscriber extends Block {

    public PropertyInscriber() {
        super(Material.iron);
        setCreativeTab(TTCreativeTabs.TTBlockTab);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        setBlockBounds(0.0F, 0.0F, 0.20F, 0.95F, 0.80F, 0.80F);
    }

    @Override
    public void setBlockBoundsForItemRender() {
        setBlockBounds(0.0F, 0.0F, 0.20F, 0.95F, 0.80F, 0.80F);
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
        return RenderIDs.PropertyInscriberID;
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        Texture = register.registerIcon(TexturePath.texturePath + ":" + "DesktopFrontOffEmptyBoth");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 5) {
            return Texture;
        } else {
            return Blocks.iron_block.getBlockTextureFromSide(1);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isBlockSolid(IBlockAccess iBlockAccess, int x, int y, int z, int i) {
        return true;
    }
}

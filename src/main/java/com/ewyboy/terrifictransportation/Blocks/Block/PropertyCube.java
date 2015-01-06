package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PropertyCube extends BlockContainer {

    public PropertyCube() {
        super(Material.iron);
        setCreativeTab(TTCreativeTabs.TTBlockTab);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new PropertyCubeTile();
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return Blocks.iron_block.getBlockTextureFromSide(1);
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
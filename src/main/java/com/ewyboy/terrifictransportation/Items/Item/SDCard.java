package com.ewyboy.terrifictransportation.Items.Item;

import com.ewyboy.terrifictransportation.CreativeTabs.MTCreativeTabs;
import com.ewyboy.terrifictransportation.Items.Technical.ItemInfo;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class SDCard extends Item {

    public SDCard() {
        super();
        setCreativeTab(MTCreativeTabs.TTItemTab);
        setMaxStackSize(64);
    }

    @SideOnly(Side.CLIENT)
    private IIcon Texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        Texture = register.registerIcon(TexturePath.texturePath + ":" + ItemInfo.SDCard);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int unknown) {
        return Texture;
    }
}

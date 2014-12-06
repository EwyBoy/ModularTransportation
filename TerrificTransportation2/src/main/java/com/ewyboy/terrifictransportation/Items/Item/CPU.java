package com.ewyboy.terrifictransportation.Items.Item;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.ewyboy.terrifictransportation.Items.Technical.ItemInfo;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class CPU extends Item {

    public CPU() {
        super();
        setCreativeTab(TTCreativeTabs.TTItemTab);
        setMaxStackSize(64);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return ItemInfo.CPUUnlocalized;
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] Texture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {

        Texture = new IIcon [ItemInfo.CPU.length];
        for (int i = 0; i < Texture.length; i++) {
            Texture [i] = register.registerIcon(TexturePath.texturePath + ":" + ItemInfo.CPU[i]);
        }
    }

    @Override
    @SideOnly (Side.CLIENT)
    public IIcon getIconFromDamage (int dmg) {
        return Texture [dmg];
    }

    @SideOnly (Side.CLIENT)
    public void getSubItems ( Item id, CreativeTabs tab, List list) {
        for (int i = 0; i < ItemInfo.CPU.length; i ++) {
            ItemStack stack = new ItemStack (id, 1, i);
            list.add(stack);
        }
    }
}

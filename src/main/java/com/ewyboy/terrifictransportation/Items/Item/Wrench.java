package com.ewyboy.terrifictransportation.Items.Item;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class Wrench extends Item {

    public Wrench() {
        super();
        setMaxStackSize(1);
        setCreativeTab(TTCreativeTabs.TTItemTab);
    }

    private int ModeDeactivated = 0;
    private int ModeRotate = 1;
    private int ModeInteraction = 2;

    public String getWrenchType(ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        return item.getTagCompound().getString("wrenchType");
    }

    public int getWrenchTypeID(ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        return item.getTagCompound().getInteger("wrenchTypeID");
    }

    public void setWrenchType(String type, ItemStack item){
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        item.getTagCompound().setString("wrenchType", type);
    }

    private void setWrenchTypeID(int type, ItemStack item) {
        if(item.getTagCompound() == null){
            item.setTagCompound(new NBTTagCompound());
        }
        item.getTagCompound().setInteger("wrenchTypeID", type);
        this.setDamage(item, type);
    }

    private void playSoundEffect(World world, EntityPlayer player) {
        world.playSound(player.posX, player.posY, player.posZ, "tile.piston.in", 0.5F, 0.4F + 0.8F, false);
    }

    public void changeWrench(World world, EntityPlayer player, ItemStack item) {
        if(getWrenchTypeID(item) == 0) {
            setWrenchType("§2Rotation Mode", item);
            setWrenchTypeID(ModeRotate, item);
            playSoundEffect(world, player);
        } else if (getWrenchTypeID(item) == 1) {
            setWrenchType("§3Interaction Mode", item);
            setWrenchTypeID(ModeInteraction, item);
            playSoundEffect(world, player);

        }else if (getWrenchTypeID(item) == 2) {
            setWrenchType("§7Deactivated", item);
            setWrenchTypeID(ModeDeactivated, item);
            playSoundEffect(world, player);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
        if (item == null) {
        } else if (player.isSneaking() == true) {
            changeWrench(world, player, item);
        }
        return item;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation) {
        info.add("Wrench Mode: " + getWrenchType(stack));
    }

    @SideOnly(Side.CLIENT)
    private IIcon WrenchActivated01;
    private IIcon WrenchActivated02;
    private IIcon WrenchDeactivated;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        WrenchActivated01 = register.registerIcon(TexturePath.texturePath + ":" + "Wrench01");
        WrenchActivated02 = register.registerIcon(TexturePath.texturePath + ":" + "Wrench02");
        WrenchDeactivated = register.registerIcon(TexturePath.texturePath + ":" + "Wrench03");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int idk) {

        if(idk == ModeRotate) {
            return WrenchActivated01;
        } else if (idk == ModeInteraction) {
            return WrenchActivated02;
        }
        return WrenchDeactivated;
    }
}
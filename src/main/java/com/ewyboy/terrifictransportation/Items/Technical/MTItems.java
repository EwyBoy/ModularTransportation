package com.ewyboy.terrifictransportation.Items.Technical;

import com.ewyboy.terrifictransportation.Items.Item.CPU;
import com.ewyboy.terrifictransportation.Items.Item.HardDrive;
import com.ewyboy.terrifictransportation.Items.Item.SDCard;
import com.ewyboy.terrifictransportation.Items.Item.Wrench;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MTItems {

    public static Item Wrench;
    public static Item CPU;
    public static Item SDCard;
    public static Item HardDrive;

    public static void init() {
        registerItems();
    }

    public static void registerItems() {

        Wrench = new Wrench().setUnlocalizedName(ItemInfo.Wrench);
        GameRegistry.registerItem(Wrench, ItemInfo.Wrench);

        CPU = new CPU().setUnlocalizedName(ItemInfo.CPUUnlocalized);
        GameRegistry.registerItem(CPU, ItemInfo.CPUUnlocalized);

        SDCard = new SDCard().setUnlocalizedName(ItemInfo.SDCard);
        GameRegistry.registerItem(SDCard, ItemInfo.SDCard);

        HardDrive = new HardDrive().setUnlocalizedName(ItemInfo.HardDriveUnlocalized);
        GameRegistry.registerItem(HardDrive, ItemInfo.HardDriveUnlocalized);
    }
}


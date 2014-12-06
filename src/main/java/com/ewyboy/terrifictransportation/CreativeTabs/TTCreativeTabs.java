package com.ewyboy.terrifictransportation.CreativeTabs;

import com.ewyboy.terrifictransportation.Blocks.Technical.TTBlocks;
import com.ewyboy.terrifictransportation.Items.Technical.TTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TTCreativeTabs {

    public static void init() {
        addCreativeTabs();
    }

    public static void addCreativeTabs() {}

        public static CreativeTabs TTBlockTab = new CreativeTabs("TerrificTransportation Blocks") {
            public ItemStack getIconItemStack() {
                return new ItemStack(TTBlocks.Pipe);
            }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
            public static CreativeTabs TTItemTab = new CreativeTabs("TerrificTransportation Items") {
                public ItemStack getIconItemStack() {
                    return new ItemStack(TTItems.Wrench);
                }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
}

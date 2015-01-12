package com.ewyboy.terrifictransportation.CreativeTabs;

import com.ewyboy.terrifictransportation.Blocks.Technical.MTBlocks;
import com.ewyboy.terrifictransportation.Items.Technical.MTItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MTCreativeTabs {

    public static void init() {
        addCreativeTabs();
    }

    public static void addCreativeTabs() {}

        public static CreativeTabs TTBlockTab = new CreativeTabs("Modular Transportation Blocks") {
            public ItemStack getIconItemStack() {
                return new ItemStack(MTBlocks.Pipe);
            }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
            public static CreativeTabs TTItemTab = new CreativeTabs("Modular Transportation Items") {
                public ItemStack getIconItemStack() {
                    return new ItemStack(MTItems.Wrench);
                }
            @Override
            public Item getTabIconItem() {
                return null;
            }
        };
}

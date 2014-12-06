package com.ewyboy.terrifictransportation.Blocks.Block;

import com.ewyboy.terrifictransportation.CreativeTabs.TTCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AdaptationCube extends Block {

    public AdaptationCube() {
        super(Material.iron);
        setCreativeTab(TTCreativeTabs.TTBlockTab);
    }
}

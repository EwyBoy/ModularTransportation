package com.ewyboy.terrifictransportation.Blocks.Technical;

import com.ewyboy.terrifictransportation.Blocks.Block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class TTBlocks {

    public static Block Pipe;
    public static Block Conveyor;
    public static Block PropertyInscriber;
    public static Block PropertyBinder;
    public static Block Monitor;
    public static Block PropertyCube;
    public static Block Router;

    public static void init() {
        registerBlocks();
    }

    public static void registerBlocks() {
        Pipe = new Pipe().setBlockName(BlockInfo.Pipe);
        GameRegistry.registerBlock(Pipe, BlockInfo.Pipe);

        Conveyor = new Conveyor().setBlockName(BlockInfo.Conveyor);
        GameRegistry.registerBlock(Conveyor, BlockInfo.Conveyor);

        PropertyInscriber = new PropertyInscriber().setBlockName(BlockInfo.PropertyInscriber);
        GameRegistry.registerBlock(PropertyInscriber, BlockInfo.PropertyInscriber);

        PropertyBinder = new PropertyBinder().setBlockName(BlockInfo.PropertyBinder);
        GameRegistry.registerBlock(PropertyBinder, BlockInfo.PropertyBinder);

        PropertyCube = new PropertyCube().setBlockName(BlockInfo.PropertyCube);
        GameRegistry.registerBlock(PropertyCube,BlockInfo.PropertyCube);

        Monitor = new Monitor().setBlockName(BlockInfo.Monitor);
        GameRegistry.registerBlock(Monitor,BlockInfo.Monitor);

        Router = new Router().setBlockName(BlockInfo.Router);
        GameRegistry.registerBlock(Router, BlockInfo.Router);
    }
}
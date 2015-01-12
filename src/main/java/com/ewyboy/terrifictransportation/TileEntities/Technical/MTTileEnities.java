package com.ewyboy.terrifictransportation.TileEntities.Technical;

import com.ewyboy.terrifictransportation.TileEntities.TileEntity.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class MTTileEnities {

    public static void Init() {
        registerTileEntities();
    }

    public static TileEntity Pipe;
    public static TileEntity Conveyor;
    public static TileEntity PropertyInscriber;
    public static TileEntity PropertyBinder;
    public static TileEntity Monitor;
    public static TileEntity PropertyCube;
    public static TileEntity Router;

    public static void registerTileEntities() {
        Pipe = new PipeTile();
        GameRegistry.registerTileEntity(PipeTile.class, TileEntityInfo.PipeTile);

        Conveyor = new ConveyorTile();
        GameRegistry.registerTileEntity(ConveyorTile.class, TileEntityInfo.ConveyorTile);

        Monitor = new MonitorTile();
        GameRegistry.registerTileEntity(MonitorTile.class, TileEntityInfo.MonitorTile);

        Router = new RouterTile();
        GameRegistry.registerTileEntity(RouterTile.class, TileEntityInfo.RouterTile);

        PropertyCube = new PropertyCubeTile();
        GameRegistry.registerTileEntity(PropertyCubeTile.class, TileEntityInfo.PropertyCubeTile);

        PropertyInscriber = new PropertyInscriberTile();
        GameRegistry.registerTileEntity(PropertyInscriberTile.class, TileEntityInfo.PropertyInscriberTile);

        PropertyBinder = new PropertyBinderTile();
        GameRegistry.registerTileEntity(PropertyBinderTile.class, TileEntityInfo.PropertyBinderTile);
    }
}
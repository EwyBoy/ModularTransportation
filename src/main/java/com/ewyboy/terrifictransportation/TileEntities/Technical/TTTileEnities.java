package com.ewyboy.terrifictransportation.TileEntities.Technical;

import com.ewyboy.terrifictransportation.Blocks.Technical.BlockInfo;
import com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TTTileEnities {

    public static void Init() {
        registerTileEntities();
    }

    public static com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile PropertyCubeTile;

    public static void registerTileEntities() {
        PropertyCubeTile = new com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile();
        GameRegistry.registerTileEntity(com.ewyboy.terrifictransportation.TileEntities.TileEntity.PropertyCubeTile.class, "PropertyCube");
    }
}

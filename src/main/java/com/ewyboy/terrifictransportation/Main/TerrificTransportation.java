package com.ewyboy.terrifictransportation.Main;

import com.ewyboy.terrifictransportation.Blocks.Technical.MTBlocks;
import com.ewyboy.terrifictransportation.CreativeTabs.MTCreativeTabs;
import com.ewyboy.terrifictransportation.Items.Technical.MTItems;
import com.ewyboy.terrifictransportation.Network.Proxies.CommonProxy;
import com.ewyboy.terrifictransportation.Recipes.CraftingRecipes;
import com.ewyboy.terrifictransportation.TileEntities.Technical.MTTileEnities;
import com.ewyboy.terrifictransportation.Utillity.Handlers.ConfigHandler;
import com.ewyboy.terrifictransportation.Utillity.Handlers.Debugger;
import com.ewyboy.terrifictransportation.Utillity.Handlers.KeyInputHandler;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.ModInfo;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ModID, name = ModInfo.ModName, version = ModInfo.ModVersion)

public class TerrificTransportation {

    @Mod.Instance(ModInfo.ModID)
    public static TerrificTransportation instance;

    @SidedProxy(modId = ModInfo.ModID, clientSide = "com.ewyboy.terrifictransportation.Network.Proxies.ClientProxy", serverSide = "com.ewyboy.terrifictransportation.Network.Proxies.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void PreInit (FMLPreInitializationEvent event) {
        MTBlocks.init();
        MTItems.init();
        //MTTileEnities.init();
        MTCreativeTabs.init();
        MTTileEnities.registerTileEntities();
        proxy.initRenders();
        Debugger.info("Pre Initialization Complete!");
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        proxy.registerKeyBindings();
        Debugger.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void load (FMLInitializationEvent event) {
        CraftingRecipes.init();
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        Debugger.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void ModsLoaded (FMLPostInitializationEvent event){
        Debugger.info("Post Initialization Complete!");
    }
}


package com.ewyboy.terrifictransportation.GUIs;

import com.ewyboy.terrifictransportation.Utillity.Handlers.ConfigHandler;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.ModInfo;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class MTGUIConfig extends GuiConfig {

    public MTGUIConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                ModInfo.ModID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
    }
}

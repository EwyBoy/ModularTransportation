package com.ewyboy.terrifictransportation.Network.Proxies;

import com.ewyboy.terrifictransportation.KeyBindings.KeyBindings;
import com.ewyboy.terrifictransportation.Render.Renders.*;
import com.ewyboy.terrifictransportation.Utillity.StringMaps.RenderIDs;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(KeyBindings.charge);
        ClientRegistry.registerKeyBinding(KeyBindings.release);
    }

    public void initRenders() {
        PipeRender pipeRender = new PipeRender();
        RenderingRegistry.registerBlockHandler(pipeRender);
        RenderIDs.PipeRenderID = pipeRender.getRenderId();

        PropertyInscriberRender propertyInscriberRender = new PropertyInscriberRender();
        RenderingRegistry.registerBlockHandler(propertyInscriberRender);
        RenderIDs.PropertyInscriberID = propertyInscriberRender.getRenderId();

        PropertyBinderRender propertyBinderRender = new PropertyBinderRender();
        RenderingRegistry.registerBlockHandler(propertyBinderRender);
        RenderIDs.PropertyBinderRenderID = propertyBinderRender.getRenderId();

        PropertyCubeRender propertyCubeRender = new PropertyCubeRender();
        RenderingRegistry.registerBlockHandler(propertyCubeRender);
        RenderIDs.PropertyCubeRenderID = propertyCubeRender.getRenderId();

        MonitorRender monitorRender = new MonitorRender();
        RenderingRegistry.registerBlockHandler(monitorRender);
        RenderIDs.MonitorRenderID = monitorRender.getRenderId();

        RouterRender routerRender = new RouterRender();
        RenderingRegistry.registerBlockHandler(routerRender);
        RenderIDs.RouterRenderID = routerRender.getRenderId();

        ConveyorRender conveyorRender = new ConveyorRender();
        RenderingRegistry.registerBlockHandler(conveyorRender);
        RenderIDs.ConveyorRenderID = conveyorRender.getRenderId();
    }
}

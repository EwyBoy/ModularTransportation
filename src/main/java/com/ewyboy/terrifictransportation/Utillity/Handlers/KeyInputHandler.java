package com.ewyboy.terrifictransportation.Utillity.Handlers;

import com.ewyboy.terrifictransportation.KeyBindings.Key;
import com.ewyboy.terrifictransportation.KeyBindings.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler
{
    private static Key getPressedKeybinding()
    {
        if (KeyBindings.charge.isPressed())
        {
            return Key.CHARGE;
        }
        else if (KeyBindings.release.isPressed())
        {
            return Key.RELEASE;
        }

        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Debugger.info(getPressedKeybinding());
    }
}

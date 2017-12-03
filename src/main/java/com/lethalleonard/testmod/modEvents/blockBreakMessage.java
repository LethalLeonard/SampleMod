package com.lethalleonard.testmod.modEvents;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class blockBreakMessage
{
    @SubscribeEvent
    public void sendMessage(BreakEvent event)
    {
        event.getPlayer()
                .sendMessage(new TextComponentString(
                        ChatFormatting.GOLD + "You broke a block!"));
    }
}

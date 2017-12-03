package com.lethalleonard.testmod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class clientProxy extends commonProxy
{
    public static void init(FMLInitializationEvent event)
    {

    }
}

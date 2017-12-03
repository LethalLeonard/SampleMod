package com.lethalleonard.testmod.proxy;

import com.lethalleonard.testmod.Utils.registerUtil;
import com.lethalleonard.testmod.modEvents.blockBreakMessage;
import com.lethalleonard.testmod.modEvents.chargedCreeper;
import com.lethalleonard.testmod.modEvents.minecartEntityExplode;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class commonProxy
{
    public static void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new registerUtil());
    }

    public static void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new blockBreakMessage());
        MinecraftForge.EVENT_BUS.register(new minecartEntityExplode());
        //MinecraftForge.EVENT_BUS.register(new creeperMultiply());
        MinecraftForge.EVENT_BUS.register(new chargedCreeper());
    }

    public static void postInit(FMLPostInitializationEvent event)
    {

    }
}

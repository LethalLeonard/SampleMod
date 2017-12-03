package com.lethalleonard.testmod;

import com.lethalleonard.testmod.Utils.LogHelper;
import com.lethalleonard.testmod.proxy.commonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String VERSION = "0.1a";
    public static final String CLIENT_PROXY = "com.lethalleonard.testmod.proxy.clientProxy";
    public static final String COMMON_PROXY = "com.lethalleonard.testmod.proxy.commonProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static commonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.logInfo("Starting Pre-Initialization...");
        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.logInfo("Starting Initialization...");

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.logInfo("Starting Post-Initialization...");
        proxy.postInit(event);
    }
}

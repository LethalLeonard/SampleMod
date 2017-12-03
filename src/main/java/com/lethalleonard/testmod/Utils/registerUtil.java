package com.lethalleonard.testmod.Utils;

import com.lethalleonard.testmod.modInit.BlockInit;
import com.lethalleonard.testmod.modInit.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class registerUtil
{

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        BlockInit.prepareBlocks();
        BlockInit.registerBlocks(event);
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        ItemInit.prepareItems();
        ItemInit.registerItems(event);
    }
}

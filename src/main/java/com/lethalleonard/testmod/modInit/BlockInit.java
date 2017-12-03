package com.lethalleonard.testmod.modInit;

import com.lethalleonard.testmod.Utils.LogHelper;
import com.lethalleonard.testmod.blocks.blockEnderBlock;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;

public class BlockInit
{
    public static blockEnderBlock enderBlock;
    public static ArrayList<Block> blockList = new ArrayList<>();

    public static void prepareBlocks()
    {
        LogHelper.logInfo("Starting block prep...");

        enderBlock = new blockEnderBlock();
        initBlock(enderBlock);

        LogHelper.logInfo("Finished block prep.");
    }

    public static void initBlock(Block block)
    {
        blockList.add(block);
        ItemInit.addItemBlockToItems(block);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        LogHelper.logInfo("Starting block registration...");

        for(Block block : blockList)
        {
            LogHelper.logInfo(String.format("Registering block %s...", block.getUnlocalizedName()));
            event.getRegistry().register(block);
        }

        LogHelper.logInfo("Finished block registration.");
    }
}

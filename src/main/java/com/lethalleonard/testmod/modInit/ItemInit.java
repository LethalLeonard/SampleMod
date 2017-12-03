package com.lethalleonard.testmod.modInit;

import com.lethalleonard.testmod.TestMod;
import com.lethalleonard.testmod.Utils.LogHelper;
import com.lethalleonard.testmod.items.itemEnderIngot;
import com.lethalleonard.testmod.items.testModItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;

public class ItemInit
{
    public static ArrayList<Item> itemList = new ArrayList<>();
    public static testModItem enderIngot;

    public static void prepareItems()
    {
        enderIngot = new itemEnderIngot();
        itemList.add(enderIngot);
    }

    public static void addItemBlockToItems(Block block)
    {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        itemList.add(itemBlock);
    }

    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : itemList)
        {
            LogHelper.logInfo("Starting item registration...");
            event.getRegistry().register(item);
            LogHelper.logInfo("Registering item: " + item.getUnlocalizedName().substring(5));
            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    new ModelResourceLocation(item.getUnlocalizedName().substring(5)));
            LogHelper.logInfo("Finished registering " + item.getUnlocalizedName() + "...");
        }

        LogHelper.logInfo("Finished registering items.");
    }
}

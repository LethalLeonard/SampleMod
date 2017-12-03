package com.lethalleonard.testmod.items;

import com.lethalleonard.testmod.TestMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class testModItem extends Item
{
    public testModItem()
    {
        super();
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }

    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        return super.setUnlocalizedName(TestMod.MODID + ":" + unlocalizedName);
    }
}

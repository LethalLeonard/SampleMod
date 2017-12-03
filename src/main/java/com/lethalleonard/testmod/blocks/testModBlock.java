package com.lethalleonard.testmod.blocks;

import com.lethalleonard.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class testModBlock extends Block
{
    public static String blockName;

    public testModBlock()
    {
        super(Material.IRON);
    }

    @Override
    public Block setUnlocalizedName(String name) {
        return super.setUnlocalizedName(TestMod.MODID + ":" + name);
    }
}

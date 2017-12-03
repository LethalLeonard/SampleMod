package com.lethalleonard.testmod.items;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class itemEnderIngot extends testModItem
{
    public itemEnderIngot()
    {
        super();
        this.setUnlocalizedName("enderingot");
        this.setRegistryName("enderingot");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        EntityEnderman enderman = new EntityEnderman(worldIn);

        enderman.setLocationAndAngles(
                playerIn.posX,
                playerIn.posY,
                playerIn.posZ,
                0,0);

        if(!worldIn.isRemote)
            worldIn.spawnEntity(enderman);

        ItemStack stack = playerIn.getHeldItem(handIn);

        if(!playerIn.capabilities.isCreativeMode)
            stack.setCount(stack.getCount()-1);

        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}

package com.lethalleonard.testmod.blocks;

import com.lethalleonard.testmod.modInit.ItemInit;
import com.mojang.realmsclient.gui.ChatFormatting;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class blockEnderBlock extends testModBlock {
    public blockEnderBlock() {
        this.setUnlocalizedName("enderblock");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setResistance(5.0f);
        this.setHardness(10.0f);
        this.setLightLevel(1.0f);
        this.setRegistryName("enderblock");
    }

    /*@Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        IBlockState block = worldIn.getBlockState(pos.add(0,-1,0));
        worldIn.setBlockState(pos,block);
        EntityLightningBolt lightning = new EntityLightningBolt(
                worldIn,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                true);
    }*/

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote)
            return false;
        playerIn.sendMessage(new TextComponentString(
                ChatFormatting.DARK_PURPLE
                        + "You have clicked on the majestic ENDERIUM BLOCK!!!!!"));
        EntityEnderEye eye = new EntityEnderEye(worldIn,
                pos.getX() + 0.5,
                pos.getY() + 1.5,
                pos.getZ() + 0.5);
        eye.motionY = 0.1;
        worldIn.spawnEntity(eye);
        return true;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemInit.enderIngot;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return random.nextInt(3)+3;
    }
}
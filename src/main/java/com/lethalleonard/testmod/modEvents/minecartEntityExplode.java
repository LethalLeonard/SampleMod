package com.lethalleonard.testmod.modEvents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class minecartEntityExplode
{

    @SubscribeEvent
    public void explosion(MinecartCollisionEvent event)
    {
        EntityMinecart minecart = event.getMinecart();
        if(!(event.getCollider() instanceof EntityPlayer))
        {
            minecart.world.createExplosion(
                    minecart,
                    minecart.posX,
                    minecart.posY,
                    minecart.posZ,
                    2,
                    false
            );
        }
    }

    @SubscribeEvent
    public void explosion(LivingHurtEvent event)
    {
        if(event.getSource() != DamageSource.ANVIL)
            return;

        Entity entity = event.getEntity();
        entity.world.createExplosion(
                entity,
                entity.posX,
                entity.posY,
                entity.posZ,
                2,
                false
        );
    }
}

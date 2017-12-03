package com.lethalleonard.testmod.modEvents;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class chargedCreeper{

    @SubscribeEvent
    public void flintChargeCreeper(LivingHurtEvent event)
    {
        if(!(event.getEntity() instanceof EntityCreeper))
        {
            return;
        }
        EntityCreeper entity = (EntityCreeper)event.getEntity();

        if(entity.isBurning() && !entity.getPowered())
        {
            EntityLightningBolt bolt = new EntityLightningBolt(entity.world, entity.posX, entity.posY+1, entity.posZ, false);
            bolt.setFire(0);
            entity.world.spawnEntity(bolt);
            entity.world.setBlockToAir(entity.getPosition());
        }

        if(entity.isBurning() && entity.getPowered())
            entity.extinguish();
    }

}

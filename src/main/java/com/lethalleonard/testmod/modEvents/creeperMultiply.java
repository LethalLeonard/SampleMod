package com.lethalleonard.testmod.modEvents;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class creeperMultiply
{
    @SubscribeEvent
    public void moreCreepers(LivingDeathEvent event)
    {
        if(!(event.getEntity() instanceof EntityCreeper))
            return;

        Entity entity = event.getEntity();

        for(int i = 0; i < 5; i++)
        {
            EntityCreeper creeper = new EntityCreeper(entity.world);
            creeper.setLocationAndAngles(
                    entity.posX,
                    entity.posY,
                    entity.posZ,
                    0,0
            );

            if(!entity.world.isRemote)
                entity.world.spawnEntity(creeper);
        }
    }
}

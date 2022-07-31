package de.cas_ual_ty.yeet;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(YEETemPotions.MODID)
public class YEETemPotions
{
    public static final String MODID = "yeetem_potions";
    
    public YEETemPotions()
    {
        MinecraftForge.EVENT_BUS.addListener(this::yeet);
    }
    
    private void yeet(EntityJoinWorldEvent event)
    {
        if(event.getEntity() instanceof ThrownPotion potion && potion.getOwner() instanceof Player)
        {
            Vec3 dir = potion.getOwner().getLookAngle();
            potion.shoot(dir.x, dir.y, dir.z, 1.5F, 0F);
        }
    }
}

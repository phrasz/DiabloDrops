package com.modcrafting.diablodrops.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.modcrafting.diablodrops.DiabloDrops;
import com.modcrafting.diablodrops.effects.EffectsAPI;
import com.modcrafting.diablolibrary.events.DiabloMonsterDamageByEntityEvent;
import com.modcrafting.diablolibrary.events.DiabloMonsterDamageEvent;

public class EffectsListener implements Listener
{
    DiabloDrops plugin;

    public EffectsListener(final DiabloDrops instance)
    {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDiabloMonsterDamageByEntityEvent(
            final DiabloMonsterDamageByEntityEvent event)
    {

        if ((plugin.worlds.size() > 0)
                && plugin.config.getBoolean("Worlds.Enabled", false)
                && !plugin.worlds.contains(event.getDamagedEntity()
                        .getLocation().getWorld().getName().toLowerCase()))
            return;
        LivingEntity damaged = event.getDamagedEntity();
        LivingEntity damager = event.getDamagingEntity();
        if (damaged.getWorld() != damager.getWorld())
            return;
        EffectsAPI.handlePluginEffects(damaged, damager, event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDiabloMonsterDamageEvent(
            final DiabloMonsterDamageEvent event)
    {
        if ((plugin.worlds.size() > 0)
                && plugin.config.getBoolean("Worlds.Enabled", false)
                && !plugin.worlds.contains(event.getLivingEntity()
                        .getLocation().getWorld().getName().toLowerCase()))
            return;
        if (event.getLivingEntity() instanceof Player)
        {
            EffectsAPI.handlePluginEffects(event.getLivingEntity(), null,
                    event);
        }
    }
}

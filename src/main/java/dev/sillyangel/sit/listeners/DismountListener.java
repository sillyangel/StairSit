package dev.sillyangel.sit.listeners;

import dev.sillyangel.sit.Sit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDismountEvent;
import org.bukkit.persistence.PersistentDataType;

public class DismountListener implements Listener {

    @EventHandler
    public void onDismount(EntityDismountEvent e) {
        Entity dismounted = e.getDismounted();
        NamespacedKey key = new NamespacedKey(Sit.getInstance(), "stair");
        
        if (dismounted.getPersistentDataContainer().has(key, PersistentDataType.BOOLEAN)) {
            // Use Folia-compatible entity scheduler
            dismounted.getScheduler().runDelayed(Sit.getInstance(), (task) -> {
                dismounted.remove();
            }, null, 1L);
        }
    }
}

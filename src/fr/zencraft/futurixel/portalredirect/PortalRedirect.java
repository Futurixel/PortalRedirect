package fr.zencraft.futurixel.portalredirect;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalRedirect extends JavaPlugin implements Listener {

    ConfigManager configManager = new ConfigManager(this);

    @Override
    public void onEnable(){

        configManager.load();

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable(){

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onTakePortal(PlayerPortalEvent e) {
        if(configManager.isEnabled()) {
            Player p = e.getPlayer();
            PlayerTeleportEvent.TeleportCause cause = e.getCause();
            if (cause == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) {
                e.setCancelled(true);
                if(configManager.getNetherWorld()!=null){
                    p.teleportAsync(configManager.getNetherWorld().getSpawnLocation());
                }

            }
            if (cause == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
                e.setCancelled(true);
                if(configManager.getEndworld()!=null){
                    p.teleportAsync(configManager.getNetherWorld().getSpawnLocation());
                }
            }
        }
    }

}

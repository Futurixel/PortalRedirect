package fr.zencraft.futurixel.portalredirect;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

public class ConfigManager {

    private PortalRedirect main;
    public ConfigManager(PortalRedirect main){
        this.main = main;
    }

    private World netherworld;
    private World endworld;
    private boolean enable;

    public void load(){
        if(!main.getDataFolder().exists()){
            main.getDataFolder().mkdir();
        }

        if(main.getConfig().isSet("enable")){
            enable = main.getConfig().getBoolean("enable");
        }else{
            main.getConfig().set("enable", false);
        }

        String netherworldname;
        String endworldname;

        if(main.getConfig().isSet("globalworldtp.nether")){
            netherworldname = main.getConfig().getString("globalworldtp.nether");
        }else{
            main.getConfig().set("globalworldtp.nether", "WORLD_NETHER");
            netherworldname = "WORLD_NETHER";
        }

        if(main.getConfig().isSet("globalworldtp.end")){
            endworldname = main.getConfig().getString("globalworldtp.end");
        }else{
            main.getConfig().set("globalworldtp.end", "WORLD_THE_END");
            endworldname = "WORLD_THE_END";
        }


        netherworld = Bukkit.getWorld(netherworldname);
        endworld = Bukkit.getWorld(endworldname);

        System.out.println("[PORTAL REDIRECT] Chargement de la configuration terminée");

        System.out.println("[PORTAL REDIRECT] Chargement de la configuration terminée");
    }

    public boolean isEnabled(){
        return this.enable;
    }

    public World getNetherWorld(){
        return this.netherworld;
    }

    public World getEndworld(){
        return this.endworld;
    }

}

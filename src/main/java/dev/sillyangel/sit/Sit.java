package dev.sillyangel.sit;

import dev.sillyangel.sit.command.CommandHandler;
import dev.sillyangel.sit.command.SitCommand;
import dev.sillyangel.sit.listeners.DismountListener;
import dev.sillyangel.sit.listeners.InteractListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

public final class Sit extends JavaPlugin {

    private static Sit instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new InteractListener(), this);
        getServer().getPluginManager().registerEvents(new DismountListener(), this);

        CommandHandler.register(new SitCommand("sit",
                "command to reload plugin's config",
                "/sit reload",
                Collections.emptyList()));
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public static Sit getInstance() {
        return instance;
    }

}

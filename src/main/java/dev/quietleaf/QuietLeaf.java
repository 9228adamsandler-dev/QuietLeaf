package dev.quietleaf;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuietLeaf extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        applyWorldRules();

        getLogger().info("QuietLeaf enabled.");
    }

    private void applyWorldRules() {
        if (!getConfig().getBoolean("disable-advancement-announcements", true)) {
            return;
        }

        for (World world : Bukkit.getWorlds()) {
            world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (getConfig().getBoolean("disable-join-messages", true)) {
            event.joinMessage(null);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (getConfig().getBoolean("disable-leave-messages", true)) {
            event.quitMessage(null);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (getConfig().getBoolean("disable-death-messages", true)) {
            event.deathMessage(null);
        }
    }

    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {
        if (getConfig().getBoolean("disable-advancement-announcements", true)) {
            event.getWorld().setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        }
    }
}

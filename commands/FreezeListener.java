package plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FreezeListener implements Listener {
    private final CommandFreeze commandFreeze;
    private final Map<UUID, Location> deathLocations = new HashMap<>();

    public FreezeListener(CommandFreeze commandFreeze) {
        this.commandFreeze = commandFreeze;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        // Vérifie si le joueur est gelé
        if (commandFreeze.isFrozen(player)) {
            // Annule l'événement de déplacement, ce qui empêche le joueur de bouger
            event.setCancelled(true);
            // Stocke la position actuelle du joueur
            deathLocations.put(player.getUniqueId(), player.getLocation());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (commandFreeze.isFrozen(player)) {
            player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.RED + "Tu es actuellement gelé !");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (deathLocations.containsKey(playerUUID)) {
            // Téléporte le joueur à l'endroit de sa mort
            Location deathLocation = deathLocations.get(playerUUID);

            Bukkit.getScheduler().runTaskLater(commandFreeze.getPlugin(), () -> {
                player.teleport(deathLocation);
            }, 1L);  // Assure que la téléportation se fait après la réapparition

            // Supprime la position de mort stockée
            deathLocations.remove(playerUUID);
        }
    }
}

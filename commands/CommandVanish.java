package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashSet;
import java.util.Set;

public class CommandVanish implements CommandExecutor {
    private final Set<Player> vanishedPlayers = new HashSet<>();
    private final Plugin plugin;

    public CommandVanish(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (vanishedPlayers.contains(player)) {
                // Rendre le joueur visible
                for (Player onlinePlayer : org.bukkit.Bukkit.getServer().getOnlinePlayers()) {
                        onlinePlayer.showPlayer(plugin, player);
                }
                vanishedPlayers.remove(player);
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Tu es maintenant visible !");
            } else {
                // Rendre le joueur invisible
                for (Player onlinePlayer : org.bukkit.Bukkit.getServer().getOnlinePlayers()) {
                    onlinePlayer.hidePlayer(plugin, player);
                }
                vanishedPlayers.add(player);
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Tu es maintenant invisible !");
            }

            return true;
        }

        sender.sendMessage(ChatColor.RED + "Cette commande ne peut être exécutée que par un joueur.");
        return false;
    }
}

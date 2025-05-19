package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class CommandGodemode implements CommandExecutor {
    private final Set<Player> godmode = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0){
            if (godmode.contains(player)) {
                godmode.remove(player);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu n'es plus invincible !");
            }
            else {
                godmode.add(player);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu es maintenant invincible !");
            }
        }
        if (args.length > 0) {
            Player target = org.bukkit.Bukkit.getPlayer(args[0]);
            if (target != null) {
                if (godmode.contains(target)) {
                    godmode.remove(target);
                    target.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu n'es plus invincible !");
                    player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + target.getName() + " n'est plus invincible !");
                } else {
                    godmode.add(target);
                    target.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu es maintenant invincible !");
                    player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + target.getName() + " est maintenant invincible !");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Le joueur " + args[0] + " n'est pas connecté / n'existe pas.");
            }
        }
        return true;
    }

    public boolean isGodMode(Player player) {
        return godmode.contains(player);
    }
}
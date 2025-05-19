package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"[SERVEUR] "+"Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length > 0) {
            Player target = org.bukkit.Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le joueur " + args[0] + " n'est pas en ligne.");
                return true;
            }

            toggleFlight(target);
            if (target.getAllowFlight()){
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le mode de vol à été activer pour: "+ChatColor.DARK_GREEN + target.getName());
            }else {
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le mode de vol à été désactiver pour: "+ChatColor.DARK_GREEN + target.getName());
            }
            return true;
        }

        toggleFlight(player);
        return true;
    }

    private void toggleFlight(Player player) {
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le mode de vol est désactivé.");
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le mode de vol est activé.");
        }
    }
}

package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandinv implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length != 0) {
                Player target = org.bukkit.Bukkit.getPlayer(args[0]);
                if (target != null) {
                    player.openInventory(target.getInventory());
                }


            }else{
                player.sendMessage(ChatColor.RED + "[SERVEUR] " +ChatColor.GREEN +"Tu dois spécifier un joueur !");
            }
        }
        return false;
    }
}

package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandendinv implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length != 0) {
                Player target = org.bukkit.Bukkit.getPlayer(args[0]);
                if (target != null) {
                    player.openInventory(target.getEnderChest());
                }
            }else{
                player.sendMessage(ChatColor.RED + "[SERVEUR] " +ChatColor.GREEN +"Tu dois spécifier un joueur !");
            }
        }
        return false;
    }
}

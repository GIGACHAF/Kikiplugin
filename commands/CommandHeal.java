package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 0) {
                player.setHealth(20);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " +ChatColor.GREEN +"Tu as été heal !");
                return true;
            }else {
                Player target = org.bukkit.Bukkit.getPlayer(args[0]);
                assert target != null;
                target.setHealth(20);
                target.sendMessage(ChatColor.RED + "[SERVEUR] " +ChatColor.GREEN +"Tu as été heal par un administrateur !");
                return true;
            }
        }
        return false;
    }
}

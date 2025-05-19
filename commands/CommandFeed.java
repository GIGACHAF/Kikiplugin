package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
    if (commandSender instanceof Player) {
        Player player = (Player) commandSender;
        if (args.length == 0) {
            player.setFoodLevel(20);
            player.setSaturation(20);
            player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Tu as été feed !");
        }
        if (args.length >= 1) {
            Player target = org.bukkit.Bukkit.getPlayer(args[0]);
            if (target != null) {
                target.setFoodLevel(20);
                target.setSaturation(20);
                target.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Tu as été feed par un administrateur !");
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Le joueur " + target.getName()+" à été feed");
            }
        }
    }
        return false;
    }
}

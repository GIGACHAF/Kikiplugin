package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBC implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+"Tu dois mettre un message !");
                return true;
            }else {
                player.sendMessage(ChatColor.RED +"[Serveur] " + ChatColor.GREEN + args[0]);
                return true;

            }
        }
        return false;
    }
}

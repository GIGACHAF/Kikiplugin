package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandRepair implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender; // Déplacez cette ligne ici
            ItemStack item = player.getInventory().getItemInMainHand(); // Correction de l'ordre
            if (item.getType() == Material.AIR) {
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu ne peux pas réparer de l'air !");
            } else if (args.length == 0) {
                item.setDurability((short) 0);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "L'item a été réparé !");
            } else if (args.length != 0) {
                int dura = Integer.parseInt(args[0]);
                item.setDurability((short)dura);
                if(dura < 0) {
                    player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu ne peut pas mettre un nombre negatif !");
                }
            }else {
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Cet item est déjà en parfait état !");
            }
            return true; // Retourne true si la commande a été traitée
        } else {
            commandSender.sendMessage("Seuls les joueurs peuvent utiliser cette commande.");
        }
        return false; // Retourne false si la commande n'a pas été traitée
    }
}

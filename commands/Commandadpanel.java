package plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class Commandadpanel implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length == 0) {
                Inventory menubase = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Menu Principal");

                ItemStack emerald = new ItemStack(Material.EMERALD);
                ItemMeta meta = emerald.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Check joueur");
                meta.setLore(Arrays.asList(ChatColor.GRAY + "Commandes pour check un joueur"));
                emerald.setItemMeta(meta);
                menubase.setItem(13, emerald);

                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                ItemMeta metaskull = skull.getItemMeta();
                metaskull.setDisplayName(ChatColor.GREEN + "Self");
                metaskull.setLore(Arrays.asList(ChatColor.GRAY + "Commandes pour sois"));
                skull.setItemMeta(metaskull);
                menubase.setItem(10, skull);

                ItemStack World = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta metaWorld = World.getItemMeta();
                metaWorld.setDisplayName(ChatColor.GREEN + "World");
                metaWorld.setLore(Arrays.asList(ChatColor.GRAY + "Commandes pour agir sur le monde"));
                World.setItemMeta(metaWorld);
                menubase.setItem(16, World);

                player.openInventory(menubase);
                return true;
            }
        }
        return false;
    }
}

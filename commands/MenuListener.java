package plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(ChatColor.BLUE + "Menu Principal")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) return;
            String displayName = event.getCurrentItem().getItemMeta().getDisplayName();

            if (displayName.equals(ChatColor.GREEN + "Check joueur")) {
                player.openInventory(createPlayerListMenu.createPlayerListMenu());
            }
            if (displayName.equals(ChatColor.GREEN + "Self")) {
                player.openInventory(menuGui.menusolo());
            }
            if (displayName.equals(ChatColor.GREEN + "World")) {
                event.setCancelled(true);
                player.openInventory(menuGui.menuworld());
            }
        }

        if (event.getView().getTitle().equals(ChatColor.BLUE + "Commandes")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || !event.getCurrentItem().hasItemMeta()) return;
            String displayName = event.getCurrentItem().getItemMeta().getDisplayName();

            if (displayName.equals(ChatColor.AQUA + "Vanish")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("vanish");
            }

            if (displayName.equals(ChatColor.AQUA + "Godmode")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("godmode " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Retour")) {
                player.openInventory(menuGui.Menudebase());
            }
        }

        if (event.getView().getTitle().equals(ChatColor.DARK_PURPLE + "Choisis un joueur")) {
            event.setCancelled(true);
            String targetName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
            player.openInventory(menuGui.menuGui(targetName));
        }

        if (event.getView().getTitle().equals(ChatColor.RED + "CHOIX")) {
            event.setCancelled(true);
            String displayName = event.getCurrentItem().getItemMeta().getDisplayName();

            if (displayName.equals(ChatColor.AQUA + "Mettre en prison")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("jail " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Freeze le joueur")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("freeze " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Check inventaire")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("inv " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Check Ender Chest")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("endinv " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Godmode")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("godmode " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Fly")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("fly " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Me tp")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("tp " + player.getName() + " " + name);
                player.closeInventory();
            }

            if (displayName.equals(ChatColor.AQUA + "Le tp")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("tp " + name + " " + player.getName());
            }

            if (displayName.equals(ChatColor.AQUA + "Le clear")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("clear " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Heal")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("heal " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Retour")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                player.openInventory(menuGui.Menudebase());
            }

            if (displayName.equals(ChatColor.AQUA + "Nourrir le joueur")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("feed " + name);
            }

            if (displayName.equals(ChatColor.AQUA + "Reparer l'objet")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                Player target = Bukkit.getServer().getPlayer(name);
                target.performCommand("repair ");
            }

            if (displayName.equals(ChatColor.AQUA + "Kick")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                Player target = Bukkit.getServer().getPlayer(name);
                player.performCommand("kick " + name);
            }

            if (displayName.equals(ChatColor.RED + "Ban")) {
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                String name = meta.getLocalizedName();
                player.performCommand("ban " + name);
            }
        }

        if (event.getView().getTitle().equals(ChatColor.GREEN + "Menu World")) {
            event.setCancelled(true);
            String displayName = event.getCurrentItem().getItemMeta().getDisplayName();

            if (displayName.equals(ChatColor.RED + "Temps")) {
                player.openInventory(menuGui.menutemps());
            }

            if (displayName.equals(ChatColor.RED + "Heures")) {
                player.openInventory(menuGui.menutemps());
            }
        }
    }
}

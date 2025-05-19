package plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class createPlayerListMenu {
    public static Inventory createPlayerListMenu() {
        // Crée un inventaire de 54 slots avec un titre violet
        Inventory menujoueur = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Choisis un joueur");
        int index = 0;

        // Parcours tous les joueurs en ligne
        for (Player online : Bukkit.getOnlinePlayers()) {
            // Crée une tête de joueur
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta metajoueur = skull.getItemMeta();

            // Met le nom du joueur comme nom visible
            metajoueur.setDisplayName(ChatColor.AQUA + online.getName());
            skull.setItemMeta(metajoueur);

            // Place l'item dans l'inventaire
            menujoueur.setItem(index++, skull);
        }

        return menujoueur; // Retourne l'inventaire si on veut le réutiliser
    }

}

package plugin.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class menuGui {

    public static Inventory menuGui (String targetName){

        Inventory menujoueur = Bukkit.createInventory(null, 54, ChatColor.RED + "CHOIX");
        ItemStack bar = new ItemStack(Material.IRON_BARS);
        ItemMeta metajoueur = bar.getItemMeta();

          
        metajoueur.setDisplayName(ChatColor.AQUA + "Mettre en prison");
        metajoueur.setLocalizedName(targetName);
        bar.setItemMeta(metajoueur);

        // Place l'item dans l'inventaire
        menujoueur.setItem(10,bar);


        ItemStack ice = new ItemStack(Material.BLUE_ICE);
        ItemMeta metaice = ice.getItemMeta();

          
        metaice.setDisplayName(ChatColor.AQUA + "Freeze le joueur");
        metaice.setLocalizedName(targetName);
        ice.setItemMeta(metaice);
        menujoueur.setItem(12,ice);

        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta metachest = chest.getItemMeta();

          
        metachest.setDisplayName(ChatColor.AQUA + "Check inventaire");
        metachest.setLocalizedName(targetName);
        chest.setItemMeta(metachest);
        menujoueur.setItem(14,chest);

        ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
        ItemMeta metaenderchest = enderchest.getItemMeta();

          
        metaenderchest.setDisplayName(ChatColor.AQUA + "Check Ender Chest");
        metaenderchest.setLocalizedName(targetName);
        enderchest.setItemMeta(metaenderchest);
        menujoueur.setItem(16,enderchest);


        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta metatotem = totem.getItemMeta();

          
        metatotem.setDisplayName(ChatColor.AQUA + "Godmode");
        metatotem.setLocalizedName(targetName);
        totem.setItemMeta(metatotem);
        menujoueur.setItem(37-9,totem);

        ItemStack elytra = new ItemStack(Material.ELYTRA);
        ItemMeta metaelytra= elytra.getItemMeta();

          
        metaelytra.setDisplayName(ChatColor.AQUA + "Fly");
        metaelytra.setLocalizedName(targetName);
        elytra.setItemMeta(metaelytra);
        menujoueur.setItem(30,elytra);


        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta metapearl= pearl.getItemMeta();

          
        metapearl.setDisplayName(ChatColor.AQUA + "Me tp");
        metapearl.setLocalizedName(targetName);
        pearl.setItemMeta(metapearl);
        menujoueur.setItem(41-9,pearl);

        ItemStack laisse = new ItemStack(Material.LEAD);
        ItemMeta metalaisse= laisse.getItemMeta();

          
        metalaisse.setDisplayName(ChatColor.AQUA + "Le tp");
        metalaisse.setLocalizedName(targetName);
        laisse.setItemMeta(metalaisse);
        menujoueur.setItem(43-9,laisse);


        ItemStack Steak = new ItemStack(Material.COOKED_BEEF);
        ItemMeta metaSteak= Steak.getItemMeta();

          
        metaSteak.setDisplayName(ChatColor.AQUA + "Nourrir le joueur");
        metaSteak.setLocalizedName(targetName);
        Steak.setItemMeta(metaSteak);
        menujoueur.setItem(49,Steak);

        ItemStack hammer = new ItemStack(Material.ANVIL);
        ItemMeta metahammer= hammer.getItemMeta();

          
        metahammer.setDisplayName(ChatColor.AQUA + "Reparer l'objet");
        metahammer.setLocalizedName(targetName);
        hammer.setItemMeta(metahammer);
        menujoueur.setItem(46,hammer);

        ItemStack invisible = new ItemStack(Material.BARRIER);
        ItemMeta metainvisible= invisible.getItemMeta();

          
        metainvisible.setDisplayName(ChatColor.AQUA + "Le clear");
        metainvisible.setLocalizedName(targetName);
        invisible.setItemMeta(metainvisible);
        menujoueur.setItem(26,invisible);

        ItemStack heal = new ItemStack(Material.SPLASH_POTION);
        ItemMeta metaheal= heal.getItemMeta();

          
        metaheal.setDisplayName(ChatColor.AQUA + "Heal");
        metaheal.setLocalizedName(targetName);
        heal.setItemMeta(metaheal);
        menujoueur.setItem(35,heal);


        ItemStack back = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaback= back.getItemMeta();

          
        metaback.setDisplayName(ChatColor.AQUA + "Retour");
        metaback.setLocalizedName(targetName);
        metaback.setLore(null);
        back.setItemMeta(metaback);
        menujoueur.setItem(53,back);


        ItemStack kick = new ItemStack(Material.END_ROD);
        ItemMeta metakick= kick.getItemMeta();

          
        metakick.setDisplayName(ChatColor.AQUA + "Kick");
        metakick.setLocalizedName(targetName);
        metakick.setLore(null);
        kick.setItemMeta(metakick);
        menujoueur.setItem(51,kick);

        ItemStack ban = new ItemStack(Material.TNT);
        ItemMeta metaban= ban.getItemMeta();


        metaban.setDisplayName(ChatColor.RED + "Ban");
        metaban.setLocalizedName(targetName);
        metaban.setLore(null);
        ban.setItemMeta(metaban);
        menujoueur.setItem(52,ban);

        return menujoueur;

    }
    public static Inventory menusolo ( ){
        Inventory menu = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Commandes");


        ItemStack Torch = new ItemStack(Material.REDSTONE_TORCH);
        ItemMeta metaTorch= Torch.getItemMeta();

          
        metaTorch.setDisplayName(ChatColor.AQUA + "Vanish");
        Torch.setItemMeta(metaTorch);
        menu.setItem(11,Torch);



        ItemStack heal = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta metaheal= heal.getItemMeta();

          
        metaheal.setDisplayName(ChatColor.AQUA + "Godmode");
        heal.setItemMeta(metaheal);
        menu.setItem(15,heal);

        ItemStack back = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaback= back.getItemMeta();

          
        metaback.setDisplayName(ChatColor.AQUA + "Retour");

        metaback.setLore(null);
        back.setItemMeta(metaback);
        menu.setItem(26,back);
        return menu;
    }
    public static Inventory Menudebase(){
        Inventory menubase = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Menu Principal");

        ItemStack emerald = new ItemStack(Material.EMERALD);
        ItemMeta meta = emerald.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Check joueur");
        List<String> lore = Arrays.asList(ChatColor.GRAY + "Commandes pour check un joueur");
        meta.setLore(lore);

        emerald.setItemMeta(meta);
        menubase.setItem(13, emerald);


        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta metaskull = skull.getItemMeta();

        metaskull.setDisplayName(ChatColor.GREEN + "Self");
        List<String> loreskull = Arrays.asList(ChatColor.GRAY + "Commandes pour sois");
        metaskull.setLore(loreskull);

        skull.setItemMeta(metaskull);
        menubase.setItem(10, skull);

        ItemStack World = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta metaWorld = World.getItemMeta();

        metaWorld.setDisplayName(ChatColor.GREEN + "World");
        List<String> loreWorld = Arrays.asList(ChatColor.GRAY + "Commandes pour agir sur le monde");
        metaWorld.setLore(loreWorld);

        World.setItemMeta(metaWorld);
        menubase.setItem(16, World);

        return menubase;
    }
    public static Inventory menuworld ( ){
        Inventory menuworld = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Menu World");


        ItemStack weather = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta metaweather = weather.getItemMeta();

        metaweather.setDisplayName(ChatColor.RED + "Temps");
        List<String> loreweather = Arrays.asList(ChatColor.GRAY + "Commandes pour changer le temps");
        metaweather.setLore(loreweather);

        weather.setItemMeta(metaweather);
        menuworld.setItem(10, weather);


        ItemStack Time = new ItemStack(Material.CLOCK);
        ItemMeta metaTime = Time.getItemMeta();

        metaTime.setDisplayName(ChatColor.GREEN + "Heures");
        List<String> loreTime = Arrays.asList(ChatColor.GRAY + "Commandes pour changer l'heure");
        metaTime.setLore(loreTime);

        Time.setItemMeta(metaTime);
        menuworld.setItem(14, Time);


        return menuworld;
    }
    public static Inventory menutemps ( ){
        Inventory menutemps = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Temps choisit");

        ItemStack clear = new ItemStack(Material.BARRIER);
        ItemMeta metaclear = clear.getItemMeta();

        metaclear.setDisplayName(ChatColor.RED + "Temps");
        List<String> loreclear = Arrays.asList(ChatColor.GRAY + "Temps clair");
        metaclear.setLore(loreclear);

        clear.setItemMeta(metaclear);
        menutemps.setItem(10, clear);
        return menutemps;
    }
}

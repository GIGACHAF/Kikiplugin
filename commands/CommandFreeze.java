package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CommandFreeze implements CommandExecutor {
    private Set<UUID> frozenPlayers = new HashSet<>();

    private final Set<Player> godmode = new HashSet<>();

    private final JavaPlugin plugin;

    public CommandFreeze(JavaPlugin plugin) {
        this.plugin = plugin;
        loadFrozenPlayers();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (args.length < 1) {
                player.sendMessage(ChatColor.RED + "Usage: /freeze <player>");
                return true;
            }

            Player target = org.bukkit.Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Le joueur " + args[0] + " n'est pas en ligne. / n'existe pas");
                return true;
            }

            UUID targetUUID = target.getUniqueId();
            if (frozenPlayers.contains(targetUUID)) {
                frozenPlayers.remove(targetUUID);
                godmode.remove(target);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + target.getName() + " a été unfreeze");
                target.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Tu n'es plus freeze");
            } else {
                frozenPlayers.add(targetUUID);
                godmode.add(target);
                player.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.GREEN + "Le joueur " + target.getName() + " a été freeze");
                target.sendMessage(ChatColor.RED + "[SERVEUR] " + ChatColor.RED + "Tu as été freeze par un administrateur");
            }

            saveFrozenPlayers();
            return true;
        }
        return false;
    }

    public boolean isFrozen(Player player) {
        return frozenPlayers.contains(player.getUniqueId());
    }

    private void saveFrozenPlayers() {
        try (FileOutputStream fos = new FileOutputStream("frozenPlayers.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(frozenPlayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFrozenPlayers() {
        File file = new File("frozenPlayers.ser");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                frozenPlayers = (Set<UUID>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isGodMode(Player player) {
        return godmode.contains(player);
    }
    public JavaPlugin getPlugin() {
        return plugin;
    }
}

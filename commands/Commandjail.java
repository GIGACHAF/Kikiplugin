package plugin.plugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Material.BEDROCK;
import static org.bukkit.Material.IRON_BARS;

public class Commandjail implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED+"[SERVEUR] "+"Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }
        Player player = (Player) sender;
        if(args.length > 0) {
            Player target =org.bukkit.Bukkit.getPlayer(args[0]);
            if(target != null) {
                Location location = target.getLocation();
                double longeur = location.getX();
                double hauteur = location.getY();
                double profondeur = location.getZ();

                double x = longeur;
                double y = hauteur;
                double z = profondeur;
                Location jail = new Location(location.getWorld(), longeur, hauteur+2, profondeur);
                Location jail1 = new Location(location.getWorld(), longeur, hauteur-1, profondeur);
                Location jail2 = new Location(location.getWorld(), longeur+1, hauteur, profondeur);
                Location jail3 = new Location(location.getWorld(), longeur-1, hauteur, profondeur);
                Location jail4 = new Location(location.getWorld(), longeur+1, hauteur+1, profondeur);
                Location jail5 = new Location(location.getWorld(), longeur-1, hauteur+1, profondeur);
                Location jail6 = new Location(location.getWorld(), longeur, hauteur, profondeur+1);
                Location jail7 = new Location(location.getWorld(), longeur, hauteur, profondeur-1);
                Location jail8 = new Location(location.getWorld(), longeur, hauteur+1, profondeur-1);
                Location jail9 = new Location(location.getWorld(), longeur, hauteur+1, profondeur+1);
                Location jail10 = new Location(location.getWorld(), longeur+1, hauteur+1, profondeur+1);
                Location jail11 = new Location(location.getWorld(), longeur-1, hauteur+1, profondeur+1);
                Location jail12 = new Location(location.getWorld(), longeur, hauteur+2, profondeur+1);
                Block block = jail.getBlock();
                Block block1 = jail1.getBlock();
                Block block2 = jail2.getBlock();
                Block block3 = jail3.getBlock();
                Block block4 = jail4.getBlock();
                Block block5 = jail5.getBlock();
                Block block6 = jail6.getBlock();
                Block block7 = jail7.getBlock();
                Block block8 = jail8.getBlock();
                Block block9 = jail9.getBlock();
                Block block10 = jail10.getBlock();
                Block block11 = jail11.getBlock();
                Block block12 = jail12.getBlock();

                block.setType(BEDROCK);
                block1.setType(BEDROCK);
                block2.setType(BEDROCK);
                block3.setType(BEDROCK);
                block4.setType(BEDROCK);
                block5.setType(BEDROCK);
                block6.setType(BEDROCK);
                block7.setType(BEDROCK);
                block8.setType(BEDROCK);
                block9.setType(IRON_BARS);
                block10.setType(BEDROCK);
                block11.setType(BEDROCK);
                block12.setType(BEDROCK);
                player.sendMessage(ChatColor.RED+"[SERVEUR] "+ChatColor.GREEN+target.getName()+" est jail !");
                target.sendMessage(ChatColor.RED+"[SERVEUR] Tu a été jail par un Administrateur !");
                target.setGameMode(GameMode.ADVENTURE);
                return true;
            }

        }
        return false;
    }
}

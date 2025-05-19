package plugin.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import plugin.plugin.commands.*;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin enabled");

        // Initialisation des commandes
        Commandadpanel commandadpanel = new Commandadpanel();
        CommandGodemode commandGodemode = new CommandGodemode();
        CommandFreeze commandFreeze = new CommandFreeze(this);
        getCommand("bc").setExecutor(new CommandBC());
        getCommand("feed").setExecutor(new CommandFeed());
        getCommand("inv").setExecutor(new Commandinv());
        getCommand("endinv").setExecutor(new Commandendinv());
        getCommand("fly").setExecutor(new CommandFly());
        getCommand("heal").setExecutor(new CommandHeal());
        getCommand("freeze").setExecutor(commandFreeze);
        getCommand("godmode").setExecutor(commandGodemode);
        getCommand("vanish").setExecutor(new CommandVanish(this));
        getCommand("craft").setExecutor(new CommandCraft());
        getCommand("jail").setExecutor(new Commandjail());
        getCommand("panel").setExecutor(new Commandadpanel());
        getCommand("repair").setExecutor(new CommandRepair());



        // Enregistrement des listeners
        getServer().getPluginManager().registerEvents(new GodModeListener(commandGodemode, commandFreeze), this);
        getServer().getPluginManager().registerEvents(new FreezeListener(commandFreeze), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin disabled");
    }
}

package plugin.plugin.commands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;

public class GodModeListener implements Listener {
    private final CommandGodemode commandGodemode;
    private final CommandFreeze commandFreeze;

    public GodModeListener(CommandGodemode commandGodemode, CommandFreeze commandFreeze) {
        this.commandGodemode = commandGodemode;
        this.commandFreeze = commandFreeze;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (commandFreeze.isFrozen(player)) {
                event.setCancelled(true);
            } else if (commandGodemode.isGodMode(player)) {
                event.setCancelled(true);
            }
        }
    }
}

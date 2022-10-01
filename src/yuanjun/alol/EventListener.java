package yuanjun.alol;

import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

public class EventListener implements Listener {
    // 登入时获取player name
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e){
        LoginData.addPlayerName(e.getPlayer().getName());
        // 使用LoginData类定义的addPlayerName
    }

    // 离开时移除列表
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        LoginData.removePlayerName(e.getPlayer().getName());
        //同上
    }

    public static void cancelIfNotLoggedIn(Cancellable e) {
        if (e instanceof PlayerEvent) {
            if (LoginData.hasPlayerName(((PlayerEvent) e).getPlayer().getName())) {
                e.setCancelled(true);
            }
        } else if (e instanceof InventoryOpenEvent) {
            if (LoginData.hasPlayerName(((InventoryOpenEvent) e).getPlayer().getName())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void restrictMove(PlayerMoveEvent e) {
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictInteract(PlayerInteractEvent e) {
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictInteractAtEntity(PlayerInteractAtEntityEvent e) {
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictPortal(PlayerPortalEvent e) {
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictTeleport(PlayerTeleportEvent e) {
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictOpenInventory(InventoryOpenEvent e) {
        cancelIfNotLoggedIn(e);
    }
}

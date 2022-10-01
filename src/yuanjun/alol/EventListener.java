package yuanjun.alol;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
}

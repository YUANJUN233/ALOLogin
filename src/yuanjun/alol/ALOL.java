package yuanjun.alol;

import org.bukkit.plugin.java.JavaPlugin;

public class ALOL extends JavaPlugin {

    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Start Plugin");
    }
}
/* WTF I DONT WANNA HAVE SOMETHING COOL */
package yuanjun.alol;

import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigReader {
    public static FileConfiguration config = ALOL.instance.getConfig();

    public static boolean isPlayerRegisted(String playerName) {
        return config.contains(playerName.toLowerCase());
    }

    public static boolean verifyPwd(String playerName, String pwd) {
        return pwd.equals(config.getString(playerName.toLowerCase()));
    }

    public static void addPlayer(String playerName, String pwd) {
        ALOL.instance.getConfig().set(playerName.toLowerCase(), pwd);
        ALOL.instance.saveConfig();
    }
}

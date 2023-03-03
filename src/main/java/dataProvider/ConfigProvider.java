package dataProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("gostex.conf");
    }


    String URL = readConfig().getString("url");
    String ADMIN_LOGIN = readConfig().getString("authorization.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("authorization.admin.password");
}

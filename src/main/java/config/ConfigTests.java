package config;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:config.properties"})
public interface ConfigTests extends Config {

    String url();
    String driverPath();
    String driverPropetry();
    String currentUrlFor1TC();
    String currentTextFor1TC();
    String currentTextFor2TC();
    String currentUserName();
    String currentPassword();
    String testUserName();
    String testPassword();


}

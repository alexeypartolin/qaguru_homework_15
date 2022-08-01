package config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:${LocalOrSelenoid}.properties")

public interface WebConfig extends Config {

    @Key("browser.name")
    @DefaultValue("Chrome")
    String browser();

    @Key("browser.version")
    @DefaultValue("99")
    String version();

    @Key("host")
    @DefaultValue("http://localhost:4444/wd/hub")
    String host();
}

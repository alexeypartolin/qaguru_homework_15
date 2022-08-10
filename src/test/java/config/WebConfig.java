package config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")

public interface WebConfig extends Config {

    @Key("browser.name")
    @DefaultValue("Chrome")
    String browser();

    @Key("browser.version")
    @DefaultValue("99")
    String version();

    @Key("host")
    String host();

    @Key("base.url")
    @DefaultValue("https://github.com")
    String baseUrl();
}

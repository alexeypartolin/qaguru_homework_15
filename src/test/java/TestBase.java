import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    public static void beforeTest() {
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.version();

        // Host
        if(!webConfig.host().equals("")) {
            Configuration.remote = webConfig.host();
        }

        // Base Url
        String baseUrlString = System.getProperty("base.url");

        if (Objects.isNull(baseUrlString)) {
            baseUrlString = "https://github.com";
        }

        open(baseUrlString);
    }
}
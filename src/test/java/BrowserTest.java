import config.WebConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BrowserTest {
    @Test
    @Tag("localTest")
    @DisplayName("Считывание с данными для локального запуска")
    public void TestingLocalWeb() {
        System.setProperty("env", "local");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.browser()).isEqualTo("Chrome");
        assertThat(config.version()).isEqualTo("99");
        //assertThat(config.host()).isEqualTo("https://localhost:4444/wd/hub");

    }

    @Test
    @Tag("remoteTest")
    @DisplayName("Считывание с данными для удаленного запуска")
    public void TestingRemoteWeb() {
        System.setProperty("env", "selenoid");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.browser()).isEqualTo("Chrome");
        assertThat(config.version()).isEqualTo("97");
        assertThat(config.host()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}

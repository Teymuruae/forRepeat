package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    private static String browser = System.getProperty("browser", "firefox");
    private static String baseUrl = System.getProperty("url", "https://ru.selenide.org");

    @BeforeAll
    static void all() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = browser;
        Configuration.baseUrl = baseUrl;

//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;

    }
    @BeforeEach
    void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void tearDown(){
        Attachments.attachScreenshot();
//        Attachments.addVideo();
//        Attachments.browserConsoleLogs();

    }

}

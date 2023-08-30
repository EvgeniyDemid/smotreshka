package ru.smotreshka.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.smotreshka.config.WebConfig;
import ru.smotreshka.helpers.Attach;
import ru.smotreshka.ui.tests.pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
	MainPage mainPage = new MainPage();
	static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		Configuration.baseUrl = System.getProperty("baseUrl",config.baseUrl());
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = System.getProperty("browserSize", config.browserSize());
		Configuration.browser = System.getProperty("browser", config.browser());
		Configuration.remote = System.getProperty("selenoid");
		Configuration.browserVersion = System.getProperty("browserVersion", config.browserVersion());

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("selenoid:options", Map.<String, Object>of(
				"enableVNC", true,
				"enableVideo", true
		));

		Configuration.browserCapabilities = capabilities;
	}

	@BeforeEach
	void setUp() {
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
		mainPage.openPage();
	}

	@AfterEach
	void addAttachments() {
		Attach.screenshotAs("Last screenshot");
		Attach.pageSource();
		Attach.browserConsoleLogs();
		Attach.addVideo();
		closeWebDriver();
	}
}

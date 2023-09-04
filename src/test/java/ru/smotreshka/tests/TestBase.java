package ru.smotreshka.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.smotreshka.config.BrowserConfig;
import ru.smotreshka.config.WebConfig;
import ru.smotreshka.helpers.Attach;
import ru.smotreshka.pages.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

	private final MainPage mainPage = new MainPage();

	static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
	static BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class, System.getProperties());
	static boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", config.isRemote()));
	protected final String login = System.getProperty("login");
	protected final String password = System.getProperty("password");


	@BeforeAll
	static void beforeAll() {
		Configuration.baseUrl = System.getProperty("baseUrl", config.baseUrl());
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = System.getProperty("browserSize", browserConfig.browserSize());
		Configuration.browser = System.getProperty("browser", browserConfig.browser());
		Configuration.remote = System.getProperty("selenoid");
		Configuration.browserVersion = System.getProperty("browserVersion", browserConfig.browserVersion());
		if (isRemote) {
			Configuration.remote = config.remoteUrl();
		}

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
		if (isRemote) {
			Attach.addVideo();
		}
		closeWebDriver();
	}
}

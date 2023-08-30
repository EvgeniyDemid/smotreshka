package ru.smotreshka.api.tests;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.smotreshka.config.WebConfig;

import java.util.Map;

public class BaseTest {
	static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
	String email = config.login();
	String password = config.password();

	@BeforeAll
	static void beforeAll() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("selenoid:options", Map.<String, Object>of(
				"enableVNC", true,
				"enableVideo", true
		));

		Configuration.browserCapabilities = capabilities;
	}
}

package ru.smotreshka.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"classpath:config/common.properties"
})
public interface BrowserConfig extends Config {

	@Key("browser")
	@DefaultValue("chrome")
	String browser();

	@DefaultValue("100.0")
	@Key("browserVersion")
	String browserVersion();

	@DefaultValue("1920x1080")
	@Key("browserSize")
	String browserSize();
}

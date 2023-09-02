package ru.smotreshka.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"classpath:config/${env}.properties",
		"classpath:config/common.properties",
})
public interface WebConfig extends Config {
	@Key("browser")
	@DefaultValue("chrome")
	String browser();

	@DefaultValue("100.0")
	@Key("browserVersion")
	String browserVersion();

	@DefaultValue("1920x1080")
	@Key("browserSize")
	String browserSize();

	@DefaultValue("https://smotreshka.tv/")
	@Key("baseUrl")
	String baseUrl();

	@DefaultValue("false")
	@Key("isRemote")
	boolean isRemote();

	@Key("remoteUrl")
	String remoteUrl();

	@Key("urlApi")
	@DefaultValue("https://fe.smotreshka.tv")
	String urlApi();
}

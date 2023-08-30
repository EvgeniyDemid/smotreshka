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
	String browser();

	@Key("browserVersion")
	String browserVersion();

	@Key("browserSize")
	String browserSize();

	@Key("baseUrl")
	String baseUrl();

	@Key("isRemote")
	boolean isRemote();

	@Key("remoteUrl")
	String remoteUrl();

	@Key("login")
	String login();

	@Key("password")
	String password();
}

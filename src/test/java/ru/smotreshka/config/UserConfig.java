package ru.smotreshka.config;

import org.aeonbits.owner.Config;

@Config.Sources({
		"system:properties",
		"classpath:config/user.properties"
})
public interface UserConfig extends Config {
	@Key("login")
	String login();

	@Key("password")
	String password();
}

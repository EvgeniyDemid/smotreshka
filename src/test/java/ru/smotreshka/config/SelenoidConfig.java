package ru.smotreshka.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/common.properties"})
public interface SelenoidConfig extends Config {

	@Key("videoUrl")
	String videoUrl();
}

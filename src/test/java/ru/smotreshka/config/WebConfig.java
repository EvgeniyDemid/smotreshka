package ru.smotreshka.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"classpath:config/common.properties"
})
public interface WebConfig extends Config {

	@DefaultValue("https://smotreshka.tv/")
	@Key("baseUrl")
	String baseUrl();

	@DefaultValue("false")
	@Key("isRemote")
	String isRemote();

	@Key("remoteUrl")
	String remoteUrl();

	@Key("urlApi")
	@DefaultValue("https://fe.smotreshka.tv")
	String urlApi();
}

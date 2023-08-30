package ru.smotreshka.api.specs;

import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.smotreshka.config.WebConfig;

import static io.restassured.RestAssured.with;
import static ru.smotreshka.helpers.CustomAllureListener.withCustomTemplates;

public class CommonSpec {
	static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
	static String baseUri = System.getProperty("UrlApi", config.urlApi());
	public static RequestSpecification requestSpec = with()
			.log()
			.all()
			.filter(withCustomTemplates())
			.when()
			.contentType("application/x-www-form-urlencoded")
			.baseUri(baseUri);
}

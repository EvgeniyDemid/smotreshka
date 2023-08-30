package ru.smotreshka.api.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static ru.smotreshka.helpers.CustomAllureListener.withCustomTemplates;

public class CommonSpec {
	static String baseUri = System.getProperty("baseUrl", "https://fe.smotreshka.tv");
	public static RequestSpecification requestSpec = with()
			.log()
			.all()
			.filter(withCustomTemplates())
			.when()
			.contentType("application/x-www-form-urlencoded")
			.baseUri(baseUri);
}

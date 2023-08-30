package ru.smotreshka.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.core.IsNull.notNullValue;

public class LoginSpec {
	public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
			.log(ALL)
			.expectStatusCode(200)
			.build();
	public static ResponseSpecification loginResponseSpec403 = new ResponseSpecBuilder()
			.log(ALL)
			.expectStatusCode(403)
			.expectBody("message",notNullValue())
			.build();
}

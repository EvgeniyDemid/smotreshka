package ru.smotreshka.tests;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.api.pojo.users.UserRes;

import static io.qameta.allure.Allure.step;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.smotreshka.api.specs.CommonSpec.requestSpec;
import static ru.smotreshka.api.specs.LoginSpec.loginResponseSpec;
import static ru.smotreshka.api.specs.LoginSpec.loginResponseSpec403;

@Owner("Demidov")
@Tag("api")
public class LoginTest extends TestBase {

	private final String errorMessage = "Неправильный логин или пароль.";

	@Test
	@DisplayName("Успешная авторизация c учеткой ")
	public void successfulLoginTest() {
		UserRes respons = step("Отправка запроса на авторизацию c учеткой " + login, () ->
				RestAssured
						.given(requestSpec)
						.formParam("email", login)
						.formParam("password", password)
						.when()
						.post("/v2/login")
						.then()
						.spec(loginResponseSpec)
						.assertThat()
						.body(matchesJsonSchemaInClasspath("schemas/loginUser-schema.json"))
						.extract()
						.response()
						.as(UserRes.class));
		step("Проверка ответа ", () -> {
			assertEquals(respons.getEmail(), login);
			assertEquals(respons.getName(), login);
			assertEquals(respons.getUsername(), login);
		});
	}

	@Test
	@DisplayName("Попытка авторизации с неверным логином")
	public void wrongLoginTest() {
		step("Отправка запроса на авторизацию ", () ->
				RestAssured
						.given(requestSpec)
						.formParam("email", "mail@mail.ru")
						.formParam("password", password)
						.when()
						.post("/v2/login")
						.then()
						.spec(loginResponseSpec403)
						.assertThat()
						.body("message", equalTo(errorMessage)));
	}

	@Test
	@DisplayName("Попытка авторизации с неверным паролем")
	public void wrongPasswordTest() {
		step("Отправка запроса на авторизацию ", () ->
				RestAssured
						.given(requestSpec)
						.formParam("email", "mail@mail.ru")
						.formParam("password", "password")
						.when()
						.post("/v2/login")
						.then()
						.spec(loginResponseSpec403)
						.assertThat()
						.body("message", equalTo(errorMessage)));
	}
}

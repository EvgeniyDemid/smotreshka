package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
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
public class LoginTests extends BaseTest {
	private final String errorMessage = "Неправильный логин или пароль.";
	private final String email = System.getProperty("email");
	private final String password = System.getProperty("password");

	@Test
	@Description("Успешная авторизация")
	public void successfulLoginTest() {
		UserRes respons = step("Отправка запроса на авторизацию ", () ->
				RestAssured
						.given(requestSpec)
						.formParam("email", email)
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
			assertEquals(respons.getEmail(), email);
			assertEquals(respons.getName(), email);
			assertEquals(respons.getUsername(), email);
		});
	}

	@Test
	@Description("Попытка авторизации с неверным логином")
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
	@Description("Попытка авторизации с неверным паролем")
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

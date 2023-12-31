package ru.smotreshka.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.pages.CommonElement;
import ru.smotreshka.pages.LoginPage;
import ru.smotreshka.pages.MainPage;

@Owner("Demidov")
@Tag("ui")
public class RegistrationTest extends TestBase {

	private final MainPage mainPage = new MainPage();
	private final CommonElement commonElement = new CommonElement();
	private final LoginPage loginPage = new LoginPage();

	@Test
	@DisplayName("Проверить, что кнопка войти отображается на главной странице")
	public void checkLoginButtonIsVisible() {
		mainPage.checkLoginButton();
	}

	@Test
	@DisplayName("Открытие страницы авторизации")
	public void openLoginPage() {
		mainPage.clickButton("Вход");
		commonElement.checkTitle("Регистрация");
	}

	@Test
	@DisplayName("Открытие страницы регистрации")
	public void openRegistrationPage() {
		mainPage.clickButton("Вход");
		mainPage.clickButton("Регистрация");
		loginPage.clickAgreeWithConditions();
		commonElement.checkTitle("Регистрация");
	}
}

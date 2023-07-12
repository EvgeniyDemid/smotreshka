package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.pages.MainPage;

public class RegistrationTest extends TestBase {
	MainPage mainPage = new MainPage();

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Проверить, что кнопка войти отображается на главной странице")
	public void checkLoginButtonIsVisible() {
		mainPage.checkLoginButton();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Открытие страницы авторизации")
	public void openLoginPage() {
		mainPage.clickLoginButton().checkTitle();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Открытие страницы регистрации")
	public void openRegistrationPage() {
		mainPage.clickLoginButton().clickRegistrationButton().checkTitle();
	}
}

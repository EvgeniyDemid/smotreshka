package ru.smotreshka.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import ru.smotreshka.ui.tests.pages.CommonElement;
import ru.smotreshka.ui.tests.pages.LoginPage;
import ru.smotreshka.ui.tests.pages.MainPage;

@Owner("Demidov")
public class RegistrationTest extends TestBase {
	MainPage mainPage = new MainPage();
	CommonElement commonElement = new CommonElement();
	LoginPage loginPage = new LoginPage();

	@Test
	@Description("Проверить, что кнопка войти отображается на главной странице")
	public void checkLoginButtonIsVisible() {
		mainPage.checkLoginButton();
	}

	@Test
	@Description("Открытие страницы авторизации")
	public void openLoginPage() {
		mainPage.clickButton("Вход");
		commonElement.checkTitle("Регистрация");
	}

	@Test
	@Description("Открытие страницы регистрации")
	public void openRegistrationPage() {
		mainPage.clickButton("Вход");
		mainPage.clickButton("Регистрация");
		loginPage.clickAgreeWithConditions();
		commonElement.checkTitle("Регистрация");
	}
}
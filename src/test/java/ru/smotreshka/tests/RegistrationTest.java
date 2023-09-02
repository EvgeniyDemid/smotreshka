package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.ui.pages.CommonElement;
import ru.smotreshka.ui.pages.LoginPage;
import ru.smotreshka.ui.pages.MainPage;

@Owner("Demidov")
@Tag("ui")
public class RegistrationTest extends BaseTest {
	private final MainPage mainPage = new MainPage();
	private final CommonElement commonElement = new CommonElement();
	private final LoginPage loginPage = new LoginPage();

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

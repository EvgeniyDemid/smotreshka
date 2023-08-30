package ru.smotreshka.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
	MainPage mainPage = new MainPage();

	private static final SelenideElement byLoginButton = $(byText("По логину"));
	private static final SelenideElement loginInput = $("[class='input medium'][type='text']");
	private static final SelenideElement passwordInput = $("[class='input medium'][type='password']");
	private static final SelenideElement nextButton = $("button[type='submit']");
	private static final SelenideElement nextInGreetingsButton = $("[class='button default overlay-default-before light primary']");
	private static final SelenideElement childProfileButton = $(byText("Детский"));
	private static final SelenideElement agreeWithConditions = $("[class^='button default overlay-default-before light primary']");

	@Step("Авторизация по логину и паролю")
	public void loginByMobileAndPassword(String login, String password) {
		mainPage.clickLoginButton();
		byLoginButton.click();
		loginInput.setValue(login);
		passwordInput.setValue(password);
		nextButton.click();
		nextInGreetingsButton.click();
		childProfileButton.click();
	}
	@Step("Нажать на кнопку Я согласен с условиями")
	public void clickAgreeWithConditions(){
		agreeWithConditions.click();
	}
}

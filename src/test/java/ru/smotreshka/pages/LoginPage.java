package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
	SelenideElement title = $(byText("Вход"));
	SelenideElement registrationButton = $(byText("Регистрация"));

	@Step("Проверить, что отображается название страницы авторизации")
	public LoginPage checkTitle() {
		title.shouldBe(visible).shouldHave(text("Вход"));
		return new LoginPage();
	}
	@Step("Нажать на кнопку регистрации")
	public RegistrationPage clickRegistrationButton(){
		registrationButton.shouldBe(visible).click();
		return new RegistrationPage();
	}

}

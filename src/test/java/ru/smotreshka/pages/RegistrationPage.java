package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
	SelenideElement title = $(byText("Регистрация"));

	@Step("Проверить, что отображается название страницы регистрации")
	public LoginPage checkTitle() {
		title.shouldBe(visible).shouldHave(text("Регистрация"));
		return new LoginPage();
	}
}

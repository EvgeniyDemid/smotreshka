package ru.smotreshka.ui.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
	SelenideElement loginButton = $(byText("Вход"));

	@Step("Открыть главную страницу")
	public void openPage() {
		Selenide.open("");
	}

	@Step("Проверить, что кнопка Войти отображается на главной странице")
	public void checkLoginButton() {
		loginButton.shouldBe(visible);
	}

	@Step("Нажать на кнопку {buttonName}")
	public void clickButton(String buttonName) {
		$(byText(buttonName)).click();
	}

	@Step("Нажать на Войти на главной странице")
	public void clickLoginButton() {
		loginButton.click();
	}
}
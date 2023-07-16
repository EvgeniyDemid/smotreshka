package ru.smotreshka.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
	SelenideElement loginButton = $(byText("Вход"));

	@Step("Открыть главную страницу")
	public MainPage openPage() {
		Selenide.open("");
		return new MainPage();
	}

	@Step("Проверить, что кнопка Войти отображается на главной странице")
	public MainPage checkLoginButton() {
		loginButton.shouldBe(visible);
		return new MainPage();
	}

	@Step("Нажать на кнопку {buttonName}")
	public void clickButton(String buttonName) {
		$(byText(buttonName)).click();
	}

}

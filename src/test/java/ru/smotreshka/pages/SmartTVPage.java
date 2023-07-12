package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SmartTVPage {
	SelenideElement chooseContainer = $(byText("Выберите производителя"));

	@Step("Проверить, что отображается выбора производителя")
	public WatchingTVPage checkTitle() {
		chooseContainer.shouldBe(visible).shouldHave(text("Выберите производителя"));
		return new WatchingTVPage();
	}
}

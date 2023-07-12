package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WatchingTVPage {
	SelenideElement title = $(byText("Смотреть ТВ"));

	@Step("Проверить, что отображается название страницы Смотреть ТВ")
	public WatchingTVPage checkTitle() {
		title.shouldBe(visible).shouldHave(text("Смотреть ТВ"));
		return new WatchingTVPage();
	}
}

package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class СinemaPage {
	SelenideElement title = $(byText("КИНО"));

	@Step("Проверить, что отображается название страницы КИНО")
	public MoviePage checkTitle() {
		title.shouldBe(visible).shouldHave(text("КИНО"));
		return new MoviePage();
	}
}

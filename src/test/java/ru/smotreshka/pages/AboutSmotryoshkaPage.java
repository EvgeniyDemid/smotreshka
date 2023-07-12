package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AboutSmotryoshka {
	SelenideElement title = $(byText("Познакомьтесь со Смотрёшкой"));

	@Step("Проверить, что отображается название страницы О Смотрёшке")
	public MoviePage checkTitle() {
		title.shouldBe(visible).shouldHave(text("Познакомьтесь со Смотрёшкой"));
		return new MoviePage();
	}
}

package ru.smotreshka.ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CommonElement {

	@Step("Проверить, что отображается название страницы {title}")
	public void checkTitle(String title) {
		$(byText(title)).shouldBe(visible);
	}
}

package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.smotreshka.pages.CommonElement;
import ru.smotreshka.pages.MainPage;

public class MainPageTests extends TestBase {
	MainPage mainPage = new MainPage();
	CommonElement commonElement = new CommonElement();


	@Owner("Demidov")
	@Tag("smoke")
	@ParameterizedTest
	@ValueSource(strings = {"Смотреть ТВ", "КИНО", "Кинотеатр", "На Smart TV", "О Смотрёшке"})
	@Description("Переход на страницу")
	public void checkPage(String pageName) {
		mainPage.clickButton(pageName);
		commonElement.checkTitle(pageName);
	}
}

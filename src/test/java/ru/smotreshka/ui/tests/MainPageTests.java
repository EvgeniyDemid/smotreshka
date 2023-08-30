package ru.smotreshka.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.smotreshka.enams.MenuBody;
import ru.smotreshka.ui.tests.pages.CommonElement;
import ru.smotreshka.ui.tests.pages.MainPage;

@Owner("Demidov")
public class MainPageTests extends TestBase {
	MainPage mainPage = new MainPage();
	CommonElement commonElement = new CommonElement();

	@ParameterizedTest
	@EnumSource(MenuBody.class)
	@Description("Переход на страницу")
	public void checkPageTitle(MenuBody pageName) {
		mainPage.clickButton(pageName.getValue());
		commonElement.checkTitle(pageName.getValue());
	}
}

package ru.smotreshka.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.smotreshka.enams.MenuBody;
import ru.smotreshka.pages.CommonElement;
import ru.smotreshka.pages.MainPage;

@Owner("Demidov")
@Tag("ui")
public class MainPageTest extends TestBase {

	private final MainPage mainPage = new MainPage();

	private final CommonElement commonElement = new CommonElement();

	@ParameterizedTest
	@EnumSource(MenuBody.class)
	@DisplayName("Переход на страницу")
	public void checkPageTitle(MenuBody pageName) {
		mainPage.clickButton(pageName.getValue());
		commonElement.checkTitle(pageName.getValue());
	}
}

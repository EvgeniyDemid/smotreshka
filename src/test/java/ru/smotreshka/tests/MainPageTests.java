package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.pages.MainPage;

public class MainPageTests extends TestBase {
	MainPage mainPage = new MainPage();

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Переход на страницу Смотреть ТВ")
	public void checkGotoWatchingTVPage() {
		mainPage.clickWatchingTVButton().checkTitle();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Переход на страницу КИНО")
	public void checkGotoCinemaPage() {
		mainPage.clickCinemaButton().checkTitle();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Переход на страницу Кинотеатр")
	public void checkGotoMoviePage() {
		mainPage.clickMovieButton().checkTitle();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Переход на страницу На Smart TV")
	public void checkGotoSmartTV() {
		mainPage.clickSmartTVButton().checkTitle();
	}

	@Test
	@Owner("Demidov")
	@Tag("smoke")
	@Description("Переход на страницу О Смотрёшке")
	public void checkGotoSmotryoshkaPage() {
		mainPage.clickSmotryoshkaButton().checkTitle();
	}
}

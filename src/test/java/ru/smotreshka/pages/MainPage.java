package ru.smotreshka.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
	SelenideElement loginButton = $(byText("Вход"));
	SelenideElement watchingTVButton = $(byText("Смотреть ТВ"));
	SelenideElement cinemaButton = $(byText("КИНО"));
	SelenideElement movieButton = $(byText("Кинотеатр"));
	SelenideElement smartTVButton = $(byText("На Smart TV"));
	SelenideElement smotryoshkaButton = $(byText("О Смотрёшке"));

	@Step("Открыть главную страницу")
	public MainPage openPage(){
		Selenide.open("");
		return new MainPage();
	}

	@Step("Проверить, что кнопка Войти отображается на главной странице")
	public MainPage checkLoginButton() {
		loginButton.shouldBe(visible);
		return new MainPage();
	}

	@Step("Нажать на кнопку Войти")
	public LoginPage clickLoginButton() {
		loginButton.shouldBe(visible).click();
		return new LoginPage();
	}

	@Step("Нажать на кнопку Смотреть ТВ в верхнем меню")
	public WatchingTVPage clickWatchingTVButton(){
		watchingTVButton.click();
		return new WatchingTVPage();
	}
	@Step("Нажать на кнопку КИНО в верхнем меню")
	public СinemaPage clickCinemaButton(){
		cinemaButton.click();
		return new СinemaPage();
	}
	@Step("Нажать на кнопку Кинотеатр в верхнем меню")
	public MoviePage clickMovieButton(){
		movieButton.click();
		return new MoviePage();
	}
	@Step("Нажать на кнопку О Смотрёшке в верхнем меню")
	public AboutSmotryoshkaPage clickSmotryoshkaButton(){
		smotryoshkaButton.click();
		return new AboutSmotryoshkaPage();
	}
	@Step("Нажать на кнопку На Smart TV в верхнем меню")
	public SmartTVPage clickSmartTVButton(){
		smartTVButton.click();
		return new SmartTVPage();
	}
}

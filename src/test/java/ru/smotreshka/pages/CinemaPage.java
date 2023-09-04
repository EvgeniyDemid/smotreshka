package ru.smotreshka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.smotreshka.api.pojo.movie.MoviePremRes;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CinemaPage {

	private final SelenideElement titleMoviePremier = $(By.xpath("//hgroup[@class='title-hgroup']/h2")),
			yearMoviePremier = $(By.xpath("//div[@class='title-details-info-with-icon year mr-32 dark']")),
			countryMoviePremier = $(By.xpath("//div[@class='title-details-info-with-icon country mr-32 dark']")),
			categoriesMoviePremier = $(By.xpath("(//div[@class='categories title-details-info vod light']/span)[2]")),
			genresMoviePremier = $(By.xpath("(//div[@class='genres title-details-info vod light']/span)[2]")),
			ageMoviePremier = $(".age"),
			descriptionMoviePremier = $(By.xpath("//div[@class='text-with-truncation light body1']/div"));

	@Step("Проверить отображение информации фильма Premier")
	public void checkMoviePremier(MoviePremRes moviePremRes) {
		step("Проверка названия фильма", () ->
				titleMoviePremier.shouldBe(visible).shouldHave(text(moviePremRes.getPreview().getTitle())));
		step("Проверка год выпуска фильма", () ->
				yearMoviePremier.shouldHave(text(moviePremRes.getPreview().getYears().get(0).toString())));
		step("Проверка страны фильма", () -> {
			for (MoviePremRes.Country country : moviePremRes.getPreview().getCountries()) {
				countryMoviePremier.shouldHave(text(country.getTitle()));
			}
		});
		step("Проверка категорий фильма", () -> {
			for (MoviePremRes.Category categories : moviePremRes.getPreview().getCategories()) {
				categoriesMoviePremier.shouldHave(text(categories.getTitle()));
			}
		});
		step("Проверка жанр фильма", () -> {
			for (MoviePremRes.Genre genre : moviePremRes.getPreview().getGenres()) {
				genresMoviePremier.shouldHave(text(genre.getTitle()));
			}
		});
		step("Проверить с какого возраста можно смотреть этот фильм", () ->
				ageMoviePremier.shouldHave(text(moviePremRes.getPreview().getAgeRating())));
		step("Проверить описание фильма", () ->
				descriptionMoviePremier.shouldHave(text(moviePremRes.getDetails().getDescription())));
	}
}


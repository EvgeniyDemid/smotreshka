package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.smotreshka.api.pojo.movie.MoviePremRes;
import ru.smotreshka.ui.pages.CinemaPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.smotreshka.api.specs.CinemaSpec.cinemaMovieListResponseSpec;
import static ru.smotreshka.api.specs.CinemaSpec.cinemaMoviePremResponseSpec;
import static ru.smotreshka.api.specs.CommonSpec.requestSpec;

@Owner("Demidov")
@Tag("api")
public class CinemaTest extends TestBase {

	private final CinemaPage cinemaPage = new CinemaPage();

	@Test
	@DisplayName("Проверить информации о популярных фильмах.")
	@Description("Проверить информации о популярных фильмах")
	public void movieInformation() {
		List<String> moviesId = step("Получить список id всех фильмов", () ->
				RestAssured
						.given(requestSpec)
						.when()
						.get("vod/v2/ivi/titles/")
						.then()
						.spec(cinemaMovieListResponseSpec)
						.extract()
						.response()
						.path("titles.id"));
		step("Проверить, что во всех фильмах присутствует описание", () -> {
			for (String id : moviesId) {
				RestAssured
						.given(requestSpec)
						.when()
						.get("vod/v2/ivi/titles/" + id)
						.then()
						.spec(cinemaMoviePremResponseSpec);
				;
			}
		});
	}

	@Test
	@DisplayName("Проверить, что данные полученные по api корректно отображается на ui для фильмов premier")
	public void checkCinemaPremier() {
		List<MoviePremRes> movieInfoResList = new ArrayList<>();
		List<String> moviesId = step("Получить список id  фильмов", () ->
				RestAssured
						.given(requestSpec)
						.when()
						.param("limit", 3)
						.get("/vod/v2/premier/titles")
						.then()
						.spec(cinemaMovieListResponseSpec)
						.extract()
						.response()
						.path("titles.id"));

		for (String id : moviesId) {
			MoviePremRes movieInfo = step("Получить информацию о фильме по id = " + id, () ->
					RestAssured
							.given(requestSpec)
							.when()
							.get("vod/v2/premier/titles/" + id)
							.then()
							.spec(cinemaMoviePremResponseSpec)
							.extract()
							.response()
							.as(MoviePremRes.class));
			movieInfoResList.add(movieInfo);
		}

		for (MoviePremRes movieRes : movieInfoResList) {
			step("Проверить отображение фильма " + movieRes.getPreview().getTitle(), () -> {
				open("vod/premier/" + movieRes.getPreview().getId());
				cinemaPage.checkMoviePremier(movieRes);
			});

		}
	}
}

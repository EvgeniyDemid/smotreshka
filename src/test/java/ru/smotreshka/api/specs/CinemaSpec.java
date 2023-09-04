package ru.smotreshka.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.core.IsNull.notNullValue;

public class CinemaSpec {

	public static ResponseSpecification cinemaMoviePremResponseSpec = new ResponseSpecBuilder()
			.log(ALL)
			.expectStatusCode(200)
			.expectBody("preview.id", notNullValue())
			.expectBody("preview.title", notNullValue())
			.expectBody("preview.posters", notNullValue())
			.expectBody("preview.genres", notNullValue())
			.expectBody("preview.categories", notNullValue())
			.expectBody("preview.ageRating", notNullValue())
			.expectBody("preview.ratingImdb", notNullValue())
			.expectBody("preview.ratingKp", notNullValue())
			.expectBody("preview.ratingSource", notNullValue())
			.expectBody("preview.years", notNullValue())
			.expectBody("preview.countries", notNullValue())
			.expectBody("preview.hasSeries", notNullValue())
			.expectBody("preview.brandingMethods", notNullValue())
			.expectBody("details", notNullValue())
			.build();

	public static ResponseSpecification cinemaMovieListResponseSpec = new ResponseSpecBuilder()
			.log(ALL)
			.expectStatusCode(200)
			.expectBody("titles", notNullValue())
			.build();
}

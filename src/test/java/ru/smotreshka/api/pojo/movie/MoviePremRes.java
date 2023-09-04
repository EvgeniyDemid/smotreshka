package ru.smotreshka.api.pojo.movie;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MoviePremRes {

	private Preview preview;
	private Details details;

	@Data
	public static class Season {
		private String id;
		private int number;
		private String title;
	}

	@Data
	public static class Thumbnail {
		private String type;
		private String path;
	}

	@Data
	public static class Preview {
		private String id;
		private String title;
		private ArrayList<Thumbnail> thumbnails;
		private ArrayList<Poster> posters;
		private ArrayList<Genre> genres;
		private ArrayList<Category> categories;
		private String ageRating;
		private int ratingImdb;
		private int ratingKp;
		private int ratingSource;
		private ArrayList<Integer> years;
		private ArrayList<Country> countries;
		private boolean hasSeries;
		private ArrayList<BrandingMethod> brandingMethods;
	}

	@Data
	public static class Poster {
		private String type;
		private String path;
	}

	@Data
	public static class Genre {
		private String id;
		private String title;
	}

	@Data
	public static class Details {
		private String description;
		private ArrayList<Season> seasons;
		private ArrayList<BrandingMethod> brandingMethods;
	}

	@Data
	public static class Country {
		private String id;
		private String title;
	}

	@Data
	public static class Category {
		private String id;
		private String title;
	}

	@Data
	public static class BrandingMethod {
		private String name;
		private int priority;
	}
}



package ru.smotreshka.enams;

public enum MenuBody {
	WATCH_TV("Смотреть ТВ"),
	CINEMA("КИНО"),
	MOVIE_HOUSE("Кинотеатр"),
	ON_SMART_TV("На Smart TV"),
	ABOUT_SMOTRYOSHKA("О Смотрёшке");

	private final String value;

	MenuBody(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

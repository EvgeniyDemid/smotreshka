package ru.smotreshka.enams;

public enum GenresTV {
	ALL_CHANNELS("Все каналы"),
	RECOMMENDED("Рекомендованные"),
	HD_CHANNELS("HD-каналы"),
	BABY("Детские"),
	MUSICAL("Музыкальные");

	private final String value;

	GenresTV(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}

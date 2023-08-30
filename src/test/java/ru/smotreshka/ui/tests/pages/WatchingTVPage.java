package ru.smotreshka.ui.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WatchingTVPage {
	private final SelenideElement findNameTvInput = $(By.xpath("//input[@placeholder='Название телеканала']"));
	private final ElementsCollection cardChannelOnAir = $$("[class^='tile-channel-now']");
	private final List<SelenideElement> cardChannelOnListTv = $$(".inner");
	private final SelenideElement favoritesButton = $(byText("Избранные"));
	private final ElementsCollection genresButtons = $$(".genres button");
	private final SelenideElement listTvButton = $(byText("Список каналов"));
	private final ElementsCollection favoriteButtonsOnCard = $$("[class^='button bookmark hidden-mobile-and-tablet light medium']");

	@Step("Ввести название канала {channel} в окне поиска ")
	public void setFindNameTv(String channel) {
		findNameTvInput.setValue(channel);
	}

	@Step("Проверить, что все карточки имеют название канала {channel} в прямом эфире")
	public void checkCardChannelOnAir(String channel) {
		for (SelenideElement element : cardChannelOnAir) {
			element.shouldHave(text(channel));
		}
	}

	@Step("Проверить, что все карточки имеют название канала {channel} в списке каналов")
	public void checkCardChannelOnListTv(String channel) {
		for (SelenideElement element : cardChannelOnListTv) {
			element.shouldHave(text(channel));
		}
	}

	@Step("Проверить,что спиок избранных каналов пуст")
	public void checkListFavoritesIsEmpty() {
		favoritesButton.click();
		$(byText("Список избранного пуст")).shouldBe(visible);
	}

	@Step("Проверить,что в спиоке избранных есть каналы")
	public boolean checkListFavoritesIsNotEmpty() {
		favoritesButton.click();
		return !$(byText("Список избранного пуст")).isDisplayed();
	}

	@Step("Перейти в избранное")
	public void goFavorites() {
		favoritesButton.click();
	}

	@Step("Проверить,что список каналов равен {num}")
	public void checkNumberChannel(int num) {
		assertEquals(cardChannelOnAir.size(), num, "Колличество каналов не равно " + num);
	}

	@Step("Выбрать категорию {genre}")
	public void chooseGenre(String genre) {
		genresButtons.find(text(genre)).click();
	}

	@Step("Проверить, что список каналов  не пустой")
	public void checkListOfTvIsNotEmpty() {
		assertNotEquals(cardChannelOnAir.size(), 0, "Список каналов пуст");
	}

	@Step("Нажать на кнопку избранное на карточке")
	public void clickChannelOnFavorite(int index) {
		index = index - 1;
		cardChannelOnAir.get(index).hover();
		favoriteButtonsOnCard.get(index).click();
	}

	@Step("Получить колличество каналов")
	public int getNumberChannel() {
		return cardChannelOnAir.size();
	}

	@Step("Нажать на кнопку 'Список каналов'")
	public void clickListTvButton() {
		listTvButton.click();
	}
}

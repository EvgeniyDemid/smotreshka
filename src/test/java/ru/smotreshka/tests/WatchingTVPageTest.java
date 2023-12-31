package ru.smotreshka.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.smotreshka.enams.GenresTV;
import ru.smotreshka.pages.CommonElement;
import ru.smotreshka.pages.LoginPage;
import ru.smotreshka.pages.MainPage;
import ru.smotreshka.pages.WatchingTVPage;

import static ru.smotreshka.enams.MenuBody.WATCH_TV;

@Owner("Demidov")
@Tag("ui")
public class WatchingTVPageTest extends TestBase {

	private final WatchingTVPage watchingTVPage = new WatchingTVPage();
	private final MainPage mainPage = new MainPage();
	private final CommonElement commonElement = new CommonElement();
	private final LoginPage loginPage = new LoginPage();

	@ParameterizedTest
	@EnumSource(GenresTV.class)
	@DisplayName("Проверить, что в каталоге прямого эфира и в списке каналов есть доступные каналы")
	public void checkChannelDisplayGenre(GenresTV genre) {
		mainPage.clickButton(WATCH_TV.getValue());
		commonElement.checkTitle(WATCH_TV.getValue());
		watchingTVPage.chooseGenre(genre.getValue());
		watchingTVPage.checkListOfTvIsNotEmpty();
	}

	@Test
	@DisplayName("Добавление каналов в избранное ")
	public void addChannelInFavorite() {
		loginPage.loginByMobileAndPassword(login, password);
		mainPage.clickButton(WATCH_TV.getValue());
		watchingTVPage.clearFavorite();
		mainPage.clickButton(WATCH_TV.getValue());
		watchingTVPage.checkListFavoritesIsEmpty();
		watchingTVPage.chooseGenre(GenresTV.ALL_CHANNELS.getValue());
		watchingTVPage.clickChannelOnFavorite(1);
		watchingTVPage.goFavorites();
		watchingTVPage.checkNumberChannel(1);
		watchingTVPage.clickChannelOnFavorite(1);
		watchingTVPage.checkListFavoritesIsEmpty();
	}

	@Test
	@DisplayName("Поиск каналов")
	public void findChannel() {
		String channel = "СТС";
		mainPage.clickButton(WATCH_TV.getValue());
		commonElement.checkTitle(WATCH_TV.getValue());
		watchingTVPage.setFindNameTv(channel);
		watchingTVPage.checkCardChannelOnAir(channel);
		watchingTVPage.clickListTvButton();
		watchingTVPage.checkCardChannelOnListTv(channel);
	}
}

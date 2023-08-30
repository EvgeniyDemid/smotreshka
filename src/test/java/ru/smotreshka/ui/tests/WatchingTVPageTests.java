package ru.smotreshka.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.smotreshka.enams.GenresTV;
import ru.smotreshka.ui.pages.CommonElement;
import ru.smotreshka.ui.pages.LoginPage;
import ru.smotreshka.ui.pages.MainPage;
import ru.smotreshka.ui.pages.WatchingTVPage;

import static io.qameta.allure.Allure.step;
import static ru.smotreshka.enams.MenuBody.WATCH_TV;

@Owner("Demidov")
public class WatchingTVPageTests extends TestBase {
	WatchingTVPage watchingTVPage = new WatchingTVPage();
	MainPage mainPage = new MainPage();
	CommonElement commonElement = new CommonElement();
	LoginPage loginPage = new LoginPage();


	@ParameterizedTest
	@EnumSource(GenresTV.class)
	@Description("Проверить, что в каталоге прямого эфира и в списке каналов есть доступные каналы")
	public void checkChannelDisplayGenre(GenresTV genre) {
		mainPage.clickButton(WATCH_TV.getValue());
		commonElement.checkTitle(WATCH_TV.getValue());
		watchingTVPage.chooseGenre(genre.getValue());
		watchingTVPage.checkListOfTvIsNotEmpty();
	}

	@Test
	@Description("Добавление каналов в избранное ")
	public void addChannelInFavorite() {
		String login = config.login();
		String password = config.password();
		loginPage.loginByMobileAndPassword(login, password);
		step("Очистить список избранного если он не пустой", () -> {
					mainPage.clickButton(WATCH_TV.getValue());
					if (watchingTVPage.checkListFavoritesIsNotEmpty()) {
						for (int i = 0; i < watchingTVPage.getNumberChannel(); i++) {
							watchingTVPage.clickChannelOnFavorite(1);
						}
					}
				}
		);
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
	@Description("Поиск каналов")
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

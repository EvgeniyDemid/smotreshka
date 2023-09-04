package ru.smotreshka.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import jakarta.inject.Inject;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.smotreshka.config.UserConfig;
import ru.smotreshka.enams.GenresTV;
import ru.smotreshka.ui.pages.CommonElement;
import ru.smotreshka.ui.pages.LoginPage;
import ru.smotreshka.ui.pages.MainPage;
import ru.smotreshka.ui.pages.WatchingTVPage;

import static ru.smotreshka.enams.MenuBody.WATCH_TV;

@Owner("Demidov")
@Tag("ui")
public class WatchingTVPageTests extends BaseTest {

	@Inject
	WatchingTVPage watchingTVPage;
	@Inject
	MainPage mainPage;
	@Inject
	CommonElement commonElement;
	@Inject
	LoginPage loginPage;

	static UserConfig config = ConfigFactory.create(UserConfig.class, System.getProperties());

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
		loginPage.loginByMobileAndPassword(config.login(), config.password());
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

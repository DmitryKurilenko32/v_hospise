package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.EspressoWaitUtils;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    NewsPage newsPage = new NewsPage();
    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    @Test
    public void goToPageNewsTest() {
        authorizationPage.login(authorizationPage.validLogin , authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        onView(newsPage.getButtonMenu).check(matches(isDisplayed()));
        onView(newsPage.getButtonMenu).perform(click());
        onView(newsPage.getButtonNews).check(matches(isDisplayed()));
        onView(newsPage.getButtonNews).perform(click());
        EspressoWaitUtils.waitForView(newsPage.getTextPageNews, 6000);
        onView(newsPage.getTextPageNews).check(matches(isDisplayed()));
        authorizationPage.logOut();
    }
    @Test
    public void AddNews (){
        authorizationPage.login(authorizationPage.validLogin , authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        controlPanelPage.EnterControlPanel();
        controlPanelPage.AddNews(controlPanelPage.textCategory, controlPanelPage.textCategory, controlPanelPage.textCategory);
        EspressoWaitUtils.waitForView(newsPage.getButtonMenu , 5000);
        onView(newsPage.getButtonMenu).perform(click());
        onView(newsPage.getButtonNews).perform(click());
        EspressoWaitUtils.waitForView(newsPage.getButtonDescriptionNews , 5000);
        onView(newsPage.getButtonDescriptionNews).perform(actionOnItemAtPosition(0, click()));
        EspressoWaitUtils.waitForView(newsPage.getTextDescriptionNews , 5000);
        onView(newsPage.getTextDescriptionNews).check(matches(withText("Объявление")));
        authorizationPage.logOut();
    }

}
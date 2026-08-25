package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.pages.MainPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Test
    public void mainPageAllNewsTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getButtonAllNews, 8000);
        onView(mainPage.getButtonAllNews).check(matches(isDisplayed()));
        onView(mainPage.getButtonAllNews).perform(click());
        EspressoWaitUtils.waitForView(mainPage.getTextMainPage, 8000);
        onView(mainPage.getTextMainPage).check(matches(isDisplayed()));
        authorizationPage.logOut();
    }
}

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

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Test
    public void addNewsValidTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        controlPanelPage.EnterControlPanel();
        controlPanelPage.AddNews(controlPanelPage.textCategory, controlPanelPage.textCategory, controlPanelPage.textCategory);
        EspressoWaitUtils.waitForView(controlPanelPage.getButtonOpenDescription , 5000);
        onView(controlPanelPage.getButtonOpenDescription).check(matches(isDisplayed()));
        onView(controlPanelPage.getButtonOpenDescription).perform(actionOnItemAtPosition(0, click()));
        EspressoWaitUtils.waitForView(controlPanelPage.getTextDescription , 5000);
        onView(controlPanelPage.getTextDescription).check(matches(withText(controlPanelPage.textCategory)));
        authorizationPage.logOut();

    }

}
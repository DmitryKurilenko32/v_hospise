package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.EspressoWaitUtils;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();

    @Test
    public void aboutPageVersionTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        aboutPage.goToAbout();
        onView(aboutPage.getTextVersion).check(matches(isDisplayed()));
        onView(aboutPage.getTextVersion).check(matches(withText("Version:")));
        onView(aboutPage.getVersion).check(matches(isDisplayed()));
        onView(aboutPage.getVersion).check(matches(withText("1.0.0")));
        onView(aboutPage.getButtonBack).check(matches(isDisplayed()));
        onView(aboutPage.getButtonBack).perform(click());
        EspressoWaitUtils.waitDisplayed(authorizationPage.getAuthorizationImage, 8000);
    }

    @Test
    public void intentsTestPrivacyPolicy() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        aboutPage.goToAbout();
        Intents.init();
        onView(aboutPage.getLinkPrivacyPolicy).perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Test
    public void intentsTermsUseTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        EspressoWaitUtils.waitForView(mainPage.getListNewsMain, 6000);
        aboutPage.goToAbout();
        Intents.init();
        onView(aboutPage.getLinkTermsUse).perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }
}
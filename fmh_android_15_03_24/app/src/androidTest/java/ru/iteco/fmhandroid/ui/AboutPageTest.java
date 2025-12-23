package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void aboutPageVersionTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        AboutPage aboutPage = new AboutPage();
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);

        aboutPage.getButtonMenu.check(matches(isDisplayed()));
        aboutPage.getButtonMenu.perform(click());
        aboutPage.getButtonAbout.check(matches(isDisplayed()));
        aboutPage.getButtonAbout.perform(click());
        aboutPage.getTextVersion.check(matches(isDisplayed()));
        aboutPage.getTextVersion.check(matches(withText("Version:")));
        aboutPage.getVersion.check(matches(isDisplayed()));
        aboutPage.getVersion.check(matches(withText("1.0.0")));
    }
}


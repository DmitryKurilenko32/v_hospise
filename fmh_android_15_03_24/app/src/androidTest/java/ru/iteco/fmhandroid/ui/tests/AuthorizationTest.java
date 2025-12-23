package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void succesAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage();

        authorizationPage.getAuthorLoginField.check(matches(isDisplayed()));
        authorizationPage.getAuthorLoginField.perform(replaceText(authorizationPage.validLogin), closeSoftKeyboard());

        authorizationPage.getGetAuthorPasswordField.check(matches(isDisplayed()));
        authorizationPage.getGetAuthorPasswordField.perform(replaceText(authorizationPage.validPassword), closeSoftKeyboard());
        authorizationPage.getEnterButton.check(matches(isDisplayed()));
        authorizationPage.getEnterButton.perform(click());
        authorizationPage.textPageNews.check(matches(isDisplayed()));
    }
    @Test
    public void logOutTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.logOut();
        authorizationPage.getTextPageAuthorization.check(matches(withText("Authorization")));

    }

}

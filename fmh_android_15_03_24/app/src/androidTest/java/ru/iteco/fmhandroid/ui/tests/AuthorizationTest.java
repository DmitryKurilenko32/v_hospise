package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
     private View decorView;
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @Test
    public void succesAuthorizationTest() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 8000));
        authorizationPage.getAuthorLoginField.check(matches(isDisplayed()));
        authorizationPage.getAuthorLoginField.perform(replaceText(authorizationPage.validLogin), closeSoftKeyboard());
        authorizationPage.getGetAuthorPasswordField.check(matches(isDisplayed()));
        authorizationPage.getGetAuthorPasswordField.perform(replaceText(authorizationPage.validPassword), closeSoftKeyboard());
        authorizationPage.getEnterButton.check(matches(isDisplayed()));
        authorizationPage.getEnterButton.perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 8000));
        mainPage.getTextMainPage.check(matches(isDisplayed()));
        authorizationPage.logOut();
    }
    @Test
    public void logOutTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 8000));
        authorizationPage.logOut();
        onView(isRoot()).perform(waitDisplayed(R.id.nav_host_fragment, 8000));
        authorizationPage.getTextPageAuthorization.check(matches(withText("Authorization")));

    }
    @Test
    public void emptyFields(){
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 8000));
        authorizationPage.getEnterButton.check(matches(isDisplayed()));
        authorizationPage.getEnterButton.perform(click());
        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }
    @Test
    public void simbolsInTheLoginField(){
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 9000));
       authorizationPage.login(authorizationPage.simbols , authorizationPage.validPassword);
        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

}

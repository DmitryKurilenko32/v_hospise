package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationPage {
    public ViewInteraction getAuthorLoginField;
    public ViewInteraction getGetAuthorPasswordField;
    public ViewInteraction getEnterButton;
    public ViewInteraction getLogoutButton;
    public String validLogin = "login2";
    public String validPassword = "password2";
    public ViewInteraction textPageNews;
    public ViewInteraction getButtonLogOut;

    public  ViewInteraction getButtonLogout2;

    public ViewInteraction getTextPageAuthorization;




    public AuthorizationPage() {
        getAuthorLoginField = onView(withId(R.id.login_text_input_layout));
        getGetAuthorPasswordField = onView(withId(R.id.password_text_input_layout));
        getEnterButton = onView(withId(R.id.enter_button));
        getLogoutButton = onView(withId(R.id.authorization_image_button));
        this.validLogin = validLogin;
        this.validPassword = validPassword;
        this.textPageNews = onView(withId(R.id.trademark_image_view));
        getButtonLogOut = onView(withId(R.id.authorization_image_button));
        getButtonLogout2 = onView(allOf(withId(android.R.id.title), withText("Log out")));
        getTextPageAuthorization = onView(withId(R.id.nav_host_fragment));

    }

    public void login (String login ,String password){
        getAuthorLoginField.check(matches(isDisplayed()));
        getAuthorLoginField.perform(replaceText(login), closeSoftKeyboard());
        getGetAuthorPasswordField.check(matches(isDisplayed()));
        getGetAuthorPasswordField.perform(replaceText(password), closeSoftKeyboard());
        getEnterButton.check(matches(isDisplayed()));
        getEnterButton.perform(click());
        textPageNews.check(matches(isDisplayed()));
    }
    public void logOut (){
        getButtonLogOut.check(matches(isDisplayed()));
        getButtonLogOut.perform(click());
        getButtonLogout2.check(matches(isDisplayed()));
        getButtonLogout2.perform(click());
    }
}
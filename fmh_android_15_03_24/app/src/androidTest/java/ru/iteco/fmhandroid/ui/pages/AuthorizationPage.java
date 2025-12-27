package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationPage {
    public ViewInteraction getAuthorLoginField;
    public ViewInteraction getGetAuthorPasswordField;
    public ViewInteraction getEnterButton;
    public ViewInteraction getLogoutButton;
    public String getGetTextPageAuthorizationEmpty;
    public String validLogin = "login2";
    public String validPassword = "password2";
    public String simbols = "{} [] , /";
    public ViewInteraction textPageNews;
    public ViewInteraction getButtonLogOut;

    public  ViewInteraction getButtonLogout2;

    public ViewInteraction getTextPageAuthorization;





    public AuthorizationPage() {
        getAuthorLoginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        getGetAuthorPasswordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
        getEnterButton = onView(withId(R.id.enter_button));
        validLogin = validLogin;
        validPassword = validPassword;
        simbols = simbols;
        textPageNews = onView(withId(R.id.trademark_image_view));
        getButtonLogOut = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization")));
        getButtonLogout2 = onView(allOf(withId(android.R.id.title), withText("Log out")));
        getTextPageAuthorization = onView(
                allOf(withText("Authorization"),
                        withParent(withParent(withId(R.id.nav_host_fragment)))));
        getGetTextPageAuthorizationEmpty = "Login and password cannot be empty";

    }

    public void login (String login ,String password){
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 8000));
        getAuthorLoginField.check(matches(isDisplayed()));
        getAuthorLoginField.perform(replaceText(login), closeSoftKeyboard());
        getGetAuthorPasswordField.check(matches(isDisplayed()));
        getGetAuthorPasswordField.perform(replaceText(password), closeSoftKeyboard());
        getEnterButton.check(matches(isDisplayed()));
        getEnterButton.perform(click());
    }
    public void logOut (){
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 8000));
        getButtonLogOut.check(matches(isDisplayed()));
        getButtonLogOut.perform(click());
        getButtonLogout2.check(matches(isDisplayed()));
        getButtonLogout2.perform(click());
    }
}
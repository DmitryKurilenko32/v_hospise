package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;
import android.content.Intent;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import static androidx.test.espresso.Espresso.pressBack;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    AuthorizationPage authorizationPage = new AuthorizationPage();
    AboutPage aboutPage = new AboutPage();

    @Test
    public void aboutPageVersionTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        aboutPage.goToAbout();
        aboutPage.getTextVersion.check(matches(isDisplayed()));
        aboutPage.getTextVersion.check(matches(withText("Version:")));
        aboutPage.getVersion.check(matches(isDisplayed()));
        aboutPage.getVersion.check(matches(withText("1.0.0")));
        aboutPage.getbuttonBack.check(matches(isDisplayed()));
        aboutPage.getbuttonBack.perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 8000));
        authorizationPage.logOut();
    }

    @Test
    public void intentsTestPrivacyPolicy() {
        aboutPage.goToAbout();
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        Intents.init();
        aboutPage.getLinkPrivacyPolicy.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Test
    public void intentsTermsUseTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        aboutPage.goToAbout();
        Intents.init();
        aboutPage.getLinkTermsUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }
}
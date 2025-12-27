package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ControlPanelTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    public void addNewsValidTest() {
        authorizationPage.login(authorizationPage.validLogin, authorizationPage.validPassword);
        controlPanelPage.EnterControlPanel();
        controlPanelPage.AddNews(
                controlPanelPage.textCategory, controlPanelPage.textCategory,
                controlPanelPage.textCategory);
        controlPanelPage.getButtonSort.check(matches(isDisplayed()));
        controlPanelPage.getButtonSort.perform(click());
        controlPanelPage.getButtonOpenDescription.check(matches(isDisplayed()));
        controlPanelPage.getButtonOpenDescription.perform(actionOnItemAtPosition(0, click()));
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_description_text_view, 5000));
        controlPanelPage.getTextDescription.check(matches(withText(controlPanelPage.textCategory)));
        authorizationPage.logOut();


    }
}
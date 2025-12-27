package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
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
import ru.iteco.fmhandroid.ui.pages.NewsPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    NewsPage newsPage = new NewsPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    public void goToPageNewsTest() {
        authorizationPage.login(authorizationPage.validLogin , authorizationPage.validPassword);
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 5000));
        newsPage.getButtonMenu.check(matches(isDisplayed()));
        newsPage.getButtonMenu.perform(click());
        newsPage.getButtonNews.check(matches(isDisplayed()));
        newsPage.getButtonNews.perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include, 5000));
        newsPage.getTextPageNews.check(matches(isDisplayed()));
        authorizationPage.logOut();
    }

}
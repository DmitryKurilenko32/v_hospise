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
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ControlPanelTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    @Test
    public void mainPageAllNewsTest() {
        controlPanelPage.EnterControlPanel();
        onView(isRoot()).perform(waitDisplayed(R.id.add_news_image_view, 8000));
        controlPanelPage.getButtonAddNewsControlPanel.check(matches(isDisplayed()));
        controlPanelPage.getButtonAddNewsControlPanel.perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_auto_complete_text_view, 8000));
        controlPanelPage.getButtonCategory.check(matches(isDisplayed()));
        controlPanelPage.getButtonCategory.perform(click());
        controlPanelPage.getButtonChoiceCategory.check(matches(isDisplayed()));
        controlPanelPage.getButtonChoiceCategory.perform(click());

    }
}
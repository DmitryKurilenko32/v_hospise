package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction getButtonAllNews;
    public ViewInteraction getPageAllNews;
    public ViewInteraction getTextMainPage;


    public MainPage() {
        getButtonAllNews = onView(
                allOf(withId(R.id.all_news_text_view), withText("All news")));
        getPageAllNews = onView(withId(R.id.empty_news_list_image_view));
        getTextMainPage = onView(
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include)))));



    }

}
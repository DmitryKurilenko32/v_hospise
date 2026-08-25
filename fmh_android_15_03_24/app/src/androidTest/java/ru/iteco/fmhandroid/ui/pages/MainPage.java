package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public Matcher<View> getButtonAllNews;
    public Matcher<View> getPageAllNews;
    public Matcher<View> getTextMainPage;

    public Matcher<View> getListNewsMain;


    public MainPage() {
        getButtonAllNews =
                allOf(withId(R.id.all_news_text_view), withText("All news"));
        getPageAllNews = withId(R.id.empty_news_list_image_view);
        getTextMainPage =
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include))));
        getListNewsMain = allOf(withId(R.id.container_list_news_include_on_fragment_main));


    }

}
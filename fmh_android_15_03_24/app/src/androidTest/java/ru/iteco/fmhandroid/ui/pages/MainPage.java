package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction getButtonAllNews;
    public ViewInteraction getPageAllNews;


    public MainPage() {
        getButtonAllNews = onView(withId(R.id.all_news_text_view));
        getPageAllNews = onView(withId(R.id.empty_news_list_image_view));
    }
}
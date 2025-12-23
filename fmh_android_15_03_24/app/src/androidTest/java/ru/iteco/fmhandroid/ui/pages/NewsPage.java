package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsPage {
    public ViewInteraction getButtonMenu;
    public ViewInteraction getButtonNews;

    public  ViewInteraction getTextPageNews;

    public NewsPage (){
        getButtonMenu = onView(withId(R.id.main_menu_image_button));
        getButtonNews = onView(allOf(withId(android.R.id.title), withText("News")));
        getTextPageNews = onView(allOf(withText("News"),withId(R.id.container_list_news_include)));
    }
}

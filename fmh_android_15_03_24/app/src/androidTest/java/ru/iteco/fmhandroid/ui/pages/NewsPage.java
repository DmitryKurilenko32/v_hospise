package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class NewsPage {
    public Matcher<View> getButtonMenu;
    public Matcher<View> getButtonNews;

    public Matcher<View> getTextPageNews;

    public Matcher<View> getButtonDescriptionNews;

    public Matcher<View> getTextDescriptionNews;



    public NewsPage (){
        getButtonMenu = allOf(withId(R.id.main_menu_image_button),
                withContentDescription("Main menu"));
        getButtonNews = allOf(withId(android.R.id.title), withText("News"));
        getTextPageNews =
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include))));
        getButtonDescriptionNews = allOf(withId(R.id.news_list_recycler_view),
                childAtPosition(
                        withId(R.id.all_news_cards_block_constraint_layout),
                        0));
        getTextDescriptionNews = allOf(withId(R.id.news_item_title_text_view), withText("Объявление"),
                withParent(withParent(withId(R.id.news_item_material_card_view))));

    }
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {
    public ViewInteraction getButtonMenu;
    public ViewInteraction getButtonAddNewsControlPanel;
    public ViewInteraction getButtonNews;
    public ViewInteraction getButtonAddNews;
    public ViewInteraction getButtonCategory;
    public DataInteraction getButtonChoiceCategory;
    public DataInteraction getButtonData;
    public ViewInteraction getButtonOk;
    public ViewInteraction getButtonTime;
    public ViewInteraction getButtonDescription;
    public ViewInteraction getButtonSave;

    public ControlPanelPage() {

        getButtonMenu = onView(allOf(withId(R.id.main_menu_image_button),
                withContentDescription("Main menu")));
        getButtonNews = onView(allOf(withId(android.R.id.title), withText("News")));

        getButtonAddNewsControlPanel = onView(
                allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3)));


        getButtonAddNews = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3)));


        getButtonCategory = onView(
                allOf( withContentDescription("Show dropdown menu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0)));

        getButtonChoiceCategory = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);



        getButtonData = onData(anything()).inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);

        getButtonTime = onView(allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                childAtPosition(childAtPosition(
                                withId(R.id.news_item_publish_time_text_input_layout),
                                0),
                        1)));


        getButtonOk = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));


        getButtonDescription = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text),
                        childAtPosition(childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                0)));

        getButtonSave = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
}

        public void EnterControlPanel (){
            onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 8000));
            getButtonMenu.check(matches(isDisplayed()));
            getButtonMenu.perform(click());
            getButtonNews.check(matches(isDisplayed()));
            getButtonNews.perform(click());
            onView(isRoot()).perform(waitDisplayed(R.id.edit_news_material_button, 8000));
            getButtonAddNews.check(matches(isDisplayed()));
            getButtonAddNews.perform(click());
        }
        private static Matcher<View> childAtPosition (
        final Matcher<View> parentMatcher, final int position){

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

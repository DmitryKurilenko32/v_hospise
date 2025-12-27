package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
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
    public ViewInteraction getChoiceCategory;
    public ViewInteraction getButtonData;
    public ViewInteraction getButtonOk;
    public ViewInteraction getButtonTime;
    public ViewInteraction getDescription;
    public ViewInteraction getButtonSave;
    public String textCategory = "Объявление";
    public ViewInteraction getTitle;
    public ViewInteraction getButtonSort;
    public ViewInteraction getButtonOpenDescription;
    public ViewInteraction getTextDescription;

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

        getChoiceCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_category_text_input_layout),
                                        0),
                                0)));
        getTitle = onView(withId(R.id.news_item_title_text_input_edit_text));



        getButtonData = onView(withId(R.id.news_item_publish_date_text_input_edit_text));

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


        getDescription = onView(withId(R.id.news_item_description_text_input_edit_text));

        getButtonSave = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
        getButtonSort = onView(withId(R.id.sort_news_material_button));

        getButtonOpenDescription = onView(withId(R.id.news_list_recycler_view));

        getTextDescription = onView(
                allOf(withId(R.id.news_item_description_text_view), withText("Объявление"),
                        withParent(withParent(withId(R.id.news_item_material_card_view)))));

        textCategory = textCategory;
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
        public void AddNews (String textCategory, String textTitle, String textDescription){
            onView(isRoot()).perform(waitDisplayed(R.id.add_news_image_view, 8000));
            getButtonAddNewsControlPanel.check(matches(isDisplayed()));
            getButtonAddNewsControlPanel.perform(click());
            onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_auto_complete_text_view, 8000));
            getButtonCategory.check(matches(isDisplayed()));
            getButtonCategory.perform(click());
            onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_auto_complete_text_view, 8000));
            getChoiceCategory.check(matches(isDisplayed()));
            getChoiceCategory.perform(replaceText(textCategory), closeSoftKeyboard());
            getTitle.check(matches(isDisplayed()));
            getTitle.perform(replaceText(textTitle));
            getButtonData.check(matches(isDisplayed()));
            getButtonData.perform(click());
            getButtonOk.check(matches(isDisplayed()));
            getButtonOk.perform(click());
            getButtonTime.check(matches(isDisplayed()));
            getButtonTime.perform(click());
            getButtonOk.check(matches(isDisplayed()));
            getButtonOk.perform(click());
            getDescription.check(matches(isDisplayed()));
            getDescription.perform(replaceText(textDescription));
            getButtonSave.check(matches(isDisplayed()));
            getButtonSave.perform(click());
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

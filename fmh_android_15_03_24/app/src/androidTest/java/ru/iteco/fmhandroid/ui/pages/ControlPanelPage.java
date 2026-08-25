package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.DataHelper.EspressoWaitUtils;

public class ControlPanelPage {
    public Matcher<View> getButtonMenu;
    public Matcher<View> getButtonAddNewsControlPanel;
    public Matcher<View> getButtonNews;
    public Matcher<View> getButtonAddNews;
    public Matcher<View> getButtonCategory;
    public Matcher<View> getChoiceCategory;
    public Matcher<View> getButtonData;
    public Matcher<View> getButtonOk;
    public Matcher<View> getButtonTime;
    public Matcher<View> getDescription;
    public Matcher<View> getButtonSave;
    public String textCategory = "Объявление";

    public String textCategoryHelp = "Нужна помощь";

    public Matcher<View> getTitle;
    public Matcher<View> getButtonSort;
    public Matcher<View> getButtonOpenDescription;
    public Matcher<View> getTextDescription;
    public Matcher<View> getOpenFirstNews;

    public ControlPanelPage() {

        getButtonMenu = allOf(withId(R.id.main_menu_image_button),
                withContentDescription("Main menu"));
        getButtonNews = allOf(withId(android.R.id.title), withText("News"));

        getButtonAddNewsControlPanel =
                allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3));


        getButtonAddNews =
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3));


        getButtonCategory =
                allOf( withContentDescription("Show dropdown menu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0));

        getChoiceCategory =
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_category_text_input_layout),
                                        0),
                                0));
        getTitle = withId(R.id.news_item_title_text_input_edit_text);



        getButtonData = withId(R.id.news_item_publish_date_text_input_edit_text);

        getButtonTime = allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                childAtPosition(childAtPosition(
                                withId(R.id.news_item_publish_time_text_input_layout),
                                0),
                        1));


        getButtonOk =
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3));


        getDescription = withId(R.id.news_item_description_text_input_edit_text);

        getButtonSave =
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6));
        getButtonSort = withId(R.id.sort_news_material_button);

        getButtonOpenDescription = withId(R.id.news_list_recycler_view);

        getTextDescription = allOf(withId(R.id.news_item_description_text_view), withText("Объявление"),
                withParent(withParent(withId(R.id.news_item_material_card_view))));

        getOpenFirstNews = allOf(withId(R.id.news_list_recycler_view),
                childAtPosition(
                        withId(R.id.all_news_cards_block_constraint_layout),
                        0));

        textCategory = textCategory;
}

        public void EnterControlPanel (){
            onView(getButtonMenu).check(matches(isDisplayed()));
            onView(getButtonMenu).perform(click());
            onView(getButtonNews).check(matches(isDisplayed()));
            onView(getButtonNews).perform(click());
            EspressoWaitUtils.waitForView(getButtonAddNews , 6000);
            onView(getButtonAddNews).check(matches(isDisplayed()));
            onView(getButtonAddNews).perform(click());
        }
        public void AddNews (String textCategory, String textTitle, String textDescription){
            EspressoWaitUtils.waitForView(getButtonAddNewsControlPanel , 6000);
            onView(getButtonAddNewsControlPanel).check(matches(isDisplayed()));
            onView(getButtonAddNewsControlPanel).perform(click());
            EspressoWaitUtils.waitForView(getButtonCategory , 6000);
            onView(getButtonCategory).check(matches(isDisplayed()));
            onView(getButtonCategory).perform(click());
            EspressoWaitUtils.waitForView(getChoiceCategory , 6000);
            onView(getChoiceCategory).check(matches(isDisplayed()));
            onView(getChoiceCategory).perform(replaceText(textCategory), closeSoftKeyboard());
            onView(getTitle).check(matches(isDisplayed()));
            onView(getTitle).perform(replaceText(textTitle));
            onView(getButtonData).check(matches(isDisplayed()));
            onView(getButtonData).perform(click());
            onView(getButtonOk).check(matches(isDisplayed()));
            onView(getButtonOk).perform(click());
            onView(getButtonTime).check(matches(isDisplayed()));
            onView(getButtonTime).perform(click());
            onView(getButtonOk).check(matches(isDisplayed()));
            onView(getButtonOk).perform(click());
            onView(getDescription).check(matches(isDisplayed()));
            onView(getDescription).perform(replaceText(textDescription));
            onView(getButtonSave).check(matches(isDisplayed()));
            onView(getButtonSave).perform(click());
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

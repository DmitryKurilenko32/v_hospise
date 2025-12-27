package ru.iteco.fmhandroid.ui.pages;

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
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.waitDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public ViewInteraction getButtonMenu;
    public ViewInteraction getButtonAbout;
    public ViewInteraction getTextVersion;
    public ViewInteraction getVersion;
    public  ViewInteraction getbuttonBack;

    public ViewInteraction getLinkPrivacyPolicy;
    public ViewInteraction getLinkTermsUse;

    public AboutPage (){
        getButtonMenu = onView(allOf(withId(R.id.main_menu_image_button),
                withContentDescription("Main menu")));
        getbuttonBack = onView(
                allOf(withId(R.id.about_back_image_button),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1)));
        getButtonAbout = onView(allOf(withId(android.R.id.title), withText("About")));
        getTextVersion = onView(
                allOf(withId(R.id.about_version_title_text_view), withText("Version:")));
        getVersion = onView(
                allOf(withId(R.id.about_version_value_text_view), withText("1.0.0")));
        getLinkPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        getLinkTermsUse = onView(withId(R.id.about_terms_of_use_value_text_view));
    }
    public void goToAbout (){
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button, 8000));
        getButtonMenu.check(matches(isDisplayed()));
        getButtonMenu.perform(click());
        getButtonAbout.check(matches(isDisplayed()));
        getButtonAbout.perform(click());
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

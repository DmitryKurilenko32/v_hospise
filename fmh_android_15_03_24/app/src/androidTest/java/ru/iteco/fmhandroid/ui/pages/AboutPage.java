package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    public ViewInteraction getButtonMenu;
    public ViewInteraction getButtonAbout;
    public ViewInteraction getTextVersion;
    public ViewInteraction getVersion;

    public AboutPage (){
        getButtonMenu = onView(allOf(withId(R.id.main_menu_image_button),
                withContentDescription("Main menu")));
        getButtonAbout = onView(allOf(withId(android.R.id.title), withText("About")));
        getTextVersion = onView(
                allOf(withId(R.id.about_version_title_text_view), withText("Version:")));
        getVersion = onView(
                allOf(withId(R.id.about_version_value_text_view), withText("1.0.0")));
    }
}

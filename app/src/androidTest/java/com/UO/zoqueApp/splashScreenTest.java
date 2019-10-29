package com.UO.zoqueApp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class splashScreenTest {

    @Rule
    public ActivityTestRule<splashScreen> mActivityTestRule = new ActivityTestRule<>(splashScreen.class);

    @Test
    public void splashScreenTest() {
        ViewInteraction materialEditText = onView(
                allOf(withId(R.id.correo), withText("t1mk1ll3r4ll@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                15),
                        isDisplayed()));
        materialEditText.perform(pressImeActionButton());

        ViewInteraction materialEditText2 = onView(
                allOf(withId(R.id.correo), withText("t1mk1ll3r4ll@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                15),
                        isDisplayed()));
        materialEditText2.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.IniciarFormBut),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        4),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        0),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction floatingActionButton3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        1),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction floatingActionButton4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        4),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        2),
                        isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction floatingActionButton6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        3),
                        isDisplayed()));
        floatingActionButton6.perform(click());

        ViewInteraction floatingActionButton7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.fab),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        2)),
                        4),
                        isDisplayed()));
        floatingActionButton7.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.botonIrACurso), withText("Ir al curso"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.botonNxt), withText("siguiente"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.botonIrACurso), withText("Ir al curso"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.v4.widget.NestedScrollView")),
                                        0),
                                5),
                        isDisplayed()));
        appCompatButton13.perform(click());
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

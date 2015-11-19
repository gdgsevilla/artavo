package com.artavo.app.tests;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.artavo.app.EventsCreatedActivity;
import com.artavo.app.R;
import com.artavo.app.module.ArtavoAppMock;
import com.artavo.app.module.MockEndpointPresenterModule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.artavo.app.CustomMatchers.nthChildOf;

@RunWith(AndroidJUnit4.class)
public class EventsCreatedActivityTest {

    @Rule
    public ActivityTestRule<EventsCreatedActivity> activityRule = new ActivityTestRule<>(EventsCreatedActivity.class, true, false);

    @Before
    public void setUp() {
        final MockEndpointPresenterModule mockEndpointPresenterModule = new MockEndpointPresenterModule();

        ArtavoAppMock artavoApplication = (ArtavoAppMock) InstrumentationRegistry.getTargetContext().getApplicationContext();

        artavoApplication.initTestAppComponentWith(mockEndpointPresenterModule);
    }

    @Test
    public void shouldDisplayTheEventNameInARow() {
        // given:
        activityRule.launchActivity(new Intent());

        // when:
        onView(ViewMatchers.withId(R.id.fetchEvents)).perform(click());

        // then:
        onView(nthChildOf(withId(R.id.eventList), 0)).check(matches(withText("Max Firtman en Sevilla!")));
    }
}

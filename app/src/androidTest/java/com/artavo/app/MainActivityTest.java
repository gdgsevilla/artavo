package com.artavo.app;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.artavo.app.meetup.MeetupEvent;
import com.artavo.app.meetup.MeetupGroup;
import com.artavo.app.meetup.MeetupRating;
import com.artavo.app.meetup.MeetupVenue;
import dagger.Component;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.artavo.app.CustomMatchers.hasItemsCount;
import static com.artavo.app.CustomMatchers.nthChildOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Inject
    EventsFetcher eventsFetcher;

    private MeetupEvent defaultEvent;

    @Singleton
    @Component(modules = MockMeetupModule.class)
    public interface TestComponent extends MeetupComponent {
        void inject(MainActivityTest mainActivityTest);
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        App app = (App) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component = DaggerMainActivityTest_TestComponent.builder()
            .mockMeetupModule(new MockMeetupModule())
            .build();
        app.setComponent(component);
        component.inject(this);

        MeetupVenue venue = new MeetupVenue("es", "Sevilla", "Avenida de Grecia 8, 41012", "Geographica", -5.984609, 24141625, 37.351486, false);
        MeetupRating rating = new MeetupRating(1, 5);
        MeetupGroup group = new MeetupGroup("open", 1444057312000L, "GDGSevilla", -5.980000019073486, 18997976, "GDGSevilla", 37.400001525878906, "Members");
        defaultEvent = new MeetupEvent(7200000, venue, 30, 21, "public", 0, 1444379399000L, rating, 0, "Event's description", "http://www.meetup.com/GDGSevilla/events/225942541/", 29, 10800000, true, "Max Firtman en Sevilla!",
            "225942541", 1445702400000L, 1445803173000L, group, "past");
    }

    @Test
    public void shouldHaveTheSameEventsCountThatRetrieved() {
        // given:
        MainActivity mainActivity = activityRule.launchActivity(new Intent());

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                ((MainActivity) invocation.getArguments()[1]).onEvents(Arrays.asList(defaultEvent));
                return null;
            }
        }).when(eventsFetcher).getEventsFrom("18997976", mainActivity);


        // when:
        onView(withId(R.id.fetchEvents)).perform(click());

        // then:
        onView(withId(R.id.eventList)).check(hasItemsCount(1));
    }

    @Test
    public void shouldDisplayTheEventNameInARow() {
        // given:
        MainActivity mainActivity = activityRule.launchActivity(new Intent());

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                ((MainActivity) invocation.getArguments()[1]).onEvents(Arrays.asList(defaultEvent));
                return null;
            }
        }).when(eventsFetcher).getEventsFrom("18997976", mainActivity);


        // when:
        onView(withId(R.id.fetchEvents)).perform(click());

        // then:
        onView(nthChildOf(withId(R.id.eventList), 0)).check(matches(withText("Max Firtman en Sevilla!")));
    }
}

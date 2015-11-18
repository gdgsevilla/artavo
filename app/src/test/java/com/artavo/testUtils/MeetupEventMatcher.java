package com.artavo.testUtils;

import com.artavo.core.model.meetup.MeetupEvent;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class MeetupEventMatcher extends TypeSafeDiagnosingMatcher<MeetupEvent> {

    @Factory
    public static Matcher<MeetupEvent> hasTheSameEventId(MeetupEvent expectedEvent) {
        return new MeetupEventMatcher(expectedEvent);
    }

    private final MeetupEvent expectedEvent;

    public MeetupEventMatcher(final MeetupEvent expectedEvent) {
        this.expectedEvent = expectedEvent;
    }

    @Override
    protected boolean matchesSafely(final MeetupEvent item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item.getId());
        return expectedEvent.getId().equals(item.getId());
    }

    @Override
    public void describeTo(final Description description) {
        description.appendValue(expectedEvent.getId());
    }
}

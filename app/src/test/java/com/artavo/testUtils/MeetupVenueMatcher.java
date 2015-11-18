package com.artavo.testUtils;

import com.artavo.core.model.meetup.MeetupVenue;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class MeetupVenueMatcher extends TypeSafeDiagnosingMatcher<MeetupVenue> {

    private final MeetupVenue expectedEventVenue;

    @Factory
    public static Matcher<MeetupVenue> hasTheSameVenueId(final MeetupVenue expectedEventVenue) {
        return new MeetupVenueMatcher(expectedEventVenue);
    }

    private MeetupVenueMatcher(final MeetupVenue expectedEventVenue) {
        this.expectedEventVenue = expectedEventVenue;
    }

    @Override
    protected boolean matchesSafely(final MeetupVenue item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item.getId());
        return expectedEventVenue.getId() == item.getId();
    }

    @Override
    public void describeTo(final Description description) {
        description.appendValue(expectedEventVenue.getId());
    }
}

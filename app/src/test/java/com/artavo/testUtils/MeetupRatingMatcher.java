package com.artavo.testUtils;

import com.artavo.core.model.meetup.MeetupRating;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class MeetupRatingMatcher extends TypeSafeDiagnosingMatcher<MeetupRating> {
    private final MeetupRating expectedEventRating;

    @Factory
    public static Matcher<MeetupRating> hasTheSameCount(final MeetupRating expectedRating) {
        return new MeetupRatingMatcher(expectedRating);
    }

    private MeetupRatingMatcher(final MeetupRating expectedEventRating) {
        this.expectedEventRating = expectedEventRating;
    }

    @Override
    protected boolean matchesSafely(final MeetupRating item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item.getCount());
        return expectedEventRating.getCount() == item.getCount();
    }

    @Override
    public void describeTo(final Description description) {
        description.appendValue(expectedEventRating.getCount());
    }
}

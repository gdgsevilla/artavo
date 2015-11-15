package com.artavo.app.meetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThat;

public class MeetupEventsResponseTest {

    @Test
    public void shouldParseEventsProperly() throws IOException {
        // given:
        ObjectMapper objectMapper = new ObjectMapper();
        MeetupVenue venue = new MeetupVenue("es", "Sevilla", "Avenida de Grecia 8, 41012", "Geographica", -5.984609, 24141625, 37.351486, false);
        MeetupRating rating = new MeetupRating(1, 5);
        MeetupGroup group = new MeetupGroup("open", 1444057312000L, "GDGSevilla", -5.980000019073486, 18997976, "GDGSevilla", 37.400001525878906, "Members");
        MeetupEvent expectedEvent = new MeetupEvent(7200000, venue, 30, 21, "public", 0, 1444379399000L, rating, 0, "Event's description", "http://www.meetup.com/GDGSevilla/events/225942541/", 29, 10800000, true, "Max Firtman en Sevilla!",
                "225942541", 1445702400000L, 1445803173000L, group, "past");

        // when:
        final MeetupEvent actualMeetupEvent = objectMapper.readValue(getClass().getResource("/meetup/eventsResponse.json"), MeetupEventsResponse.class).getResults().get(0);

        // then:
        assertThat(actualMeetupEvent, new MeetupEventMatcher(expectedEvent));
        assertThat(actualMeetupEvent.getVenue(), new MeetupVenueMatcher(expectedEvent.getVenue()));
        assertThat(actualMeetupEvent.getRating(), new MeetupRatingMatcher(expectedEvent.getRating()));
    }

    private static class MeetupEventMatcher extends TypeSafeDiagnosingMatcher<MeetupEvent> {
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

    private class MeetupVenueMatcher extends TypeSafeDiagnosingMatcher<MeetupVenue> {
        private final MeetupVenue expectedEventVenue;

        public MeetupVenueMatcher(final MeetupVenue expectedEventVenue) {
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

    private class MeetupRatingMatcher extends TypeSafeDiagnosingMatcher<MeetupRating> {
        private final MeetupRating expectedEventRating;

        public MeetupRatingMatcher(final MeetupRating expectedEventRating) {
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
}
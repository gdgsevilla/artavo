package com.artavo.app.meetup;

import com.artavo.app.testUtils.MeetupEventTestBuilder;
import com.artavo.core.model.meetup.MeetupEvent;
import com.artavo.core.model.meetup.MeetupEventsResponse;
import com.artavo.core.model.meetup.MeetupGroup;
import com.artavo.core.model.meetup.MeetupRating;
import com.artavo.core.model.meetup.MeetupVenue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static com.artavo.app.testUtils.MeetupEventMatcher.hasTheSameEventId;
import static com.artavo.app.testUtils.MeetupRatingMatcher.hasTheSameCount;
import static com.artavo.app.testUtils.MeetupVenueMatcher.hasTheSameVenueId;
import static org.junit.Assert.assertThat;

public class MeetupEventsResponseTest {

    @Test
    public void shouldParseEventsProperly() throws IOException {
        // given:
        ObjectMapper objectMapper = new ObjectMapper();
        MeetupVenue venue = new MeetupVenue("es", "Sevilla", "Avenida de Grecia 8, 41012", "Geographica", -5.984609, 24141625, 37.351486, false);
        MeetupRating rating = new MeetupRating(1, 5);
        MeetupGroup group = new MeetupGroup("open", 1444057312000L, "GDGSevilla", -5.980000019073486, 18997976, "GDGSevilla", 37.400001525878906, "Members");
        MeetupEvent expectedEvent = new MeetupEventTestBuilder().id("225942541").group(group).venue(venue).rating(rating).build();

        // when:
        final MeetupEvent actualMeetupEvent = objectMapper.readValue(getClass().getResource("/meetup/eventsResponse.json"), MeetupEventsResponse.class).getResults().get(0);

        // then:
        assertThat(actualMeetupEvent, hasTheSameEventId(expectedEvent));
        assertThat(actualMeetupEvent.getVenue(), hasTheSameVenueId(expectedEvent.getVenue()));
        assertThat(actualMeetupEvent.getRating(), hasTheSameCount(expectedEvent.getRating()));
    }

}
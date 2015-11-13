package com.artavo.app.meetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConnectorSpecs {

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
        MeetupEvent actualMeetupEvent = objectMapper.readValue(getClass().getResource("/meetup/eventsResponse.json"), MeetupEventsResponse.class).getResults().get(0);

        // then:
        assertEquals(expectedEvent, actualMeetupEvent);
    }
}

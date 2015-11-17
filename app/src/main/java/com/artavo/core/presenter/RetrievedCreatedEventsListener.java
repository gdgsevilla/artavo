package com.artavo.core.presenter;

import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public interface RetrievedCreatedEventsListener {
    void retrievedCreatedEvents(final List<MeetupEvent> meetupEvents);
}

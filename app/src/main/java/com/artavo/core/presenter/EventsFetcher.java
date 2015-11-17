package com.artavo.core.presenter;

import com.artavo.core.model.meetup.MeetupGroup;

import java.util.Set;

public interface EventsFetcher {

    void fetchCreatedEventsFor(String groupId, EventsListener listener);

    void fetchCreatedEventsFor(Set<MeetupGroup> groups, RetrievedCreatedEventsListener retrievedCreatedEventsListener);
}

package com.artavo.core.presenter;

import com.artavo.core.model.meetup.MeetupEvent;
import com.artavo.core.model.meetup.MeetupGroup;

import java.util.List;
import java.util.Set;

public class EventsCreatedPresenter implements RetrievedCreatedEventsListener {

    private final EventsFetcher eventsFetcher;
    private final GroupsRepository groupRepository;
    private ViewUpdater viewUpdater;

    public EventsCreatedPresenter(final EventsFetcher eventsFetcher, final GroupsRepository groupRepository) {
        this.eventsFetcher = eventsFetcher;
        this.groupRepository = groupRepository;
    }

    public void fetchCreatedEvents(final ViewUpdater viewUpdater) {
        this.viewUpdater = viewUpdater;

        final Set<MeetupGroup> groups = groupRepository.getGroups();
        eventsFetcher.fetchCreatedEventsFor(groups, this);
    }

    @Override
    public void retrievedCreatedEvents(final List<MeetupEvent> meetupEvents) {
        //Potential transformation of meetupEvents
        viewUpdater.updateEventList(meetupEvents);
    }
}

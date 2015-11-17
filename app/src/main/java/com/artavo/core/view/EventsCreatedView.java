package com.artavo.core.view;

import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.presenter.ViewUpdater;
import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public class EventsCreatedView implements ViewUpdater {

    private final List<MeetupEvent> events;

    private final EventsCreatedPresenter eventsCreatedPresenter;

    public EventsCreatedView(final List<MeetupEvent> events, final EventsCreatedPresenter eventsCreatedPresenter) {
        this.events = events;
        this.eventsCreatedPresenter = eventsCreatedPresenter;
    }

    public void onLoadDisplayCreatedEvents(ViewUpdater viewUpdater) {
        eventsCreatedPresenter.fetchCreatedEvents(viewUpdater);
    }

    public List<MeetupEvent> getEvents() {
        return events;
    }

    @Override
    public void updateEventList(final List<MeetupEvent> meetupEvents) {
        events.addAll(meetupEvents);
    }
}

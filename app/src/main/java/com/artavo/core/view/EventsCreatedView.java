package com.artavo.core.view;

import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.presenter.ViewUpdater;
import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public class EventsCreatedView implements ViewUpdater {

    private final EventsCreatedPresenter eventsCreatedPresenter;
    private final UINotifier uiNotifier;

    public EventsCreatedView(final EventsCreatedPresenter eventsCreatedPresenter, final UINotifier uiNotifier) {
        this.eventsCreatedPresenter = eventsCreatedPresenter;
        this.uiNotifier = uiNotifier;
    }

    public void onLoadDisplayCreatedEvents(ViewUpdater viewUpdater) {
        eventsCreatedPresenter.fetchCreatedEvents(viewUpdater);
    }

    @Override
    public void updateEventList(final List<MeetupEvent> meetupEvents) {
        uiNotifier.retrievedCreatedEvents(meetupEvents);
    }
}

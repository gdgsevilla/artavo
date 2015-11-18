package com.artavo.core.view;

import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public interface UINotifier {
    void retrievedCreatedEvents(List<MeetupEvent> expectedEvents);
}

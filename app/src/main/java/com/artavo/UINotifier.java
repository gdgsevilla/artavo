package com.artavo;

import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public interface UINotifier {
    void retrievedCreatedEvents(List<MeetupEvent> expectedEvents);
}

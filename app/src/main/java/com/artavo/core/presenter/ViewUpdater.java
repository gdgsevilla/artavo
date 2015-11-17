package com.artavo.core.presenter;

import com.artavo.core.model.meetup.MeetupEvent;

import java.util.List;

public interface ViewUpdater {
    void updateEventList(List<MeetupEvent> meetupEvents);
}

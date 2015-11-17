package com.artavo.core;

import com.artavo.core.meetup.MeetupEvent;
import java.util.List;

public interface EventsListener {

    void onEvents(List<MeetupEvent> events);
}

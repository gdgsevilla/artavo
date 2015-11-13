package com.artavo.app;

import com.artavo.app.meetup.MeetupEvent;
import java.util.List;

public interface EventsListener {

    void onEvents(List<MeetupEvent> events);
}

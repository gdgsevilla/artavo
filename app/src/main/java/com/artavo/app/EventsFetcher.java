package com.artavo.app;

public interface EventsFetcher {

    void getEventsFrom(String groupId, EventsListener listener);
}

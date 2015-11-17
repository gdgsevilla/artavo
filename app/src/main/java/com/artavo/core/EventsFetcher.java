package com.artavo.core;

public interface EventsFetcher {

    void getEventsFrom(String groupId, EventsListener listener);
}

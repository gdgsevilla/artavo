package com.artavo.app.meetup;

import java.util.List;

public class MeetupEventsResponse {

    private List<MeetupEvent> results;
    private MeetupMeta meta;

    public MeetupEventsResponse() { }

    public MeetupEventsResponse(final List<MeetupEvent> results, final MeetupMeta meta) {
        this.results = results;
        this.meta = meta;
    }

    public List<MeetupEvent> getResults() {
        return results;
    }

    public void setResults(final List<MeetupEvent> results) {
        this.results = results;
    }

    public MeetupMeta getMeta() {
        return meta;
    }

    public void setMeta(final MeetupMeta meta) {
        this.meta = meta;
    }
}

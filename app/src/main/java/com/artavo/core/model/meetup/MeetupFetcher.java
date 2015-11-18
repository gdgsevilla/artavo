package com.artavo.core.model.meetup;

import com.artavo.core.presenter.EventsFetcher;
import com.artavo.core.presenter.RetrievedCreatedEventsListener;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.Collections;
import java.util.Set;

public class MeetupFetcher implements EventsFetcher {

    private final MeetupEndpoint meetupEndpoint;

    public MeetupFetcher(final MeetupEndpoint meetupEndpoint) {
        this.meetupEndpoint = meetupEndpoint;
    }

    @Override
    public void fetchCreatedEventsFor(final Set<MeetupGroup> groups, final RetrievedCreatedEventsListener retrievedCreatedEventsListener) {
        for (MeetupGroup group : groups) {
            meetupEndpoint.getEventsFor(group.getId()).enqueue(new Callback<MeetupEventsResponse>() {
                @Override
                public void onResponse(final Response<MeetupEventsResponse> response, final Retrofit retrofit) {
                    retrievedCreatedEventsListener.retrievedCreatedEvents(response.body().getResults());
                }

                @Override
                public void onFailure(final Throwable t) {
                    //Todo: potentially log a message?
                    retrievedCreatedEventsListener.retrievedCreatedEvents(Collections.<MeetupEvent>emptyList());
                }
            });
        }
    }
}

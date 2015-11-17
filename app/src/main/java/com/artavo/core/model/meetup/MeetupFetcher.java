package com.artavo.core.model.meetup;

import com.artavo.core.presenter.EventsFetcher;
import com.artavo.core.presenter.EventsListener;
import com.artavo.core.presenter.RetrievedCreatedEventsListener;
import retrofit.Call;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.Set;

public class MeetupFetcher implements EventsFetcher {

    private final MeetupEndpoint service;

    public MeetupFetcher() {
        final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.meetup.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        service = retrofit.create(MeetupEndpoint.class);
    }

    @Override
    public void fetchCreatedEventsFor(String groupId, final EventsListener eventsListener) {
        Call<MeetupEventsResponse> eventsFromGroup = service.getEventsFor(Long.valueOf(groupId));
        eventsFromGroup.enqueue(new Callback<MeetupEventsResponse>() {
            @Override
            public void onResponse(final Response<MeetupEventsResponse> response, final Retrofit retrofit) {
                eventsListener.onEvents(response.body().getResults());
            }

            @Override
            public void onFailure(final Throwable t) {

            }
        });
    }

    @Override
    public void fetchCreatedEventsFor(final Set<MeetupGroup> groups, final RetrievedCreatedEventsListener retrievedCreatedEventsListener) {
        for (MeetupGroup group : groups) {
            final Call<MeetupEventsResponse> eventsForGroup = service.getEventsFor(group.getId());
            retrievedCreatedEventsListener.retrievedCreatedEvents(null);
        }
    }
}

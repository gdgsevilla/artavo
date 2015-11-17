package com.artavo.core.meetup;

import com.artavo.core.EventsFetcher;
import com.artavo.core.EventsListener;
import retrofit.Call;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MeetupConnector implements EventsFetcher {

    private final MeetupEndpoint service;

    public MeetupConnector() {
        final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.meetup.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        service = retrofit.create(MeetupEndpoint.class);
    }

    @Override
    public void getEventsFrom(String groupId, final EventsListener eventsListener) {
        Call<MeetupEventsResponse> eventsFromGroup = service.getEventsFrom(groupId);
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
}

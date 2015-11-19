package com.artavo.app.module;

import com.artavo.app.HardCodedGroupRepository;
import com.artavo.core.model.meetup.MeetupEndpoint;
import com.artavo.core.model.meetup.MeetupEventsResponse;
import com.artavo.core.presenter.GroupsRepository;
import retrofit.Call;
import retrofit.http.Query;

public class MockEndpointPresenterModule extends EventsCreatedPresenterModule {

    @Override
    public MeetupEndpoint providesMeetupEndpoint() {
        return new MeetupEndpoint() {
            @Override
            public Call<MeetupEventsResponse> getEventsFor(@Query("group_id") final long groupId) {
                throw new RuntimeException(" " + " getEventsFor " + " IMPLEMENT ME MADAFACKER! ");
            }
        };
    }

    @Override
    public GroupsRepository providesGroupRepository() {
        return new HardCodedGroupRepository();
    }
}

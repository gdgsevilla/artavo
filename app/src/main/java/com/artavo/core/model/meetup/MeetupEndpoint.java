package com.artavo.core.model.meetup;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MeetupEndpoint {

    @GET("/2/events?&sign=true&photo-host=public&status=past,upcoming&page=20")
    Call<MeetupEventsResponse> getEventsFor(@Query("group_id") long groupId);
}

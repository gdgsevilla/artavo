package com.artavo.app;

import com.artavo.app.meetup.MeetupEventsResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MeetupEndpoint {

    @GET("/2/events?&sign=true&photo-host=public&status=past,upcoming&page=20")
    Call<MeetupEventsResponse> getEventsFrom(@Query("group_id") String groupId);
}

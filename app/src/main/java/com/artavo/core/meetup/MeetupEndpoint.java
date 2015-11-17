package com.artavo.core.meetup;

import com.artavo.core.meetup.MeetupEventsResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MeetupEndpoint {

    @GET("/2/events?&sign=true&photo-host=public&status=past,upcoming&page=20")
    Call<MeetupEventsResponse> getEventsFrom(@Query("group_id") String groupId);
}

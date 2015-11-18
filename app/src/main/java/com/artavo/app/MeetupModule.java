package com.artavo.app;

import com.artavo.core.model.meetup.MeetupEndpoint;
import com.artavo.core.model.meetup.MeetupFetcher;
import com.artavo.core.presenter.EventsFetcher;
import dagger.Module;
import dagger.Provides;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

import javax.inject.Singleton;

@Module
public class MeetupModule {

    @Provides
    @Singleton
    EventsFetcher provideMeetupConnector() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.meetup.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return new MeetupFetcher(retrofit.create(MeetupEndpoint.class));
    }
}

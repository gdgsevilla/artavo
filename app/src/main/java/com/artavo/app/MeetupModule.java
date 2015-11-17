package com.artavo.app;

import com.artavo.core.EventsFetcher;
import com.artavo.core.meetup.MeetupConnector;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class MeetupModule {

    @Provides
    @Singleton
    EventsFetcher provideMeetupConnector() {
        return new MeetupConnector();
    }
}

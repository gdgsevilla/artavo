package com.artavo.app;

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

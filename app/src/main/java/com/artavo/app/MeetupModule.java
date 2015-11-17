package com.artavo.app;

import com.artavo.core.model.meetup.MeetupFetcher;
import com.artavo.core.presenter.EventsFetcher;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class MeetupModule {

    @Provides
    @Singleton
    EventsFetcher provideMeetupConnector() {
        return new MeetupFetcher();
    }
}

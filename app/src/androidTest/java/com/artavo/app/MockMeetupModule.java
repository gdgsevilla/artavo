package com.artavo.app;

import com.artavo.core.EventsFetcher;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.mockito.Mockito;

@Module
public class MockMeetupModule {

    @Provides
    @Singleton
    EventsFetcher provideEventsFetcher() {
        return Mockito.mock(EventsFetcher.class);
    }
}

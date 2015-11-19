package com.artavo.app.module;

import com.artavo.core.model.meetup.MeetupEndpoint;
import com.artavo.core.model.meetup.MeetupFetcher;
import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.presenter.GroupsRepository;
import dagger.Module;
import dagger.Provides;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

@Module
public class EventsCreatedPresenterModule {

    @Provides
    public EventsCreatedPresenter providesEventsCreatedPresenter(MeetupFetcher meetupFetcher, GroupsRepository groupsRepository) {
        return new EventsCreatedPresenter(meetupFetcher, groupsRepository);
    }

    @Provides
    public MeetupFetcher providesMeetupFetcher(MeetupEndpoint meetupEndpoint){
        return new MeetupFetcher(meetupEndpoint);
    }

    @Provides
    public MeetupEndpoint providesMeetupEndpoint(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.meetup.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(MeetupEndpoint.class);
    }

    @Provides
    public GroupsRepository providesGroupRepository(){
        return null;
    }
}
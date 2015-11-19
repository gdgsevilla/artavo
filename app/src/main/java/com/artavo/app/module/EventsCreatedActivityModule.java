package com.artavo.app.module;

import com.artavo.app.EventsCreatedActivity;
import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.view.EventsCreatedView;
import com.artavo.core.view.UINotifier;
import dagger.Module;
import dagger.Provides;

@Module
public class EventsCreatedActivityModule {

    private EventsCreatedActivity eventsCreatedActivity;

    public EventsCreatedActivityModule(EventsCreatedActivity eventsCreatedActivity) {
        this.eventsCreatedActivity = eventsCreatedActivity;
    }

    @Provides
    UINotifier provideUINotifier(){
        return eventsCreatedActivity;
    }

    @Provides
    EventsCreatedView provideEventsCreatedView(EventsCreatedPresenter presenter, UINotifier notifier){
        return new EventsCreatedView(presenter, notifier);
    }
}

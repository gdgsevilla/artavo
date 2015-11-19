package com.artavo.app.component;

import com.artavo.app.EventsCreatedActivity;
import com.artavo.app.module.EventsCreatedActivityModule;
import dagger.Subcomponent;

@Subcomponent(modules = EventsCreatedActivityModule.class)
public interface EventsCreatedActivityComponent {

    EventsCreatedActivity inject(EventsCreatedActivity eventsCreatedActivity);
}

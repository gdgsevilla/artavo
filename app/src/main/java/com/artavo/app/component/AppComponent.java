package com.artavo.app.component;

import com.artavo.app.module.AppModule;
import com.artavo.app.module.EventsCreatedActivityModule;
import com.artavo.app.module.EventsCreatedPresenterModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, EventsCreatedPresenterModule.class })
public interface AppComponent {

    EventsCreatedActivityComponent plus(EventsCreatedActivityModule module);
}

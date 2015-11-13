package com.artavo.app;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;

public class App extends Application {

    @Singleton
    @Component(modules = MeetupModule.class)
    public interface ApplicationComponent extends MeetupComponent {
    }

    private MeetupComponent component = null;

    @Override public void onCreate() {
        super.onCreate();
        if (component == null) {
            component = DaggerApp_ApplicationComponent.builder()
                .meetupModule(new MeetupModule())
                .build();
        }
    }

    public void setComponent(MeetupComponent component) {
        this.component = component;
    }

    public MeetupComponent component() {
        return component;
    }
}

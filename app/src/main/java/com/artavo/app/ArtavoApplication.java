package com.artavo.app;

import android.app.Application;
import com.artavo.app.component.AppComponent;
import com.artavo.app.component.DaggerAppComponent;
import com.artavo.app.module.AppModule;
import com.artavo.app.module.EventsCreatedPresenterModule;

public class ArtavoApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .eventsCreatedPresenterModule(new EventsCreatedPresenterModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

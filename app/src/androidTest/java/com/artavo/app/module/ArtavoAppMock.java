package com.artavo.app.module;

import com.artavo.app.ArtavoApplication;
import com.artavo.app.component.AppComponent;
import com.artavo.app.component.DaggerAppComponent;

public class ArtavoAppMock extends ArtavoApplication {

    private AppComponent appComponent;

    public void initTestAppComponentWith(final EventsCreatedPresenterModule mockEndpointPresenterModule) {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .eventsCreatedPresenterModule(mockEndpointPresenterModule)
                .build();
    }

    @Override
    public AppComponent getAppComponent() {
        return appComponent == null ? super.getAppComponent() : appComponent;
    }
}


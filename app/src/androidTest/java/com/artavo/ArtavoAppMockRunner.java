package com.artavo;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;
import com.artavo.app.module.ArtavoAppMock;

public class ArtavoAppMockRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(final ClassLoader cl, final String className, final Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, ArtavoAppMock.class.getName(), context);
    }
}

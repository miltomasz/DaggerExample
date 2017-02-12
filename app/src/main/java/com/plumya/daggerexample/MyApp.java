package com.plumya.daggerexample;

import android.app.Application;

import com.plumya.daggerexample.dagger.AppModule;
import com.plumya.daggerexample.dagger.DaggerNetComponent;
import com.plumya.daggerexample.dagger.NetComponent;
import com.plumya.daggerexample.dagger.NetModule;

/**
 * Created by miltomasz on 05/02/17.
 */

public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Dagger%COMPONENT_NAME%
        mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mNetComponent = com.codepath.dagger.components.DaggerNetComponent.create();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}

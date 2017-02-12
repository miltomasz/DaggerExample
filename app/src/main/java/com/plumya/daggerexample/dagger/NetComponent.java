package com.plumya.daggerexample.dagger;

import com.plumya.daggerexample.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by miltomasz on 29/01/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
}

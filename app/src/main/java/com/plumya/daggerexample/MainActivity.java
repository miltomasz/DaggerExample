package com.plumya.daggerexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Inject @Named("cached") OkHttpClient mOkHttpClient;
//    @Inject MyTwitterApiClient mTwitterApiClient;
    @Inject SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApp) getApplication()).getNetComponent().inject(this);
        setContentView(R.layout.activity_main);
    }
}

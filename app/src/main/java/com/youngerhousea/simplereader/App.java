package com.youngerhousea.simplereader;

import android.app.Application;
import android.os.Trace;

import dagger.hilt.android.HiltAndroidApp;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

@HiltAndroidApp
public class App extends Application {
    private void setRxJavaErrorHandler() {
        RxJavaPlugins.setErrorHandler(Throwable::printStackTrace);
    }
}

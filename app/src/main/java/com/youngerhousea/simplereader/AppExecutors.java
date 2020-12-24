package com.youngerhousea.simplereader;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.os.Looper;

import javax.inject.Singleton;

@Singleton
public class AppExecutors {
    private Executor diskIO = Executors.newSingleThreadExecutor();
    private Executor networkIO = Executors.newFixedThreadPool(3);
    private Executor mainThread = new MainThreadExecutor();

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}

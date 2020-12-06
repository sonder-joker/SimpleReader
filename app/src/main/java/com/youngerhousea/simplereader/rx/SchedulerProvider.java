package com.youngerhousea.simplereader.rx;

import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}

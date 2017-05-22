package com.splashcode.aqs.domain.usecase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;

/**
 * Decorated {@link java.util.concurrent.ThreadPoolExecutor}
 */
public class SingleThreadExecutor implements ThreadExecutor {

    private final ExecutorService executorService;

    @Inject
    public SingleThreadExecutor() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(final Runnable command) {
        executorService.execute(command);
    }
}

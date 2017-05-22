package com.splashcode.aqs.domain.usecase;

import javax.inject.Inject;

/**
 * This object is in charge of running the use case out of the UI thread using a {@link ThreadExecutor}
 */


public class UseCaseRunner {

    private final ThreadExecutor threadPoolEecutor;

    @Inject
    public UseCaseRunner(final ThreadExecutor threadPoolEecutor) {
        this.threadPoolEecutor = threadPoolEecutor;
    }

    public void run(final UseCase useCase){
        threadPoolEecutor.execute(new Runnable() {
            @Override
            public void run() {
                useCase.execute();
            }
        });
    }
}

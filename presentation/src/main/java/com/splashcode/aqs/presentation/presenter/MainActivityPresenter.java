package com.splashcode.aqs.presentation.presenter;

import com.google.common.eventbus.Subscribe;
import com.splashcode.aqs.data.eventbus.EventBus;
import com.splashcode.aqs.data.log.CustomLogger;
import com.splashcode.aqs.domain.event.answer.UserInfoAnswer;
import com.splashcode.aqs.domain.usecase.GetUserDataUseCase;
import com.splashcode.aqs.domain.usecase.UseCase;
import com.splashcode.aqs.domain.usecase.UseCaseFactory;
import com.splashcode.aqs.domain.usecase.UseCaseRunner;
import com.splashcode.aqs.presentation.view.MainActivityView;

/**
 * Presenter for the MainActivity. His role is to interact with the MainActivity in order to get
 * user interactions from the Activity and trigger back-end operations.
 *
 * The presenter is also responsible for listening to back-end callbacks and give back information
 * to the activity.
 */
public class MainActivityPresenter implements Presenter<MainActivityView> {

    private static final int YOUR_USER_ID = 1;

    private MainActivityView view;

    private final EventBus eventBus;
    private final CustomLogger customLogger;
    private final UseCaseRunner useCaseRunner;
    private final UseCaseFactory useCaseFactory;

    public MainActivityPresenter(final CustomLogger customLogger, final EventBus eventBus, final UseCaseRunner useCaseRunner, final UseCaseFactory useCaseFactory){
        this.customLogger = customLogger;
        this.eventBus = eventBus;
        this.useCaseRunner = useCaseRunner;
        this.useCaseFactory = useCaseFactory;
    }

    @Override
    public void init(final MainActivityView view) {
        this.view = view;
        this.eventBus.register(this);
        final GetUserDataUseCase getUserDataUseCase = useCaseFactory.createGetUserDataUseCase(YOUR_USER_ID);
        useCaseRunner.run(getUserDataUseCase);
    }

    @Override
    public void release() {
        this.view = null;
        this.eventBus.unregister(this);
    }

    @Subscribe
    public void onAnswerAvailable(final UserInfoAnswer answer) {
        customLogger.d("MainActivityPresenter", "UserInfoAnswer available " + answer);
    }
}

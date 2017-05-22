package com.splashcode.aqs.domain.usecase;

import com.splashcode.aqs.domain.event.ResponseType;
import com.splashcode.aqs.domain.event.answer.Answer;
import com.splashcode.aqs.domain.event.answer.AnswerFactory;
import com.splashcode.aqs.domain.event.bus.EventBusProducer;
import com.splashcode.aqs.domain.object.User;
import com.splashcode.aqs.domain.repository.UserRepository;

/**
 * Implementation of a UseCase that will get the user data from the server or from cache database
 * if user data exists.
 */
public class GetUserDataUseCase implements UseCase {

    private final int userId;
    private final AnswerFactory answerFactory;
    private final EventBusProducer eventBusProducer;
    private final UserRepository databaseDataRepository;
    private final UserRepository cloudUserRepository;

    public GetUserDataUseCase(final int userId,
                              final AnswerFactory answerFactory,
                              final EventBusProducer eventBusProducer,
                              final UserRepository databaseDataRepository,
                              final UserRepository cloudUserRepository) {
        this.userId = userId;
        this.databaseDataRepository = databaseDataRepository;
        this.cloudUserRepository = cloudUserRepository;
        this.eventBusProducer = eventBusProducer;
        this.answerFactory = answerFactory;
    }

    @Override
    public void execute() {
        ResponseType responseType = ResponseType.ERROR;
        User localUserData = databaseDataRepository.getUserData(userId);
        if(localUserData.equals(User.EMPTY)){
            localUserData = cloudUserRepository.getUserData(userId);
            if(localUserData != null) {
                responseType = ResponseType.SUCCESS;
            }
        } else {
            responseType = ResponseType.SUCCESS;
        }
        final Answer getUserAnswer = answerFactory.createGetUserAnswer(responseType, localUserData);
        eventBusProducer.post(getUserAnswer);
    }
}

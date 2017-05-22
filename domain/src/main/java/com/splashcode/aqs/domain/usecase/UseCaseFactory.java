package com.splashcode.aqs.domain.usecase;

import com.splashcode.aqs.domain.event.answer.AnswerFactory;
import com.splashcode.aqs.domain.event.bus.EventBusProducer;
import com.splashcode.aqs.domain.repository.UserRepository;

/**
 * Create {@link UseCase}
 */
public class UseCaseFactory {

    private final AnswerFactory answerFactory;
    private final EventBusProducer eventBusProducer;
    private final UserRepository databaseDataRepository;
    private final UserRepository cloudUserRepository;

    public UseCaseFactory(final AnswerFactory answerFactory, final EventBusProducer eventBusProducer, final UserRepository databaseDataRepository, final UserRepository cloudUserRepository) {
        this.answerFactory = answerFactory;
        this.eventBusProducer = eventBusProducer;
        this.databaseDataRepository = databaseDataRepository;
        this.cloudUserRepository = cloudUserRepository;
    }

    public GetUserDataUseCase createGetUserDataUseCase(final int userId){
        return new GetUserDataUseCase(userId, answerFactory, eventBusProducer, databaseDataRepository,  cloudUserRepository);
    }
}

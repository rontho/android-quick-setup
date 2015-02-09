package fr.rontho.aqs.infrastructure.com.bus;

import android.app.Activity;

import fr.rontho.aqs.infrastructure.com.Answer;
import fr.rontho.aqs.infrastructure.com.Question;
import fr.rontho.aqs.infrastructure.com.userinfo.UserInfoQuestion;

/**
 * Created by troncaglia on 09/02/2015.
 */
public interface EventBusAdapter {

    void register(final EventBusListener listener);

    void ask(final Question question);
    void respond(final Answer answer);

    void unregister(EventBusListener listener);
}

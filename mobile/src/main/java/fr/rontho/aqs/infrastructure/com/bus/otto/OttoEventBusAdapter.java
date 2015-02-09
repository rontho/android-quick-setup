package fr.rontho.aqs.infrastructure.com.bus.otto;

import android.app.Activity;

import fr.rontho.aqs.infrastructure.com.Answer;
import fr.rontho.aqs.infrastructure.com.Question;
import fr.rontho.aqs.infrastructure.com.bus.EventBusAdapter;
import fr.rontho.aqs.infrastructure.com.bus.EventBusListener;
import fr.rontho.aqs.ui.AndroidQuickSetupApplication;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class OttoEventBusAdapter implements EventBusAdapter {

    @Override
    public void register(final EventBusListener listener) {
        AndroidQuickSetupApplication.eventBus.register(listener);
    }

    @Override
    public void ask(final Question question) {
        AndroidQuickSetupApplication.eventBus.post(question);
    }

    @Override
    public void respond(final Answer answer) {
        AndroidQuickSetupApplication.eventBus.post(answer);
    }


    @Override
    public void unregister(final EventBusListener listener) {
        AndroidQuickSetupApplication.eventBus.unregister(listener);
    }
}

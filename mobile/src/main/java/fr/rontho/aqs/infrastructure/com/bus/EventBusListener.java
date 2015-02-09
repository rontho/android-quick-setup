package fr.rontho.aqs.infrastructure.com.bus;

/**
 * Created by troncaglia on 09/02/2015.
 */

import fr.rontho.aqs.infrastructure.com.Answer;

public interface EventBusListener <T extends Answer>{
    void onAnswerAvailable(final T answer);
}

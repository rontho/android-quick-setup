package com.splashcode.aqs.presentation.presenter;

import com.splashcode.aqs.data.eventbus.EventBusListener;
import com.splashcode.aqs.presentation.view.BindableView;

import java.util.EventListener;

/**
 * Presenter Interface that define the common structure for every Presenter in the app
 */
public interface Presenter<T extends BindableView> extends EventBusListener {
    void init(T view);
    void release();
}

package com.splashcode.aqs.presentation.view;

import com.splashcode.aqs.presentation.model.BindableViewModel;

/**
 * Created by troncaglia on 16/04/2017.
 */

public interface BindableView<T extends BindableViewModel> {
    void bind(T viewModel);
}

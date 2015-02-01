package com.example.view;

import com.example.view.model.ViewModel;

/**
 * Created by mario on 01.02.15.
 */
public interface View<T extends ViewModel> {
    void setModel(T model);

    T getModel();
}

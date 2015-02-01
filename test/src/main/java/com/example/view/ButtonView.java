package com.example.view;

import com.example.view.model.ButtonModel;

/**
 * Created by mario on 01.02.15.
 */
public class ButtonView implements View<ButtonModel> {
    private ButtonModel model = new ButtonModel();

    @Override
    public void setModel(ButtonModel model) {
        this.model = model;
    }

    @Override
    public ButtonModel getModel() {
        return model;
    }

    public void click() {
        model.getButtonListener().onClick();
    }
}

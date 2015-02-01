package com.example.view;

import com.example.view.model.TextFieldModel;

/**
 * Created by mario on 01.02.15.
 */
public class TextView implements View<TextFieldModel> {

    TextFieldModel model = new TextFieldModel();


    @Override
    public void setModel(TextFieldModel model) {
        this.model = model;
    }

    @Override
    public TextFieldModel getModel() {
        return model;
    }
}

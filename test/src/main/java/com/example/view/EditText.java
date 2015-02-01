package com.example.view;

import com.example.view.model.EditTextModel;

/**
 * Created by mario on 02.02.15.
 */
public class EditText implements View<EditTextModel> {
    private EditTextModel model = new EditTextModel();

    @Override
    public void setModel(EditTextModel model) {
        this.model = model;
    }

    @Override
    public EditTextModel getModel() {
        return model;
    }
}

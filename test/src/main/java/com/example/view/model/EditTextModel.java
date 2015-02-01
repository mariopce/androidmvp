package com.example.view.model;

import com.example.view.OnTextConfirmListener;

/**
 * Created by mario on 02.02.15.
 */
public class EditTextModel implements ViewModel {

    public String text;
    public OnTextConfirmListener textConfirmed;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OnTextConfirmListener getTextConfirmed() {
        return textConfirmed;
    }

    public void setTextConfirmed(OnTextConfirmListener textConfirmed) {
        this.textConfirmed = textConfirmed;
    }
}

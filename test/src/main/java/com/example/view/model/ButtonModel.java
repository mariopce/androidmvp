package com.example.view.model;

import com.example.view.OnClickListener;

/**
 * Created by mario on 01.02.15.
 */
public class ButtonModel implements ViewModel {
    private String buttonLabel;
    private OnClickListener buttonListener;

    public String getButtonLabel() {
        return buttonLabel;
    }

    public void setButtonLabel(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }

    public OnClickListener getButtonListener() {
        return buttonListener;
    }

    public void setButtonListener(OnClickListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}

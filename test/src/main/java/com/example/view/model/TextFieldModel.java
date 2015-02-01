package com.example.view.model;

/**
 * Created by mario on 01.02.15.
 */

public class TextFieldModel implements ViewModel {


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

}

package com.example.view.model;

import com.example.view.OnClickListener;
import com.example.view.OnTextConfirmListener;
import com.example.view.model.ViewModel;

/**
 * Created by mario on 01.02.15.
 */
public class ScreenModel implements ViewModel {

    private String screenTitle;

    private String giveAgeLabel;
    private int ageValue;
    private String confirmButtonText;
    private String rejectButtonText;
    private OnClickListener confirmButtonListener;
    private OnClickListener rejectButtonListener;
    private OnTextConfirmListener ageProvidedListener;

    public OnTextConfirmListener getAgeProvidedListener() {
        return ageProvidedListener;
    }

    public void setAgeProvidedListener(OnTextConfirmListener ageProvidedListener) {
        this.ageProvidedListener = ageProvidedListener;
    }

    public String getScreenTitle() {
        return screenTitle;
    }

    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
    }

    public String getGiveAgeLabel() {
        return giveAgeLabel;
    }

    public void setGiveAgeLabel(String giveAgeLabel) {
        this.giveAgeLabel = giveAgeLabel;
    }

    public int getAgeValue() {
        return ageValue;
    }

    public void setAgeValue(int ageValue) {
        this.ageValue = ageValue;
    }

    public String getConfirmButtonText() {
        return confirmButtonText;
    }

    public void setConfirmButtonText(String confirmButtonText) {
        this.confirmButtonText = confirmButtonText;
    }

    public OnClickListener getConfirmButtonListener() {
        return confirmButtonListener;
    }

    public void setConfirmButtonListener(OnClickListener confirmButtonListener) {
        this.confirmButtonListener = confirmButtonListener;
    }


    public String getRejectButtonText() {
        return rejectButtonText;
    }

    public void setRejectButtonText(String rejectButtonText) {
        this.rejectButtonText = rejectButtonText;
    }

    public OnClickListener getRejectButtonListener() {
        return rejectButtonListener;
    }

    public void setRejectButtonListener(OnClickListener rejectButtonListener) {
        this.rejectButtonListener = rejectButtonListener;
    }
}

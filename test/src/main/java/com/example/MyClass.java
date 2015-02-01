package com.example;

import com.example.view.OnClickListener;
import com.example.view.OnTextConfirmListener;
import com.example.view.ScreenView;
import com.example.view.TextView;
import com.example.view.model.ButtonModel;
import com.example.view.model.ScreenModel;
import com.example.view.model.TextFieldModel;

public class MyClass {

    public static void main(String[] args){

        ScreenView view = new ScreenView();

        ScreenModel firstScreenModel = new ScreenModel();
        firstScreenModel.setScreenTitle("Podawacz wieku");
        firstScreenModel.setAgeValue(333);
        firstScreenModel.setConfirmButtonText("Ok");
        firstScreenModel.setConfirmButtonListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("pressed ok");
            }
        });
        firstScreenModel.setAgeProvidedListener(new OnTextConfirmListener(){

            @Override
            public void onNewText(String text) {
                System.out.println("text " + text);
            }
        });
        firstScreenModel.setRejectButtonText("Cancel");
        view.setModel(firstScreenModel);
        TextView tv = view.getTitleView();
        TextFieldModel model = tv.getModel();
        ButtonModel okBmodel = view.getOkButton().getModel();
        System.out.println(okBmodel.getButtonLabel());
        view.getOkButton().click();
        System.out.println(view.getNegativeButton().getModel().getButtonLabel());
        System.out.println(view.getAgeEditText().getModel().text);

    }
}

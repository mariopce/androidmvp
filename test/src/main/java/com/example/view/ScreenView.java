package com.example.view;

import com.example.view.model.ScreenModel;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;

/**
 * Created by mario on 01.02.15.
 */
public class ScreenView implements View<ScreenModel> {

    public TextView titleView = new TextView();
    EditText ageEditText = new EditText();
    ButtonView okButton = new ButtonView();
    ButtonView negativeButton = new ButtonView();


    DozerBeanMapper mapper = new DozerBeanMapper();

    {

//        BeanMappingBuilder builder = new BeanMappingBuilder() {
//
//
//            protected void configure() {
//                mapping(ScreenModel.class, TextFieldModel.class,
//                        wildcard(false))
//                        .fields("screenTitle", "text", copyByReference());
//                mapping(ScreenModel.class, ButtonModel.class, wildcard(false), mapId("ok"))
//                        .fields("confirmButtonText", "buttonLabel", copyByReference())
//                        .fields("confirmButtonListener", "buttonListener", copyByReference());
//                mapping(ScreenModel.class, ButtonModel.class, wildcard(false), mapId("cancel"))
//                        .fields("rejectButtonText", "buttonLabel", copyByReference())
//                        .fields("rejectButtonListener", "buttonListener", copyByReference());
//                mapping(ScreenModel.class, EditTextModel.class, wildcard(false))
//                        .fields("ageValue", "text", deepHintA(Integer.class), hintB(String.class))
//                        .fields("ageProvidedListener", "textConfirmed", copyByReference())
//                ;
//            }
//        };
//        mapper.addMapping(builder);
        List myMappingFiles = new ArrayList();
        myMappingFiles.add("file:///home/mario/projects/github/englishMVP/test/src/main/resources/mapping.xml");
        mapper.setMappingFiles(myMappingFiles);
    }

    private ScreenModel model;

    @Override
    public void setModel(ScreenModel model) {
        this.model = model;
        mapper.map(model, titleView.getModel());
        mapper.map(model, okButton.getModel(), "ok");
        mapper.map(model, negativeButton.getModel(), "cancel");
        mapper.map(model, ageEditText.getModel());
    }

    @Override
    public ScreenModel getModel() {
        return model;
    }

    public TextView getTitleView() {
        return titleView;
    }

    public ButtonView getOkButton() {
        return okButton;
    }

    public ButtonView getNegativeButton() {
        return negativeButton;
    }

    public EditText getAgeEditText() {
        return ageEditText;
    }
}

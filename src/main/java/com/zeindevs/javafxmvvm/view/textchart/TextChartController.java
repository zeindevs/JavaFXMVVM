package com.zeindevs.javafxmvvm.view.textchart;

import com.zeindevs.javafxmvvm.viewmodel.textchart.TextViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextChartController {

    @FXML
    private Label eventLabel;

    @FXML
    private TextField xTextField;

    @FXML
    private TextField yTextField;

    @FXML
    private TextField zTextField;

    private TextViewModel viewModel;

    public void init(TextViewModel model) {
        viewModel = model;
        eventLabel.textProperty().bind(model.labelStringProperty());
        xTextField.textProperty().bindBidirectional(model.xStringProperty());
        yTextField.textProperty().bindBidirectional(model.yStringProperty());
        zTextField.textProperty().bindBidirectional(model.zStringProperty());
    }

    public void onUpdateButton(ActionEvent actionEvent) { viewModel.updateTextFields(); }

    public void onSaveButton(ActionEvent actionEvent) {
        try {
            viewModel.saveChanges();
        } catch (Exception e) {
            // show popup to user with e.getMessage();
        }
    }
}

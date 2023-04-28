package com.zeindevs.javafxmvvm.viewmodel.textchart;

import com.zeindevs.javafxmvvm.model.DataModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TextViewModel {

    private StringProperty updateTimeStamp;
    private StringProperty x;
    private StringProperty y;
    private StringProperty z;
    private DataModel model;

    public TextViewModel(DataModel model) {
        this.model = model;
        x = new SimpleStringProperty();
        y = new SimpleStringProperty();
        z = new SimpleStringProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");
    }

    public void updateTextFields() {
        double[] vals = model.getDataValues();
        x.setValue(""+vals[0]);
        y.setValue(""+vals[1]);
        z.setValue(""+vals[2]);
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
    }

    public StringProperty xStringProperty() {
        return x;
    }

    public StringProperty yStringProperty() {
        return y;
    }

    public StringProperty zStringProperty() {
        return z;
    }

    public StringProperty labelStringProperty() {
        return updateTimeStamp;
    }

    public void saveChanges() throws Exception {
        double xAsDouble = Double.parseDouble(x.getValue());
        if (xAsDouble < 0) {
            throw new RuntimeException("X value cannot be less than zero");
        }
        model.saveData(new double[] {
                Double.parseDouble(x.getValue()),
                Double.parseDouble(y.getValue()),
                Double.parseDouble(z.getValue()),
        });
    }
}

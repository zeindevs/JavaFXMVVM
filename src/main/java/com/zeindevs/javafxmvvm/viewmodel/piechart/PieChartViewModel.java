package com.zeindevs.javafxmvvm.viewmodel.piechart;

import com.zeindevs.javafxmvvm.model.DataModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PieChartViewModel {

    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty z;
    private StringProperty updateTimeStamp;

    private DataModel model;

    public PieChartViewModel(DataModel model) {
        this.model = model;
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
        z = new SimpleDoubleProperty();
        updateTimeStamp = new SimpleStringProperty("Last update: ");
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public void updatePieChart() {
        double[] values = model.getDataValues();
        x.setValue(values[0]);
        y.setValue(values[1]);
        z.setValue(values[2]);
        updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
    }

    public DoubleProperty xProperty() { return x; }
    public DoubleProperty yProperty() { return y; }
    public DoubleProperty zProperty() { return z; }


}

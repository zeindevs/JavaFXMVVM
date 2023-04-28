package com.zeindevs.javafxmvvm.model;

public interface DataModel {
    void recalculateData();
    double[] getDataValues();
    String getLastUpdateTimeStamp();
    void saveData(double[] doubles);
}

package com.zeindevs.javafxmvvm.model;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if (dataModel == null) {
            dataModel = new DataModelManager();
        }
        return dataModel;
    }
}

package com.zeindevs.javafxmvvm.viewmodel;

import com.zeindevs.javafxmvvm.model.ModelFactory;
import com.zeindevs.javafxmvvm.viewmodel.piechart.PieChartViewModel;
import com.zeindevs.javafxmvvm.viewmodel.textchart.TextViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;
    private TextViewModel textViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
        textViewModel = new TextViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

    public TextViewModel getTextViewModel() { return textViewModel; }
}

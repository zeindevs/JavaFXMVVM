package com.zeindevs.javafxmvvm.view.piechart;

import com.zeindevs.javafxmvvm.viewmodel.piechart.PieChartViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class PieChartController {

    @FXML
    private Label eventLabel;

    @FXML
    private PieChart pieChart;

    private PieChartViewModel viewModel;

    private PieChart.Data x = new PieChart.Data("X", 0);
    private PieChart.Data y = new PieChart.Data("Y", 0);
    private PieChart.Data z = new PieChart.Data("Z", 0);

    public PieChartController() {
    }

    public void init(PieChartViewModel pieChartViewModel) {
        this.viewModel = pieChartViewModel;

        x.pieValueProperty().bind(viewModel.xProperty());
        y.pieValueProperty().bind(viewModel.yProperty());
        z.pieValueProperty().bind(viewModel.zProperty());

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());

        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(x, y, z);
        pieChart.setData(data);
    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.updatePieChart();
    }
}

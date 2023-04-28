package com.zeindevs.javafxmvvm.view;

import com.zeindevs.javafxmvvm.PieChartApp;
import com.zeindevs.javafxmvvm.StartPieChartApp;
import com.zeindevs.javafxmvvm.view.piechart.PieChartController;
import com.zeindevs.javafxmvvm.view.textchart.TextChartController;
import com.zeindevs.javafxmvvm.viewmodel.ViewModelFactory;
import com.zeindevs.javafxmvvm.viewmodel.textchart.TextViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private Stage stage;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws IOException {
        openView("PieChart");
        openView("TextChart");
    }

    private void openView(String view) throws IOException {
        Scene scene = null;
        FXMLLoader fxmlLoader =  new FXMLLoader();
        Parent parent = null;
        Stage localStage = new Stage();

        if ("PieChart".equals(view)) {
            fxmlLoader.setLocation(getClass().getResource(view.toLowerCase()+"/"+view+"View.fxml"));
            parent = fxmlLoader.load();
            PieChartController controller = fxmlLoader.getController();
            controller.init(viewModelFactory.getPieChartViewModel());
            localStage.setTitle("Pie Chart");
        } else if ("TextChart".equals(view)) {
            fxmlLoader.setLocation(getClass().getResource(view.toLowerCase()+"/"+view+"View.fxml"));
            parent = fxmlLoader.load();
            TextChartController controller = fxmlLoader.getController();
            controller.init(viewModelFactory.getTextViewModel());
            localStage.setTitle("Text Chart");
        }

        scene = new Scene(parent);
        localStage.setScene(scene);
        localStage.show();
    }
}

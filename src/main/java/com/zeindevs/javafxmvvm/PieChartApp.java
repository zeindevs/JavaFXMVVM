package com.zeindevs.javafxmvvm;

import com.zeindevs.javafxmvvm.model.DataModelManager;
import com.zeindevs.javafxmvvm.model.ModelFactory;
import com.zeindevs.javafxmvvm.view.ViewHandler;
import com.zeindevs.javafxmvvm.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

public class PieChartApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory modelFactory = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

        runAutoUpdate((DataModelManager) modelFactory.getDataModel());
    }

    private void runAutoUpdate(DataModelManager model) {
        Thread thread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                model.recalculateData();
                try {
                    Thread.sleep(random.nextInt(500) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}

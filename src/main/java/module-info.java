module com.zeindevs.javafxmvvm {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.zeindevs.javafxmvvm to javafx.fxml;
    exports com.zeindevs.javafxmvvm;

    opens com.zeindevs.javafxmvvm.view to javafx.fxml;
    exports com.zeindevs.javafxmvvm.view;

    opens com.zeindevs.javafxmvvm.view.piechart to javafx.fxml;
    exports com.zeindevs.javafxmvvm.view.piechart;

    opens com.zeindevs.javafxmvvm.view.textchart to javafx.fxml;
    exports com.zeindevs.javafxmvvm.view.textchart;
}
module fr.fabian.eteinslalumiereihm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.fabian.eteinslalumiereihm to javafx.fxml;
    exports fr.fabian.eteinslalumiereihm;

    opens fr.fabian.eteinslalumiereihm.controllers to javafx.fxml;
    exports fr.fabian.eteinslalumiereihm.controllers;

    opens fr.fabian.eteinslalumiereihm.models to javafx.fxml;
    exports fr.fabian.eteinslalumiereihm.models;

    opens fr.fabian.eteinslalumiereihm.views to javafx.fxml;
    exports fr.fabian.eteinslalumiereihm.views;

}
module fr.fabian.eteinslalumiereihm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.fabian.eteinslalumiereihm to javafx.fxml;
    exports fr.fabian.eteinslalumiereihm;
}
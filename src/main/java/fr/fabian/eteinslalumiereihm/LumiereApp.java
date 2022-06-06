package fr.fabian.eteinslalumiereihm;

import fr.fabian.eteinslalumiereihm.controllers.MenuController;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.views.Grille;
import fr.fabian.eteinslalumiereihm.views.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LumiereApp extends Application {
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(javafx.geometry.Pos.CENTER);

        Jeu jeu = new Jeu();

        Menu menu = new Menu(jeu);
        MenuController menuController = new MenuController(menu);


        Grille grille = new Grille(jeu);
        menuController.addVue(grille);

        root.getChildren().addAll(grille, menu);

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
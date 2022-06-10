package fr.fabian.eteinslalumiereihm;

import fr.fabian.eteinslalumiereihm.controllers.MenuController;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.views.Grille;
import fr.fabian.eteinslalumiereihm.views.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Classe qui permet de créer une fenêtre de menu et de lancer le jeu
 */
public class LumiereApp extends Application {
    /**
     * Méthode qui permet de créer la fenêtre de menu
     * @param stage Le stage de la fenêtre
     */
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        Jeu jeu = new Jeu();

        Menu menu = new Menu(jeu);


        Grille grille = new Grille(jeu);
        jeu.addVue(grille);
        jeu.addVue(menu);
        MenuController menuController = new MenuController(menu);
        menuController.addVue(grille);
        menuController.addVue(menu);

        root.getChildren().addAll(grille, menu);

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Jeu des lumières!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Méthode main qui permet de lancer l'application
     * @param args Les arguments passés en ligne de commande
     */
    public static void main(String[] args) {
        launch();
    }
}
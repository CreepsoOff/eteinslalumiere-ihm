package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.MenuController;
import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends HBox implements Observateur {

  private Jeu jeu;
  private ArrayList<Button> btns = new ArrayList<>();

  public Menu(Jeu jeu) {
    this.jeu = jeu;
    this.setSpacing(5);
    this.setAlignment(javafx.geometry.Pos.CENTER);
    this.prefHeight(40);
    this.prefWidth(200);

    Button jouer = new Button("Jouer");

    TextField tf = new TextField();
    tf.setEditable(false);
    tf.setText("0");
    tf.setAlignment(javafx.geometry.Pos.CENTER);
    tf.setPrefColumnCount(4);

    Button config = new Button("Config");
    Button random = new Button("Random");
    Button quitter = new Button("Quitter");

    jouer.setOnAction(new MenuController(this));
    config.setOnAction(new MenuController(this));
    random.setOnAction(new MenuController(this));
    quitter.setOnAction(new MenuController(this));

    btns.addAll(Arrays.asList(jouer, config, random, quitter));

    this.getChildren().addAll(jouer, tf, config, random, quitter);
  }

  public Jeu getJeu() {
    return jeu;
  }

  @Override
  public void update() {}
}

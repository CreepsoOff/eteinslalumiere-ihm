package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.MenuController;
import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe qui permet de créer un menu
 *
 * @author Fabian
 */
public class Menu extends HBox implements Observateur {

  /** Le jeu */
  private Jeu jeu;
  /** Le TextField représantant le nombre de coups joués */
  private TextField tf;

  /** La liste de boutons du menu */
  private ArrayList<Button> btns = new ArrayList<>();

  /**
   * Constructeur de la classe Menu
   *
   * @param jeu Le jeu associé au menu
   * @see Jeu
   */
  public Menu(Jeu jeu) {
    this.jeu = jeu;
    this.setSpacing(5);
    this.setAlignment(javafx.geometry.Pos.CENTER);
    this.prefHeight(40);
    this.prefWidth(200);

    ImageView playImage = new ImageView(new Image("file:src/main/resources/images/bouton-jouer.png"));
    ImageView configImage = new ImageView(new Image("file:src/main/resources/images/bouton-config.png"));
    ImageView quitImage = new ImageView(new Image("file:src/main/resources/images/bouton-quitter.png"));
    ImageView randomImage = new ImageView(new Image("file:src/main/resources/images/bouton-aleatoire.png"));

    Button jouer = new Button("Jouer", playImage);
    jouer.setDisable(true);
    jouer.setPrefHeight(30);
    jouer.setPrefWidth(40);

    this.tf = new TextField();
    tf.setEditable(false);
    tf.setText("0");
    tf.setAlignment(javafx.geometry.Pos.CENTER);
    tf.setPrefColumnCount(4);

    Button config = new Button("Config", configImage);
    Button random = new Button("Random", randomImage);
    Button quitter = new Button("Quitter", quitImage);

    for (Button button : Arrays.asList(jouer, config, random, quitter)) {
      button.setStyle("-fx-background-color: #fdbe00");
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        button.setOnAction(new MenuController(this));
    }
    btns.addAll(Arrays.asList(jouer, config, random, quitter));

    this.getChildren().addAll(jouer, tf, config, random, quitter);
  }

  /**
   * Méthode retournant le jeu associé au menu
   *
   * @return Le jeu associé au menu
   */
  public Jeu getJeu() {
    return jeu;
  }

  /**
   * Méthode retournant la liste de boutons associé au menu
   *
   * @return la liste de boutons associé au menu
   */
  public ArrayList<Button> getBtns() {
    return btns;
  }

  /** Méthode permettant de mettre à jour le menu */
  @Override
  public void update() {
    tf.setText(String.valueOf(jeu.getNbClicks()));

    if (jeu.getGamemode().equals("reroll")) {
      btns.get(0).setDisable(true);
      btns.get(1).setDisable(false);
      btns.get(2).setDisable(false);
    } else if (jeu.getGamemode().equals("inactif")) {
      tf.setText("0");
    }
  }
}

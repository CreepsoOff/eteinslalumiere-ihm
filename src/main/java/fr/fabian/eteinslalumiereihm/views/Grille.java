package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.LRectangleController;
import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Classe représentant le composant graphique permettant d'afficher la grille de Lampes
 * (LampeRectangles)
 *
 * @author Fabian
 */
public class Grille extends GridPane implements Observateur {

  /** Matrice représentant les lumières graphique sur la grille */
  private final LampeRectangles[][] rectangles;
  /** Jeu permettant la connexion entre les classes */
  private final Jeu jeu;

  /**
   * Constructeur de Grille (création et placement des Lampes et LampeRectangles)
   *
   * @param jeu le jeu permettant la connexion des éléments
   */
  public Grille(Jeu jeu) {
    this.jeu = jeu;
    this.setAlignment(javafx.geometry.Pos.CENTER);
    this.rectangles = new LampeRectangles[Lampes.NB_LIGNES][Lampes.NB_COLONNES];
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        Lampes lampes = new Lampes();
        this.rectangles[i][j] = new LampeRectangles(lampes);
        this.add(this.rectangles[i][j], j, i);
      }
    }
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        this.getChildren()
            .get(i * Lampes.NB_COLONNES + j)
            .setOnMouseClicked(
                new LRectangleController(this.getRectangles()[i][j].getLampes(), jeu, i, j));
      }
    }
  }

  /**
   * Getter de LampesRectangle sur la grille
   *
   * @return la matrice de LampeRectangles de la grille
   */
  public LampeRectangles[][] getRectangles() {
    return rectangles;
  }

  /** Méthode permettant d'allumer X lampes aléatoirement */
  public void randomEtat() {
    this.clear();
    // Liste de lampes éteintes
    java.util.List<Lampes> listeEteintes = new java.util.ArrayList<>();
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        if (!this.getRectangles()[i][j].getLampes().getEtat()) {
          listeEteintes.add(this.getRectangles()[i][j].getLampes());
        }
      }
    }
    // Choix aléatoire de X lampes éteintes
    java.util.List<Lampes> listeAleatoire = new java.util.ArrayList<>();
    for (int i = 0; i < Jeu.NB_RANDOM; i++) {
      int indexAleatoire = new Random().nextInt(listeEteintes.size());

      // Si la lampe n'est déjà pas dans la liste, ajouter, sinon recommencer
      if (!listeAleatoire.contains(listeEteintes.get(indexAleatoire))) {
        listeAleatoire.add(listeEteintes.get(indexAleatoire));
      } else {
        i--;
      }
    }
    // On allume les lampes
    for (Lampes lampes : listeAleatoire) {
      lampes.allumer();
    }
  }

  /**
   * Méthode permettant de trouver les lampes adjacentes
   *
   * @param x position X (indice i) du rectangle dans la Grille
   * @param y position Y (indice j) du rectangle dans la Grille
   */
  public void adjacent(int x, int y) {
    // Allumer les 4 lampes adjacentes
    if (x > 0) {
      this.getRectangles()[x - 1][y].getLampes().inverserEtat();
    }
    if (x < Lampes.NB_LIGNES - 1) {
      this.getRectangles()[x + 1][y].getLampes().inverserEtat();
    }
    if (y > 0) {
      this.getRectangles()[x][y - 1].getLampes().inverserEtat();
    }
    if (y < Lampes.NB_COLONNES - 1) {
      this.getRectangles()[x][y + 1].getLampes().inverserEtat();
    }
  }

  /** Nettoyer la grille / Eteindre toutes les Lampes */
  public void clear() {
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        this.getRectangles()[i][j].getLampes().eteindre();
      }
    }
  }

  /** Méthode permettant de mettre à jour la Grille et vérifiant les conditions de victoire */
  @Override
  public void update() {
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        this.getRectangles()[i][j].update();
      }
    }

    boolean toutesEteintes = true;
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        if (this.getRectangles()[i][j].getLampes().getEtat()) {
          toutesEteintes = false;
        }
      }
    }
    if (toutesEteintes && this.jeu.getGamemode().equals("jeu")) {
      javafx.scene.control.Alert alert =
          new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
      alert.setTitle("Fin du jeu");
      alert.setHeaderText("Vous avez gagné en " + (jeu.getNbClicks() - 1) + " coups !");
      alert.setContentText("Voulez-vous recommencer ?");
      alert
          .showAndWait()
          .ifPresent(
              response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                  this.clear();
                  this.randomEtat();
                } else {
                  this.jeu.setGamemode("reroll");
                }
                this.jeu.resetNbClicks();
                this.jeu.notifierObservateurs();
              });
    }
  }
}

package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.LRectangleController;
import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import javafx.scene.layout.GridPane;

public class Grille extends GridPane implements Observateur {

  private LampeRectangles[][] rectangles;
  private Jeu jeu;

  public Grille(Jeu jeu) {
    this.setAlignment(javafx.geometry.Pos.CENTER);
    this.rectangles = new LampeRectangles[Lampes.NB_LIGNES][Lampes.NB_COLONNES];
    for (int i = 0; i < Lampes.NB_LIGNES; i++) {
      for (int j = 0; j < Lampes.NB_COLONNES; j++) {
        Lampes lampes = new Lampes();
        this.rectangles[i][j] = new LampeRectangles(lampes);
        this.add(this.rectangles[i][j], j, i);
      }
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        this.getChildren()
            .get(i * 5 + j)
            .setOnMouseClicked(
                new LRectangleController(this.getRectangles()[i][j].getLampes(), jeu));
      }
    }
  }

  public LampeRectangles[][] getRectangles() {
    return rectangles;
  }

  @Override
  public void update() {
    System.out.println("Grille Used");
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        this.getChildren()
            .get(i * 5 + j)
            .setOnMouseClicked(
                new LRectangleController(this.rectangles[i][j].getLampes(), this.jeu));
      }
    }
  }
}

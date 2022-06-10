package fr.fabian.eteinslalumiereihm.controllers;

import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import fr.fabian.eteinslalumiereihm.views.Grille;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Classe représentant le contrôleur de la grille.
 *
 * @author Fabian
 */
public class LRectangleController implements EventHandler<MouseEvent> {
  /** Liste des lampes de la grille. */
  private Lampes lampes;
  /** Jeu permettant la connexion entre les classes. */
  private Jeu jeu;
  /** Ligne de la grille. */
  private int x;
  /** Colonne de la grille. */
  private int y;

  /**
   * Constructeur de LRectangleController.
   *
   * @param lampes les lampes de la grille.
   * @param jeu le jeu permettant la connexion des éléments.
   * @param x la ligne de la grille.
   * @param y la colonne de la grille.
   * @see Lampes
   * @see Jeu
   */
  public LRectangleController(Lampes lampes, Jeu jeu, int x, int y) {
    this.x = x;
    this.y = y;
    this.lampes = lampes;
    this.jeu = jeu;
  }

  /**
   * Méthode permettant de changer l'état de la lampe en fonction du mode de jeu.
   *
   * @param mouseEvent l'évènement de la souris.
   */
  @Override
  public void handle(MouseEvent mouseEvent) {
    if (jeu.getGamemode().equals("configuration")) {
      lampes.inverserEtat();
    }

    if (jeu.getGamemode().equals("jeu")) {
      lampes.inverserEtat();
      Grille g = (Grille) jeu.getlVues().get(0);
      g.adjacent(x, y);
      jeu.incrementNbClicks();
    }
    lampes.notifierObservateurs();
    jeu.notifierObservateurs();
  }
}

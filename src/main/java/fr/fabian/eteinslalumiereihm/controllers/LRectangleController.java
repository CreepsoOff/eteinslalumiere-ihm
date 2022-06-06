package fr.fabian.eteinslalumiereihm.controllers;

import fr.fabian.eteinslalumiereihm.models.Jeu;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class LRectangleController implements EventHandler<MouseEvent> {
  private Lampes lampes;
  private Jeu jeu;

  public LRectangleController(Lampes lampes, Jeu jeu) {
    this.lampes = lampes;
    this.jeu = jeu;
  }

  @Override
  public void handle(MouseEvent mouseEvent) {
    if (jeu.getGamemode().equals("configuration")) {
      lampes.inverserEtat();
      lampes.notifierObservateurs();
    }

  }
}

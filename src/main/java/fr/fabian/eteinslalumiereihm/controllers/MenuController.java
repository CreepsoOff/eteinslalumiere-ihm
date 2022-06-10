package fr.fabian.eteinslalumiereihm.controllers;

import fr.fabian.eteinslalumiereihm.views.Grille;
import fr.fabian.eteinslalumiereihm.views.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Classe MenuController qui gère les actions des boutons du menu.
 *
 * @author Fabian
 */
public class MenuController implements EventHandler<javafx.event.ActionEvent> {
  private ArrayList<Observateur> lVue = new ArrayList<>();
  private Menu menu;

  /**
   * Constructeur de MenuController.
   *
   * @param menu Le menu à gérer.
   */
  public MenuController(Menu menu) {
    this.menu = menu;
  }

  /**
   * Méthode qui s'occupe de gérer les actions des boutons du menu.
   *
   * @param actionEvent L'évènement de l'action (Bouton généralement)
   */
  @Override
  public void handle(ActionEvent actionEvent) {
    Button btn = (Button) actionEvent.getSource();
    Grille g = (Grille) menu.getJeu().getlVues().get(0);

    switch (btn.getText()) {
      case "Jouer":
        menu.getJeu().setGamemode("jeu");
        menu.getBtns().get(0).setDisable(true);
        menu.getBtns().get(1).setDisable(true);
        menu.getBtns().get(2).setDisable(true);
        notifierObservateurs();
        break;
      case "Config":
        menu.getJeu().setGamemode("configuration");
        menu.getBtns().get(0).setDisable(false);
        menu.getBtns().get(2).setDisable(true);
        notifierObservateurs();
        break;
      case "Random":
        menu.getJeu().setGamemode("random");
        menu.getBtns().get(0).setDisable(false);
        g.randomEtat();
        notifierObservateurs();
        break;
      case "Quitter":
        menu.getJeu().setGamemode("inactif");
        menu.getBtns().get(1).setDisable(false);
        menu.getBtns().get(2).setDisable(false);
        menu.update();
        g.clear();
        notifierObservateurs();
    }
  }

  /**
   * Méthode qui ajoute un Observateur.
   *
   * @param vue Observateur à ajouter.
   */
  public void addVue(Observateur vue) {
    lVue.add(vue);
  }

  /** Méthode qui notifie tous les Observateurs. */
  public void notifierObservateurs() {
    for (Observateur vue : lVue) {
      vue.update();
    }
  }
}

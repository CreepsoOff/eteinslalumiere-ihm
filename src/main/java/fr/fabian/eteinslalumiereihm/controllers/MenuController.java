package fr.fabian.eteinslalumiereihm.controllers;

import fr.fabian.eteinslalumiereihm.views.Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class MenuController implements EventHandler<javafx.event.ActionEvent> {
  private ArrayList<Observateur> lVue = new ArrayList<>();
  private Menu menu;

  public MenuController(Menu menu) {
    this.menu = menu;
  }

  /**
   * @param actionEvent
   */
  @Override
  public void handle(ActionEvent actionEvent) {
    Button btn = (Button) actionEvent.getSource();
    switch (btn.getText()) {
      case "Jouer":
        menu.getJeu().setGamemode("jeu");
        System.out.println("Jouer");
        notifierObservateurs();
        break;
      case "Config":
        menu.getJeu().setGamemode("configuration");
        System.out.println("Config");
        notifierObservateurs();
        break;
      case "Random":
        menu.getJeu().setGamemode("random");
        System.out.println("Random");
        notifierObservateurs();
    }
  }

  public void addVue(Observateur vue) {
    lVue.add(vue);
  }

  public void notifierObservateurs() {
    for (Observateur vue : lVue) {
      vue.update();
      System.out.println("Sent update");
    }
  }
}

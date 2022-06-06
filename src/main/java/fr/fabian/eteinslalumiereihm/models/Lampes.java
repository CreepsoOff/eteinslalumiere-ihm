package fr.fabian.eteinslalumiereihm.models;

import fr.fabian.eteinslalumiereihm.controllers.Observateur;

import java.util.ArrayList;

public class Lampes {
  public static final int NB_LIGNES = 5;
  public static final int NB_COLONNES = 5;
  private ArrayList<Observateur> lVue;
  private boolean etat;

  public Lampes() {
    this.lVue = new ArrayList<>();
    this.etat = false;
  }

  public void allumer() {
    this.etat = true;
    this.notifierObservateurs();
  }

  public void eteindre() {
    this.etat = false;
    this.notifierObservateurs();
  }

  public void inverserEtat() {
    this.etat = !this.etat;
    this.notifierObservateurs();
  }

  public boolean getEtat() {
    return this.etat;
  }

  public void notifierObservateurs() {
    for (Observateur v : this.lVue) {
      v.update();
    }
  }

  public void addVue(Observateur vue) {
    this.lVue.add(vue);
  }
}

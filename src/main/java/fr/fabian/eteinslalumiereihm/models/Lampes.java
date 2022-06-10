package fr.fabian.eteinslalumiereihm.models;

import fr.fabian.eteinslalumiereihm.controllers.Observateur;

import java.util.ArrayList;

/**
 * Classe Lampes qui représente le modèle des lampes
 * @author Fabian
 */
public class Lampes {
  /**
   * Constantes de Lampes
   */
  public static final int NB_LIGNES = 5;
  public static final int NB_COLONNES = 5;

  /**
   * Liste d'Observateurs de la classe Lampes
   */
  private ArrayList<Observateur> lVue;
  private boolean etat;

    /**
     * Constructeur vide de Lampes
     */
  public Lampes() {
    this.lVue = new ArrayList<>();
    this.etat = false;
  }

  /**
   * Méthode qui permet d'allumer une lampe et de notifier les Observateurs
   */
  public void allumer() {
    this.etat = true;
    this.notifierObservateurs();
  }

  /**
   * Méthode qui permet d'éteindre une lampe et de notifier les Observateurs
   */
  public void eteindre() {
    this.etat = false;
    this.notifierObservateurs();
  }

  /**
   * Méthode permettant d'inverser l'état d'une lampe et de notifier les Observateurs
   */
  public void inverserEtat() {
    this.etat = !this.etat;
    this.notifierObservateurs();
  }

  /**
   * Méthode permettant de récupérer l'état d'une lampe
   * @return l'état de la lampe (true ou false)
   */
  public boolean getEtat() {
    return this.etat;
  }


    /**
     * Méthode permettant de notifier les Observateurs
     */
  public void notifierObservateurs() {
    for (Observateur v : this.lVue) {
      v.update();
    }
  }

    /**
     * Méthode permettant d'ajouter un Observateur
     * @param vue la vue à ajouter
     */
  public void addVue(Observateur vue) {
    this.lVue.add(vue);
  }

}

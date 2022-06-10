package fr.fabian.eteinslalumiereihm.models;

import fr.fabian.eteinslalumiereihm.controllers.Observateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Jeu qui représente le jeu (gamemode, constantes de jeu, etc.)
 * @author Fabian
 */
public class Jeu {
    /**
     * Constante de jeu
     */
    public static final int NB_RANDOM = 8;

    /**
     * Mode de jeu
     */
    private String gamemode;

    /**
     * Nombre de clics réalisés
     */
    private int nbClicks = 0;

    /**
     * Liste d'Observateurs de la classe Jeu
     */
    private List<Observateur> lVues = new ArrayList<>();

    /**
     * Constructeur vide de Jeu
     */
    public Jeu() {
        this.gamemode = "inactif";
    }

    /**
     * Getter du mode de jeu
     * @return le mode de jeu
     */
    public String getGamemode() {
        return gamemode;
    }

    /**
     * Setter du mode de jeu
     * @param gamemode le mode de jeu
     */
    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    /**
     * Ajout d'une vue en Observateur
     * @param vue la vue à ajouter
     */
    public void addVue(Observateur vue) {
        this.lVues.add(vue);
    }

    /**
     * Méthode permettant de notifier tout les observateurs en appelant leurs méthodes update
     */
    public void notifierObservateurs() {
        for (Observateur vue : lVues) {
            vue.update();
        }
    }


    /**
     * Getter des vues
     * @return la liste des vues (Observateurs)
     */
    public List<Observateur> getlVues() {
        return lVues;
    }

    /**
     * Getter du nombre de Clicks
     * @return le nombre de clics
     */
    public int getNbClicks() {
        return nbClicks;
    }


    /**
     * Méthode permettant d'incrémenter le nombre de clics
     */
    public void incrementNbClicks() {
        this.nbClicks++;
    }


    /**
     * Méthode permettant de réinitialiser le nombre de clics
     */
    public void resetNbClicks() {
        this.nbClicks = 0;
    }
}

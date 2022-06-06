package fr.fabian.eteinslalumiereihm.models;

public class Jeu {
    private String gamemode;

    public Jeu() {
        this.gamemode = "inactif";
    }

    public Jeu(String gamemode) {
        this.gamemode = gamemode;
    }

    public String getGamemode() {
        return gamemode;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }
}

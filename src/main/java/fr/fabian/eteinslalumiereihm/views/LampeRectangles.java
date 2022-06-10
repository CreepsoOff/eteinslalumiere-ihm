package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 * Classe qui permet de créer des lampes rectangulaires
 *
 * @author Fabian
 */
public class LampeRectangles extends Rectangle implements Observateur {
  /** La lampe */
  private final Lampes lampes;

  /** Constantes de la classe LampeRectangles */
  public static final RadialGradient colorOn =
      new RadialGradient(
          0,
          0,
          0.5,
          0.5,
          0.5,
          true,
          CycleMethod.NO_CYCLE,
          new Stop(0, new Color(0, 1.0, 0, 1.0)),
          new Stop(1, Color.LIMEGREEN));
  public static final Color colorOff = Color.DARKGREEN;
  public static final int TAILLE_CASE = 100;

  /**
   * Constructeur de la classe LampeRectangles
   *
   * @param lampes La lampe
   */
  public LampeRectangles(Lampes lampes) {
    super(TAILLE_CASE, TAILLE_CASE, colorOff);
    this.setArcWidth(12.0);
    this.setArcHeight(12.0);
    this.setStroke(Color.BLACK);
    this.lampes = lampes;
    lampes.addVue(this);
  }

  /**
   * Méthode permettant de récupérer la lampe associée à la lampe rectangulaire
   *
   * @return La lampe
   */
  public Lampes getLampes() {
    return lampes;
  }

  /** Méthode permettant de mettre à jour la lampe rectangulaire */
  @Override
  public void update() {
    if (this.lampes.getEtat()) {
      this.setFill(colorOn);
    } else {
      this.setFill(colorOff);
    }
  }
}

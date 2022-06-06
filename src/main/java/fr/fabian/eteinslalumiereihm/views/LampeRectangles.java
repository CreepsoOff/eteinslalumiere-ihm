package fr.fabian.eteinslalumiereihm.views;

import fr.fabian.eteinslalumiereihm.controllers.Observateur;
import fr.fabian.eteinslalumiereihm.models.Lampes;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LampeRectangles extends Rectangle implements Observateur {
  private Lampes lampes;
  public static final Color colorOn = Color.LIMEGREEN;
  public static final Color colorOff = Color.DARKGREEN;

  public LampeRectangles(Lampes lampes) {
    super(100, 100, colorOff);
    this.setArcWidth(12.0);
    this.setArcHeight(12.0);
    this.setStroke(Color.BLACK);
    this.lampes = lampes;
    lampes.addVue(this);
  }

  public Lampes getLampes() {
    return lampes;
  }

  @Override
  public void update() {
    if (this.lampes.getEtat()) {
      this.setFill(colorOn);
    } else {
      this.setFill(colorOff);
    }
  }
}

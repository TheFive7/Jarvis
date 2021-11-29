package jarvis.jarvis_2.objets;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Laser extends Objet{
    private int vitesse;
    private int degat;
    private boolean actif;

    public Laser() {
        super();
        setHauteur(30);
        setLargeur(5);
        setNbVie(1);
        setDegat(1);
        setVitesse(3);
        setActif(false);
        setImage(new Image("file:src/main/resources/jarvis/jarvis_2/assets/Laser.png", getLargeur(), getHauteur(), false, true));
    }

    public void avance() {
        setPosition(new Point2D(getPosition().getX(),getPosition().getY() - getVitesse()));
    }

    public int getVitesse() { return vitesse; }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getDegat() {
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}

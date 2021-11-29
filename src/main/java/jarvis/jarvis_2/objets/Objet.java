package jarvis.jarvis_2.objets;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import static jarvis.jarvis_2.game.App.gc;

public class Objet {
    private int largeur;
    private int hauteur;
    private Point2D position;
    private int nbVie;
    private Image image;

    public Objet() {}

    /**
     * Affiche l'image de l'objet.
     */
    public void affiche() {
        try {
            gc.drawImage(getImage(), getPosition().getX(), getPosition().getY());
        } catch (Exception ignored) {}
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public int getNbVie() {
        return nbVie;
    }

    public void setNbVie(int nbVie) {
        this.nbVie = nbVie;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
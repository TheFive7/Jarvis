package jarvis.jarvis_2.objets;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;

import static jarvis.jarvis_2.game.App.meteorite;
import static jarvis.jarvis_2.game.Donnees.m2;

public class Meteorite extends Objet{
    private boolean explosee;

    public Meteorite() {
        super();
        setHauteur(140);
        setLargeur(112);
        setNbVie(1);
        setImage(new Image("file:src/main/resources/jarvis/jarvis_2/assets/meteorite.png", getLargeur(), getHauteur(), true, true));
    }

    public void explose(Laser l) {
        // Son explosion
        new MediaPlayer(m2).play();

        meteorite.setExplosee(true);
        meteorite.setImage(new Image("file:src/main/resources/jarvis/jarvis_2/assets/meteorite_explosion.png", meteorite.getLargeur(), meteorite.getHauteur(), true, true));
        l.setActif(false);
    }

    public void regenere() {
        setNbVie(1);
        setExplosee(false);
        setImage(new Image("file:src/main/resources/jarvis/jarvis_2/assets/meteorite.png", getLargeur(), getHauteur(), true, true));
        int a = (int) (300 * Math.random());
        int b = (int) (300 * Math.random());
        setPosition(new Point2D(a,b));
    }

    public boolean isExplosee() {
        return explosee;
    }

    public void setExplosee(boolean explosee) {
        this.explosee = explosee;
    }
}

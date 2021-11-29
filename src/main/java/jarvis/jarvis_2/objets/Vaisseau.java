package jarvis.jarvis_2.objets;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import static jarvis.jarvis_2.game.App.vaisseau;
import static jarvis.jarvis_2.game.Donnees.m1;

public class Vaisseau extends Objet{
    private List<Laser> munitions;
    private int numero_munition;
    private int stock_munition;

    public Vaisseau() {
        setHauteur(100);
        setLargeur(70);
        setNbVie(5);
        setImage(new Image("file:src/main/resources/jarvis/jarvis_2/assets/vaisseau_5_vie.png", getLargeur(), getHauteur(), false, true));
        setNumero_munition(0);
        setStock_munition(20);
        remplir_munitions(getStock_munition());
    }

    /**
     * Tire un laser
     */
    public void tire() {
        // Son du laser
        new MediaPlayer(m1).play();

        // Point de depart du laser
        getMunitions().get(getNumero_munition()).setPosition(new Point2D(vaisseau.getPosition().getX() + vaisseau.getLargeur()/2.0 - getMunitions().get(getNumero_munition()).getLargeur()/2.0 ,vaisseau.getPosition().getY() - vaisseau.getHauteur()/2.0 + getMunitions().get(getNumero_munition()).getHauteur()));

        // Laser Actif
        getMunitions().get(getNumero_munition()).setActif(true);

        // Boucle des lasers
        if (getNumero_munition() < getStock_munition() - 1) {
            setNumero_munition(getNumero_munition() + 1);
        } else {
            setNumero_munition(0);
        }
    }

    /**
     * Remplit de n lasers le chargeur du vaisseau.
     * @param n : Nombre de munitions laser
     */
    public void remplir_munitions(int n) {
        munitions = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            munitions.add(new Laser());
        }
    }

    public List<Laser> getMunitions() {
        return munitions;
    }

    public void setMunitions(List<Laser> munitions) {
        this.munitions = munitions;
    }

    public int getNumero_munition() {
        return numero_munition;
    }

    public void setNumero_munition(int numero_munition) {
        this.numero_munition = numero_munition;
    }

    public int getStock_munition() {
        return stock_munition;
    }

    public void setStock_munition(int stock_munition) {
        this.stock_munition = stock_munition;
    }
}

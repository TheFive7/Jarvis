package jarvis.jarvis_2.game;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import jarvis.jarvis_2.objets.Laser;

import static jarvis.jarvis_2.game.App.*;
import static jarvis.jarvis_2.game.Donnees.*;

public class Game {
    public static Image image_map = new Image("file:src/main/resources/jarvis/jarvis_2/assets/map.jpg", LARGEUR_MAP, HAUTEUR_MAP, false, true);

    public static int t = 0;

    public static void run() {
        // Map
        gc.drawImage(image_map, 0, 0);

        for (Laser l : vaisseau.getMunitions()) {
            if (l.isActif()) {
                l.affiche();
                l.avance();
                if (!meteorite.isExplosee()) {
                    // Collisions laser/meteore
                    if (((l.getPosition().getY()) - (meteorite.getPosition().getY() + meteorite.getHauteur()) <= 0) && ((l.getPosition().getX() >= meteorite.getPosition().getX()) && l.getPosition().getX() <= meteorite.getPosition().getX() + meteorite.getLargeur())) {
                        meteorite.setNbVie(meteorite.getNbVie() - l.getDegat());
                        if (meteorite.getNbVie() == 0) {
                            meteorite.explose(l);
                        }
                    }
                }

                // désactive le laser
                if (l.getPosition().getY() <= -l.getHauteur()) {
                    l.setActif(false);
                }
            }
        }

        System.out.println(vaisseau.getPosition().getY());

        // Collisions vaisseau/meteore
        if ((vaisseau.getPosition().getY() <= meteorite.getPosition().getY() + meteorite.getHauteur()) && (vaisseau.getPosition().getY() >= meteorite.getPosition().getY())) {
            if ((vaisseau.getPosition().getX() <= meteorite.getPosition().getX() + meteorite.getLargeur()) && (vaisseau.getPosition().getX() >= meteorite.getPosition().getX())) {
                System.out.println("touch");
                vaisseau.setPosition(new Point2D(LARGEUR_MAP/2.0 - vaisseau.getHauteur()/2.0,HAUTEUR_MAP/2.0 - vaisseau.getLargeur()/2.0));
                if (t%10 == 0) {
                    vaisseau.setNbVie(vaisseau.getNbVie() - 1);
                }
                vaisseau.setImage(new Image(("file:src/assets/vaisseau_"+ vaisseau.getNbVie() +"_vie.png"), vaisseau.getLargeur(), vaisseau.getHauteur(), false, true));
            }
        }

        // 3 secondes avant régénération d'une nouvelle meteorite
        if (meteorite.isExplosee() && t%(UNE_SECONDE*3)==0) {
            meteorite.setImage(new Image("file:src/assets/meteorite.png", meteorite.getLargeur(), meteorite.getHauteur(), true, true));
            meteorite.regenere();
        }

        // Game Over
        if (vaisseau.getNbVie() == 0) {
            System.out.println("Game Over");
            System.exit(0);
        }

        // Temps
        // System.out.println(t);
        t++;

        // Affichage
        vaisseau.affiche();
        meteorite.affiche();
    }
}
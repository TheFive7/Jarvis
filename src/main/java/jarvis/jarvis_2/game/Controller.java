package jarvis.jarvis_2.game;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

import static jarvis.jarvis_2.game.App.vaisseau;
import static jarvis.jarvis_2.game.App.scene;

public class Controller {

    /**
     * Controller qui gere l'appui sur les touches
     */
    public Controller() {
        // Gestion des touches en jeu
        scene.setOnKeyPressed(event -> {

            KeyCode key = event.getCode();

/*            // Clavier
            if (key == KeyCode.UP || key == KeyCode.Z) {
                vaisseau.setPosition(vaisseau.getPosition().add(new Point2D(0,-5)));
                System.out.println(vaisseau.getPosition());
            }
            if (key == KeyCode.DOWN || key == KeyCode.S) {
                vaisseau.setPosition(vaisseau.getPosition().add(new Point2D(0,5)));
                System.out.println(vaisseau.getPosition());
            }
            if (key == KeyCode.LEFT || key == KeyCode.Q) {
                vaisseau.setPosition(vaisseau.getPosition().add(new Point2D(-5,0)));
                System.out.println(vaisseau.getPosition());
            }
            if (key == KeyCode.RIGHT || key == KeyCode.D) {
                vaisseau.setPosition(vaisseau.getPosition().add(new Point2D(5,0)));
                System.out.println(vaisseau.getPosition());
            }*/

            if (key == KeyCode.ESCAPE) {
                System.exit(0);
            }
            if (key == KeyCode.SPACE) {
                vaisseau.tire();
            }
        });

        // Mouse
        scene.setOnMouseDragged(e -> {
            // Limites map
            if ((e.getSceneX() <= 500 - vaisseau.getLargeur()/2.0 && e.getSceneX() >= 0 + vaisseau.getLargeur()/2.0) && (e.getSceneY() <= 800 - vaisseau.getHauteur()/2.0 && e.getSceneY() >= 0 + vaisseau.getHauteur()/2.0)) {
                vaisseau.setPosition(new Point2D(e.getSceneX() - vaisseau.getLargeur() / 2.0, e.getSceneY() - vaisseau.getHauteur() / 2.0));
            }
        });
    }
}


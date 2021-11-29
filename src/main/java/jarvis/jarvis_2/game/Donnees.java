package jarvis.jarvis_2.game;

import javafx.scene.media.Media;

import java.io.File;

public class Donnees {

    // Map
    public static final int LARGEUR_MAP = 500;
    public static final int HAUTEUR_MAP = 800;

    // Vaisseau

    // Temps
    public static double UNE_SECONDE = 60.0;

    // Sons
    public static Media m1 = new Media(new File("src/main/resources/jarvis/jarvis_2/sounds/laser.wav").toURI().toString());
    public static Media m2 = new Media(new File("src/main/resources/jarvis/jarvis_2/sounds/explosion.mp3").toURI().toString());
}

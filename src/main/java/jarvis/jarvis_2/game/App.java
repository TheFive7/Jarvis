package jarvis.jarvis_2.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import jarvis.jarvis_2.objets.Meteorite;
import jarvis.jarvis_2.objets.Vaisseau;

import static jarvis.jarvis_2.game.Donnees.*;
import static jarvis.jarvis_2.game.Game.run;

public final class App extends Application {
    public static Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000/UNE_SECONDE), e -> run()));
    public static StackPane root = new StackPane();
    public static Scene scene = new Scene(root);
    public static Canvas canvas = new Canvas(LARGEUR_MAP, HAUTEUR_MAP);
    public static GraphicsContext gc = canvas.getGraphicsContext2D();

    // Objets
    public static Vaisseau vaisseau;
    public static Meteorite meteorite;

    /**
     * Initialise le stage primaire.
     */
    public static void initial() {

        vaisseau = new Vaisseau();
        meteorite = new Meteorite();

        // Place le Vaisseau
        vaisseau.setPosition(new Point2D(LARGEUR_MAP/2.0 - vaisseau.getHauteur()/2.0,HAUTEUR_MAP/2.0 - vaisseau.getLargeur()/2.0));

        // Place Meteorite
        meteorite.setPosition(new Point2D(300,150));

        // Gestion des touches
        new Controller();

        // Lancement
        // Affiche le jeu correctement (FPS)
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(final Stage primaryStage) {

        // Stage primaire
        primaryStage.setOnCloseRequest(evt -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.setTitle("~ Jarvis ~");

        try {
            primaryStage.getIcons().add((new Image("file:src/main/resources/jarvis/jarvis_2/assets/logo.png")));
        } catch (Exception e) {
            System.out.println("Icone non répertoriée");
        }

        primaryStage.setResizable(false);
        root.getChildren().addAll(canvas);
        primaryStage.show();
        initial();
    }
}


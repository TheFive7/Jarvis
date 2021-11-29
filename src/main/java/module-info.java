module jarvis.jarvis_2.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;


    opens jarvis.jarvis_2.game to javafx.fxml;
    exports jarvis.jarvis_2.game;
}
module a8.tjobah.javafxtodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens a8.tjobah.javafxtodo to javafx.fxml;
    exports a8.tjobah.javafxtodo;
}
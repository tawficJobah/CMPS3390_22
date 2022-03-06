module a4.tjobah.weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;

    opens a4.tjobah.weather to javafx.fxml;
    exports a4.tjobah.weather;
}
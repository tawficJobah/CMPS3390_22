module a11.tjobah.pointofsale {
    requires javafx.controls;
    requires javafx.fxml;


    opens a11.tjobah.pointofsale to javafx.fxml;
    exports a11.tjobah.pointofsale;
}
module aa6.tjobah.fxchat.fxchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens aa6.tjobah.fxchat.fxchat to javafx.fxml;
    exports aa6.tjobah.fxchat.fxchat;
}
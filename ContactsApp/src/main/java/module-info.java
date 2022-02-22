module a3.tjobah.contactsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens a3.tjobah.contactsapp to javafx.fxml;
    exports a3.tjobah.contactsapp;
}
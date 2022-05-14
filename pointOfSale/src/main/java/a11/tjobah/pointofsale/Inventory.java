package a11.tjobah.pointofsale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Inventory extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory.class.getResource("list-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ListViewController controller = fxmlLoader.getController();
        stage.setTitle("Inventory");
        stage.setScene(scene);
        stage.setOnHidden(e -> controller.shutdown());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
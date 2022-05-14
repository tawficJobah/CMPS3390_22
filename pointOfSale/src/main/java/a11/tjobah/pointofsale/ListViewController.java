package a11.tjobah.pointofsale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListViewController {
    ObservableList<Item> items = FXCollections.observableArrayList();
    @FXML
    ListView<Item> itemsList;

    @FXML
    public void initialize(){
        Item tmp = new Item("Pepsi","0239482394","1.99","1.05","10","drinks");

        items.add(tmp);
        itemsList.setItems(items);

        System.out.println(tmp);
    }

}

package a11.tjobah.pointofsale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ListViewController {
    ObservableList<Item> items = FXCollections.observableArrayList();
    @FXML
    ListView<Item> itemsList;

    @FXML
    GridPane newItem;

    @FXML
    TextField txtProductName,txtUPC,txtPrice,txtCost,txtQuantity,txtCategory;

    ItemComparator comparator = new ItemComparator();

    /**
     * iniitializes the objects
     */
    @FXML
    public void initialize(){
        itemsList.setItems(items);
        setNewItemVis(false);
        loadListFromJSON();
        items.sort(comparator);
    }

    /**
     * reads a list from a JSON object and
     * adds them into an array
     */
    private void loadListFromJSON(){
        try(Scanner scanner = new Scanner(new File("items.json"))) {
            while(scanner.hasNextLine()){
                String itemString = scanner.nextLine();
                Item tmp = new Item(new JSONObject(itemString));
                items.add(tmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
    }

    /**
     * writes the array of items into a JSON object
     */
    @FXML
    public void shutdown(){
        try(FileWriter file = new FileWriter("items.json")) {
            for(int i = 0; i < items.size(); i++){
                file.write(items.get(i).getJSONString());
                if(i != items.size() -1){
                    file.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * opens the listview to add new items
     */
    @FXML
    protected void onNewItem(){
        setNewItemVis(true);
    }

    /**
     * saves items into list and sorts by category
     */
    @FXML
    protected void onSaveItem(){
        Item tmp = new Item(txtProductName.getText(),txtUPC.getText(),txtPrice.getText(),
                txtCost.getText(),txtQuantity.getText(),txtCategory.getText());
        items.add(tmp);
        setNewItemVis(false);
        txtProductName.setText(null);
        txtUPC.setText(null);
        txtPrice.setText(null);
        txtCost.setText(null);
        txtQuantity.setText(null);
        txtCategory.setText(null);
        items.sort(comparator);
    }

    /**
     * deletes old item and allows you to edit
     */
    @FXML
    protected void onEditItem(){
        Item selectedItem = itemsList.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            onNewItem();
            txtProductName.setText(selectedItem.getProductName());
            txtUPC.setText(selectedItem.getUpcCode());
            txtPrice.setText(selectedItem.getPrice());
            txtCost.setText(selectedItem.getCost());
            txtQuantity.setText(selectedItem.getQuantity());
            txtCategory.setText(selectedItem.getCategory());
            onDeleteItem();
        }
    }

    /**
     * deletes selected item
     */
    @FXML
    protected void onDeleteItem(){
        Item selectedItem = itemsList.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            items.remove(selectedItem);
        }
    }

    /**
     * hides or shows list view for adding or editing
     * @param vis
     */
    private void setNewItemVis(Boolean vis){
        newItem.setVisible(vis);
        newItem.setManaged(vis);
    }
}

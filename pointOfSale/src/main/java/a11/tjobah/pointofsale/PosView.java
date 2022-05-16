package a11.tjobah.pointofsale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PosView {
    private String productName,upcCode,price,cost,quantity,category;

    ObservableList<Item> items = FXCollections.observableArrayList();

    public String getJSONString(){
        JSONObject json = new JSONObject();
        json.put("productName",this.productName);
        json.put("upcCode",this.upcCode);
        json.put("price",this.price);
        json.put("cost",this.price);
        json.put("quantity",this.quantity);
        json.put("category",this.category);
        return json.toString();
    }

    private void searchListFromJSON(){
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
}

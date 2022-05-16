package a11.tjobah.pointofsale;

import org.json.JSONObject;

public class Item {
    private String productName,upcCode,price,cost,quantity,category;

    /**
     * Constructor for Item
     * @param productName
     * @param upcCode
     * @param price
     * @param cost
     * @param quantity
     * @param category
     */
    public Item(String productName, String upcCode, String price, String cost, String quantity, String category) {
        this.productName = productName;
        this.upcCode = upcCode;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.category = category;
    }

    /**
     * constructor for reading in JSON objects
     * @param item
     */
    public Item(JSONObject item){
        this.productName = item.getString("productName");
        this.upcCode = item.getString("upcCode");
        this.price = item.getString("price");
        this.cost = item.getString("cost");
        this.quantity = item.getString("quantity");
        this.category = item.getString("category");
    }

    /**
     * creates a JSON object
     * @return
     */
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return String.format("%-35s | %-35s | %-35s | %-35s | %-35s | %-35s",
                this.productName,this.upcCode,this.price,this.cost,this.quantity,this.category);
    }
}

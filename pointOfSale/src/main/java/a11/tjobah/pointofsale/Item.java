package a11.tjobah.pointofsale;

public class Item {
    private String productName,upcCode,price,cost,quantity,category;

    public Item(String productName, String upcCode, String price, String cost, String quantity, String category) {
        this.productName = productName;
        this.upcCode = upcCode;
        this.price = price;
        this.cost = cost;
        this.quantity = quantity;
        this.category = category;
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
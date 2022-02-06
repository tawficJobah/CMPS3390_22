package a1.tjobah;

public class Clothing extends Item{
    private String pieces;

    public Clothing() {
        super();
        this.pieces = "";
    }

    public Clothing(String name, double price, int qty) {
        super(name, price, qty);
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString(){
        return String.format("%s       |", super.toString(),"|");
    }
}

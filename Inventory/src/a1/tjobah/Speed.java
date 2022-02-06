package a1.tjobah;

public class Speed extends Consumable{
    private float speedGain;

    public Speed() {
        super();
        this.speedGain = 0;
    }

    public Speed(String name, double price, int qty, int usesLeft, float speedGain) {
        super(name, price, qty, usesLeft);
        this.speedGain = speedGain;
    }

    public float getSpeedGain() {
        return speedGain;
    }

    public void setSpeedGain(float speedGain) {
        this.speedGain = speedGain;
    }

    @Override
    public String toString(){
        return String.format("%s %20.2f | ",super.toString(),this.speedGain);
    }
}

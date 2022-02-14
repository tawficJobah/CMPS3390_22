package a1.tjobah;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static final Random ran = new Random();
    private static final FoodItems[] foodItems = FoodItems.values();
    private static final Tools[] tools = Tools.values();
    private static final ToolUses[] toolUses = ToolUses.values();
    private static final Clothings[] clothings = Clothings.values();
    private static final Speeds[] speeds = Speeds.values();

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("How many items do you want: ");
        int itemCnt = Integer.parseInt(scan.nextLine());

        for(int i=0; i<itemCnt; i++) {
            int type = ran.nextInt(4);
            switch (type) {
                case 0 -> items.add(genFood());
                case 1 -> items.add(genTool());
                case 2 -> items.add(genClothes());
                case 3 -> items.add(genSpeed());
            }
        }
        for(Item i : items){
            System.out.println(i);
        }
    }
    public static Food genFood(){
        int foodIndex = ran.nextInt(foodItems.length);
        String foodName = foodItems[foodIndex].toString();
        float foodPrice = ran.nextFloat(10);
        int foodQty = ran.nextInt(30);
        int foodUses = ran.nextInt(6);
        float healthGain = ran.nextFloat(20);
        return new Food(foodName, foodPrice, foodQty, foodUses, healthGain);
    }
    public static Tool genTool(){
        int toolIndex = ran.nextInt(tools.length);
        String toolName = tools[toolIndex].toString();
        float toolPrice = ran.nextFloat(200);
        int toolQty = ran.nextInt(15);
        String use = toolUses[toolIndex].toString();
        return new Tool(toolName, toolPrice, toolQty, use);
    }
    public static Clothing genClothes(){
        int clothes = ran.nextInt(clothings.length);
        String clothesName = clothings[clothes].toString();
        float clothesPrice = ran.nextFloat(500);
        int clothesQty = ran.nextInt(60);
        return new Clothing(clothesName,clothesPrice,clothesQty);
    }
    public static Speed genSpeed(){
        int speedIndex = ran.nextInt(speeds.length);
        String speedPotionName = speeds[speedIndex].toString();
        float speedPotionPrice = ran.nextFloat(10);
        int speedPotionQty = ran.nextInt(10);
        int potionUses = ran.nextInt(10);
        float speedGain = ran.nextFloat(20);
        return new Speed(speedPotionName,speedPotionPrice,speedPotionQty,potionUses,speedGain);
    }

}

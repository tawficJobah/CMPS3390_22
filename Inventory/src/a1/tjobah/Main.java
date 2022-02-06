package a1.tjobah;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        List<Item> items = new ArrayList<>();
        FoodItems[] foodItems = FoodItems.values();
        Tools[] tools = Tools.values();
        ToolUses[] toolUses = ToolUses.values();
        Clothings[] clothings = Clothings.values();
        Speeds[] speeds = Speeds.values();

        System.out.print("How many items do you want: ");
        int itemCnt = Integer.parseInt(scan.nextLine());

        for(int i=0; i<itemCnt; i++) {
            int type = ran.nextInt(4);
            switch (type) {
                case 0 -> {
                    int foodIndex = ran.nextInt(foodItems.length);
                    String foodName = foodItems[foodIndex].toString();
                    float foodPrice = ran.nextFloat(10);
                    int foodQty = ran.nextInt(30);
                    int foodUses = ran.nextInt(6);
                    float healthGain = ran.nextFloat(20);
                    Food tmpFood = new Food(foodName, foodPrice, foodQty, foodUses, healthGain);
                    items.add(tmpFood);
                }
                case 1 -> {
                    int toolIndex = ran.nextInt(tools.length);
                    String toolName = tools[toolIndex].toString();
                    float toolPrice = ran.nextFloat(200);
                    int toolQty = ran.nextInt(15);
                    String use = toolUses[toolIndex].toString();
                    Tool tmpTool = new Tool(toolName, toolPrice, toolQty, use);
                    items.add(tmpTool);
                }
                case 2 -> {
                    int clothes = ran.nextInt(clothings.length);
                    String clothesName = clothings[clothes].toString();
                    float clothesPrice = ran.nextFloat(500);
                    int clothesQty = ran.nextInt(60);
                    Clothing tmpClothes = new Clothing(clothesName,clothesPrice,clothesQty);
                    items.add(tmpClothes);
                }
                case 3 -> {
                    int speedIndex = ran.nextInt(speeds.length);
                    String speedPotionName = speeds[speedIndex].toString();
                    float speedPotionPrice = ran.nextFloat(10);
                    int speedPotionQty = ran.nextInt(10);
                    int potionUses = ran.nextInt(10);
                    float speedGain = ran.nextFloat(20);
                    Speed tmpSpeed = new Speed(speedPotionName,speedPotionPrice,speedPotionQty,potionUses,speedGain);
                    items.add(tmpSpeed);
                }
            }
        }

        for(Item i : items){
            System.out.println(i);
        }
    }
}

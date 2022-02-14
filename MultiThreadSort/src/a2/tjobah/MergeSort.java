package a2.tjobah;

import a1.tjobah.Item;

public class MergeSort extends Thread{
    private Item[] item1;
    private Item[] item2;
    private Item[] sortedItems;

    public MergeSort(Item[] i1,Item[] i2){
        this.item1 = i1;
        this.item2 = i2;
        this.sortedItems = new Item[i1.length + i2.length];
    }

    @Override
    public void run() {
        System.out.println("Merge Started");
        int i=0; //index
        int j=0;
        int k=0;

        while(i < item1.length && j < item2.length){
            if(this.item1[i].getPrice() < this.item2[j].getPrice()){
                this.sortedItems[k++] = this.item1[i++];
            } else {
                this.sortedItems[k++] = this.item2[j++];
            }
        }

        while(i < this.item1.length){
            this.sortedItems[k++] = this.item1[i++];
        }
        while(j < this.item2.length){
            this.sortedItems[k++] = this.item2[j++];
        }

        System.out.println("Merge Complete");
    }

    public Item[] getSortedItems() {
        return sortedItems;
    }
}

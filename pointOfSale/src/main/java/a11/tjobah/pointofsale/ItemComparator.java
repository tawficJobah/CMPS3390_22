package a11.tjobah.pointofsale;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return item.getCategory().compareToIgnoreCase(t1.getCategory());
    }
}

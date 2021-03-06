package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Neighborhood consists of one solution with a set of bags and a set of unused items
 */
public class Neighborhood {
    ArrayList<Item> unusedItems;
    Bag[] bags;

    public Neighborhood(ArrayList<Item> unusedItems, Bag[] bags) {
        this.unusedItems = new ArrayList<>(unusedItems);

        this.bags = new Bag[bags.length];
        for(int i = 0; i<bags.length; i++) {
            this.bags[i] = bags[i].clone();

        }

    }

    public ArrayList<Item> getUnusedItems() {
        return unusedItems;
    }

    public Bag[] getBags() {
        return bags;
    }

    public int getTotalValue(){
        int res = 0;
        for(Bag b : bags){
            res+=b.getTotalValue();
        }
        return res;
    }

    public String toString(){
        String res = "Neighborhood with value: " + getTotalValue() + "\n";

        for(int i = 0; i<bags.length; i++) {
            res += bags[i].toString() + "\n";
        }

        return res;
    }
}

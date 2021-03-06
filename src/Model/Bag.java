package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * A representation of the Bag/Knapsack that we will fill with items
 */
public class Bag {
    int capacity;
    int currentSize;
    int totalValue;
    ArrayList<Item> items;
    Random random = new Random();

    public Bag(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;

        items = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }


    public int getCurrentSize() {
        return currentSize;
    }


    public int getTotalValue() {
        return totalValue;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getRandomItem(){
        int index = 0;
        if(!items.isEmpty()) {
            index = random.nextInt(items.size());
            return items.get(index);

        } else {
            return null;
        }

    }

    public void addItem(Item item) {

        items.add(item);
        currentSize = currentSize + item.getWeight();
        this.totalValue += item.getValue();


    }

    public int availableSpace(){
        return (capacity-currentSize);
    }

    public Item removeItem(Item item) {


        currentSize = currentSize - item.getWeight();

        int index = items.indexOf(item);
        this.totalValue -= item.getValue();
        return items.remove(index);
    }

    public Bag clone() {
        Bag newBag = new Bag(capacity);
        newBag.currentSize = currentSize;
        newBag.totalValue = totalValue;

        newBag.items = new ArrayList<>(items);

        return newBag;
    }

    public String toString(){
        return "Bag(capacity: " + this.capacity + ", current size: " +this.currentSize + ", items: "+items.size()+", value: "+totalValue+")";
    }
    public String toFullString(){
        return "Bag(capacity: " + this.capacity + ", current size: " +this.currentSize + ", items: "+this.items+")";
    }


}

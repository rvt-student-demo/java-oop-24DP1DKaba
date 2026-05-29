package rvt.InterfaceInBox;

import java.util.ArrayList;

public class Box implements Packable {

    private double maximumCapacity;
    private ArrayList<Packable> items;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.maximumCapacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;

        for (Packable item : this.items) {
            weight += item.weight();
        }

        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}

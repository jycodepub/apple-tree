package com.jyeh.appletree;

public class Apple implements Comparable<Apple>{
    private String type;
    private double price;
    private double weight;
    private  AppleComparator comparator;

    public Apple(String type, double price, double weight, AppleComparator comparator) {
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.comparator = comparator;
    }

    @Override
    public int compareTo(Apple o) {
        return comparator.compare(this, o);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{type=").append(type)
                .append(", price=").append(price)
                .append(", weight=").append(weight)
                .append("}").toString();
    }
}

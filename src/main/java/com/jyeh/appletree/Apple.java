package com.jyeh.appletree;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Apple implements Comparable<Apple>{
    private String type;
    private double price;
    private double weight;
    private  AppleComparator comparator;

    @Override
    public int compareTo(Apple o) {
        return comparator.compare(this, o);
    }
}

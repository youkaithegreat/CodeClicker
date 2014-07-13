package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/13/2014.
 */
public class MoneyCapacity {
    private String description;
    private long newCapacity;
    private long cost;

    public MoneyCapacity (String description, long newCapacity, long cost){
        description = description;
        newCapacity = newCapacity;
        cost = cost;
    }

    public void buyCapacity(){
        CodeCounters.changeCapacity(newCapacity);
    }
}

package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Sharon on 7/11/2014.
 */
public class CodeCapacity {
    private String description;
    private long newCapacity;
    private long cost;
    private String name;

    public CodeCapacity (String name, String description, long newCapacity, long cost){
        name = name;
        description = description;
        newCapacity = newCapacity;
        cost = cost;
    }

    public void buyCapacity(){
        CodeCounters.changeCapacity(newCapacity);
    }
}

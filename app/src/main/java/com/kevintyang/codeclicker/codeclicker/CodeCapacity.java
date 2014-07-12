package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Sharon on 7/11/2014.
 */
public class CodeCapacity {
    private String description;
    private long newCapacity;
    private long cost;

    public CodeCapacity (String description, long newCapacity, long cost){
        description = description;
        newCapacity = newCapacity;
        cost = cost;
    }

    public long buyCapacity{
        CodeCounters.changeCapacity(newCapacity);
    }
}

package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Sharon on 7/11/2014.
 */
public class CodeCapacity {
    private String descriptionCode;
    private long newCapacityCode;
    private long costCode;
    private String nameCode;

    public CodeCapacity (String name, String description, long newCapacity, long cost){
        nameCode = name;
        descriptionCode = description;
        newCapacityCode = newCapacity;
        costCode = cost;
    }

    public void buyCapacity(){
        if(CodeCounters.changeCapacity(newCapacityCode, costCode))
        {
            //toast, successful purchase
        }else
        {
            //not enough money toast
        }
    }
}

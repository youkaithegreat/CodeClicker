package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/13/2014.
 */
public class MoneyCapacity {
    private String descriptionMoney;
    private long newCapacityMoney;
    private long costMoney;
    private String nameMoney;

    public MoneyCapacity (String name, String description, long newCapacity, long cost){
        nameMoney = name;
        descriptionMoney = description;
        newCapacityMoney = newCapacity;
        costMoney = cost;
    }

    public void buyCapacity(){
        CodeCounters.changeCapacity(newCapacityMoney);
    }
}

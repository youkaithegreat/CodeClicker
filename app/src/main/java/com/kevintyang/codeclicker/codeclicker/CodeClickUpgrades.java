package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/10/2014.
 */
public class CodeClickUpgrades {

    private String description;
    private int clickAddAmount;
    private int cost;
    private int maxQty;
    private int qty = 0;
    private int costMultiplier;


    public CodeClickUpgrades(String name, int clickAddAmount, int initCost, int maxQty, int costMultiplier){
        description = name;
        clickAddAmount = clickAddAmount;
        cost = initCost;
        maxQty = maxQty;
        costMultiplier = costMultiplier;
    }

    public synchronized void buyUpgrade(){
        if(MoneyCounters.getCurrentMoneyCount() >= cost && qty <maxQty) {
            //create a pop up message on GUI
            MoneyCounters.subtractCostOfUpgrades(cost);
            CodeCounters.increaseClickValue(clickAddAmount);
            qty++;
           //update upgrade view with new text

            cost = cost * costMultiplier;
            //changes cost for the next upgrade or sets purchase value to non existent

            //create a GUI message that says insufficient funds(?)
        }
    }

}

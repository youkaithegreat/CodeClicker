package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/10/2014.
 */
public class MoneyProducer {

    private String name = "Empty", description;
    private int qtyOfProducers = 0;
    private double codeAmount = 0;
    private long currentValue = 0;
    private double costToBuy = 0;
    private double costMultiplier;
    private long producerValue = 0;

    public MoneyProducer(String producerName, double codeAmt, String tag, double cost, double costMultiplier){
        name = producerName;
        codeAmount = codeAmt;
        //amount being sold for money at the rate
        description = tag;
        costToBuy = cost;
        costMultiplier = costMultiplier;
    }

    public synchronized void addProducer(){
        if(MoneyCounters.getCurrentMoneyCount() >= costToBuy){
            qtyOfProducers++;
            MoneyCounters.subtractCostOfUpgrades((int)costToBuy);
            costToBuy = (int)(costToBuy * costMultiplier);
            //display message
        }
    }

    public long getProducerValue(){

        producerValue = (int)(qtyOfProducers * codeAmount);
        //the way this is set up if codeAmount is like .1 it will probably truncate it/ cause some problems
        return producerValue;

    }

    public long codeBeingSold(){
        return (long)(codeAmount * qtyOfProducers);
    }

    //may have to turn this into a string
    public long  getCost(){
        return (int)costToBuy;
    }
}

package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/9/2014.
 */
public class MoneyCounters {

    private static long moneyMultiplier = 1;
    private static long moneyPerSecond = 0;
    private static long currentMoneyCount = 0;

    private static long clickValue = 1;
    private static long capacity = 500;


    public synchronized static void sellClick(){
        if(CodeCounters.getCurrentCodeCount() >= clickValue) {
            if(currentMoneyCount + clickValue <= capacity) {
                currentMoneyCount += clickValue;
                CodeCounters.codeSell(clickValue);

            }else if(currentMoneyCount > capacity)
            {
                currentMoneyCount = capacity;
            }

        }
    }

    //synchronized to ensure that we don't get math errors
    public synchronized static void addMoneyPerSecondValue(){

        if(currentMoneyCount >= capacity) {
            currentMoneyCount = capacity;

        } else if (UpgradeObjects.actualizedMoneyPS() +  currentMoneyCount <= capacity) {
            currentMoneyCount = UpgradeObjects.actualizedMoneyPS() + currentMoneyCount;
        }else
            currentMoneyCount = capacity;

    }

    public synchronized static long getCurrentMoneyCount(){

    return currentMoneyCount;

    }

    public static void changeCapacity(long newCapacity){
        capacity = newCapacity;
    }

    public static String getCurrentStr(){

        return "$" + currentMoneyCount + " / " +capacity;
    }

    public static void increaseClickValue(int newClickValue){

        clickValue += newClickValue;
    }

    public static void subtractCostOfUpgrades(long cost){

        currentMoneyCount = currentMoneyCount - cost;
    }

    public String getCapacity(){
        return " / "+capacity;
    }

}

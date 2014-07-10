package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/9/2014.
 */
public class MoneyCounters {

    private static long moneyMultiplier = 1;
    private static long moneyPerSecond = 0;
    private static long currentMoneyCount = 0;
    private static long clickValue;
    public static void codeClick(){

        currentMoneyCount += clickValue;
    }

    //synchronized to ensure that we don't get math errors
    public synchronized static void addMoneyPerSecondValue(){

        currentMoneyCount = moneyPerSecond + currentMoneyCount;
    }

    public synchronized static long getCurrentMoneyCount(){

    return currentMoneyCount;

    }

    public static String getCurrentStr(){

        return "$" + currentMoneyCount;
    }

    public static void increaseClickValue(int newClickValue){

        clickValue += newClickValue;
    }

    public static void subtractCostOfUpgrades(int cost){

        currentMoneyCount = currentMoneyCount - cost;
    }


}

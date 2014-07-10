package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/9/2014.
 */
public class MoneyCounters {

    private static long moneyMultiplier = 1;
    private static long moneyPerSecond = 0;
    private static long currentMoneyCount = 0;


    //synchronized to ensure that we don't get math errors
    public synchronized static void addMoneyValue(){

        currentMoneyCount = moneyPerSecond + currentMoneyCount;
    }

    public static long getCurrentMoneyCount(){

    return currentMoneyCount;

    }

    public static String getCurrentStr(){

        return "$" + currentMoneyCount;
    }

    public static void moneyClick()
    {
        currentMoneyCount = currentMoneyCount + moneyMultiplier;
    }


}

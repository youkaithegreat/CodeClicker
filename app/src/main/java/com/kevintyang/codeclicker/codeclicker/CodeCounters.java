package com.kevintyang.codeclicker.codeclicker;

import android.content.Context;
import android.view.View;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Kevin on 7/9/2014.
 */
public class CodeCounters {

    private static long codePerSecond = 0;

    private static long currentCodeCount = 0;

    private static long clickValue = 1;

    private static long capacity = 500;

    public static void codeClick(){
        if(capacity >= currentCodeCount + clickValue) {
            currentCodeCount += clickValue;
        }else
        {
            currentCodeCount = capacity;
        }
    }

    public static void setCodeCount(long sharedPrefCodeCount)
    {
        currentCodeCount = sharedPrefCodeCount;
    }

    public static void codeSell(long clickValue){
        currentCodeCount = currentCodeCount - clickValue;
    }
    //synchronized, so that we don't get math errors.
    public synchronized static void addCodePerSecondValue(){

            if(currentCodeCount >= capacity){
                currentCodeCount = capacity;
            }else if(currentCodeCount + UpgradeObjects.actualizedCodePS() <= capacity) {
                currentCodeCount = UpgradeObjects.actualizedCodePS() + currentCodeCount;
            }else
                currentCodeCount = capacity;

    }

    public static long getCurrentCodeCount(){
        //clickMultiplier is set for one click one line of code/initially
        return currentCodeCount;
    }

    public static String getCurrentStr(){

        return "//" + currentCodeCount + " / " + capacity;
    }

    public static void increaseClickValue(int newClickValue){
        //increases amount added per click
        clickValue += newClickValue;

    }

    public static long getCurrentCodeCapacity(){
        return capacity;
    }
    //change capacity also sets capacity
    public static void changeCapacity(long newCapacity){
        capacity = newCapacity;
    }


    public String getCapacity(){
        return " / "+capacity;
    }


}

package com.kevintyang.codeclicker.codeclicker;

import android.view.View;

/**
 * Created by Kevin on 7/9/2014.
 */
public class CodeCounters {

    private static long codePerSecond = 0;

    private static long currentCodeCount = 0;

    private static long clickValue = 1;

    public static void codeClick(){

        currentCodeCount += clickValue;
    }

    //synchronized, so that we don't get math errors.
    public synchronized static void addCodePerSecondValue(){
        currentCodeCount = UpgradeObjects.totalCodeProducerPPS() + currentCodeCount;
    }

    public static long getCurrentCodeCount(){
        //clickMultiplier is set for one click one line of code/initially
        return currentCodeCount;
    }

    public static String getCurrentStr(){

        return "//" + currentCodeCount;
    }

    public static void increaseClickValue(int newClickValue){
        //increases amount added per click
        clickValue += newClickValue;

    }



}

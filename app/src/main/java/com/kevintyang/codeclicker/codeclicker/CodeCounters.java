package com.kevintyang.codeclicker.codeclicker;

import android.view.View;

/**
 * Created by Kevin on 7/9/2014.
 */
public class CodeCounters {

    private static long codePerSecond = 0;

    private static long currentCodeCount = 0;

    private static long clickMultiplier = 1;

    public static void clickCode(View view){

        currentCodeCount += clickMultiplier;
    }

    //synchronized, so that we don't get math errors.
    public synchronized static void addCodeValue(){
        currentCodeCount = codePerSecond + currentCodeCount;
    }

    public static long getCurrentCodeCount(){
        //clickMultiplier is set for one click one line of code/initially
        return currentCodeCount;
    }

    public static String getCurrentStr(){

        return "//" + currentCodeCount;
    }



}

package com.kevintyang.codeclicker.codeclicker;

import android.view.accessibility.CaptioningManager;

/**
 * Created by Kevin-Local on 7/11/2014.
 */
public class UpgradeObjects {

    private static long totalCodePPS = 0;
    private static long totalMPPS = 0;
    private static long totalCClickValue = 0;
    private static long totalMClickValue = 0;
    private static long codeBeingAdded =0;
    private static long codeBeingSubtracted = 0;
    private static boolean enoughCode;
    //C for Code M for Money

    static CodeProducer codeExample = new CodeProducer("ExampleName", .1, "Witty tag line/catch phrase should go here", 1000, 1.1 );

    static MoneyProducer moneyExample = new MoneyProducer("ExampleName", .50, "Witty producer tag line", 1000, 1.1);

    static CodeClickUpgrades codeClickExample = new CodeClickUpgrades("WittyName", 1, 10000, 2, 1.5);

    static MoneyClickUpgrades moneyClickExample = new MoneyClickUpgrades("AwesomeName", 1, 1000000, 2, 1.5);

    public static long totalCodeProducerPPS()
    {
        codeBeingAdded = codeExample.getProducerValue();

        codeBeingSubtracted = moneyExample.codeBeingSold();
        if(codeBeingAdded >= codeBeingSubtracted) {

            enoughCode = true;
            totalCodePPS = codeBeingAdded - codeBeingSubtracted;
        }
        else
        {
            enoughCode = false;
            totalCodePPS = 0;
        }

        return totalCodePPS;
    }

    //totalMoneyProducer must ALWAYS be run after totalCodeProducer
    public static long totalMoneyProducerPPS()
    {
        if(enoughCode == true) {
            totalMPPS = moneyExample.getProducerValue();

        }
        else
        {
            totalMPPS = codeBeingAdded;
        }
        return totalMPPS;
    }

    public long totalCodeClickValue(){

        totalCClickValue = codeClickExample.getClickValue();
        return totalCClickValue;

    }

    public long totalMoneyClickValue(){

        totalMClickValue = moneyClickExample.getClickValue();
        return totalMClickValue;
    }


}

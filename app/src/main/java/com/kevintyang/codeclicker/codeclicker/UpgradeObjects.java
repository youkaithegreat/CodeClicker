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
    static MoneyProducer passingGo  = new MoneyProducer("monopolyMan",.1, "You just passed GO to make the money rain!",1100, 1.2);
    static MoneyProducer nerdDownTown  = new MoneyProducer("nerdDownTown",.25, "A nerd just hacked Taco Bell to get you money!",500, .5);
    static MoneyProducer monopolyMan = new MoneyProducer("monopolyMan",.1, "You just passed go to make the money rain!",1100, 1.2);
    static CodeClickUpgrades codeClickExample = new CodeClickUpgrades("WittyName", 1, 10000, 2, 1.5);

    static MoneyClickUpgrades moneyClickExample = new MoneyClickUpgrades("AwesomeName", 1, 1000000, 2, 1.5);

    //add your code producer objects here 
    public static long totalCodeProducerPPS()
    {
        totalCodePPS = codeExample.getProducerValue();
        return totalCodePPS;
    }

    //DON"T TOUCH THIS
    public synchronized static boolean enoughCode(){
        if(totalCodeProducerPPS() >= totalMoneyProducerPPS())
        {
            return true;
        }
        else
            return false;
    }

    //add OBJECTS when created.
    public static long totalMoneyProducerPPS()
    {

        totalMPPS = moneyExample.getProducerValue();
        return totalMPPS;
    }

    //DONT TOUCH THIS.
    public synchronized static long actualizedCodePS(){
        long totalCPS = totalCodeProducerPPS();
        long totalMPS = totalMoneyProducerPPS();
        long currentCodeCount = CodeCounters.getCurrentCodeCount();
        long difference = totalCPS - totalMPS;
        boolean enough = enoughCode();
        if(enough){
            return totalCPS - totalMPS;
        }else if(!enough && currentCodeCount == 0){
            return 0;
        }else if(!enough && currentCodeCount > 0 && difference >= currentCodeCount){
            return 0 - difference;
        }else if(!enough && currentCodeCount > 0&& (difference < currentCodeCount))
            return 0 - currentCodeCount ;
        return 0;
    }

    //DONT TOUCH THIS
    public synchronized static long actualizedMoneyPS(){
        long totalCPS = totalCodeProducerPPS();
        long totalMPS = totalMoneyProducerPPS();
        long currentCodeCount = CodeCounters.getCurrentCodeCount();
        long difference = totalCPS - totalMPS;
        boolean enough = enoughCode();
        if(enough){
            return totalMPS;
        }else if(!enough && currentCodeCount == 0){
            return totalCPS;
        }else if(!enough && currentCodeCount > 0 && difference >= currentCodeCount){
            return totalCPS + difference;
        }
        return 0;
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

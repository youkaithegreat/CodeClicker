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

    static CodeProducer codeExample = new CodeProducer("ExampleName", 20, "Witty tag line/catch phrase should go here", 1000, 1.1 );

    static MoneyProducer moneyExample = new MoneyProducer("ExampleName", .50, "Witty producer tag line", 1000, 1.1);
    static MoneyProducer dropout  = new MoneyProducer("Dropout",1, "You just passed GO to make the money rain!",22, .5);
    static MoneyProducer hackerBeast = new MoneyProducer("Hacker Beast",3, "Hacker Beast just hacked mcJondalds to get you money",550, 1.0);
    static MoneyProducer collegeNerd = new MoneyProducer("College Nerd",5, "College Nerd got lazy and decided to buy your code",6242, 1.2);
    static MoneyProducer loogleEmployee = new MoneyProducer("Loogle Employee",13, "you made a back alley deal with an loogle employee",33531, 1.5);
    static MoneyProducer ceoOfMyFace = new MoneyProducer("Ceo Of MyFace ",29, "MyFace's CEO couldn't make his own code and brought yours ",253525, 1.7);
    static MoneyProducer startupMyFace = new MoneyProducer("Start up MyFace",66, "MyFace need your code you just made bank",943550, 1.825);
    static MoneyProducer loogle = new MoneyProducer("Loogle",420, " Loogle just hired you to take over their coding division, you are now a Coding Master!!!  ",790000000, 2.5);
    static MoneyProducer c4P0 = new MoneyProducer("C4P0",1000, "College Nerd got lazy and decided to buy your code",43200000, 1.621);
    static MoneyProducer superSecretAgency = new MoneyProducer("Super Secret Agency",1675, "You were snatched and taken away trust me you made a lot of money for people you will never know ",7000000, 3);
    static MoneyProducer billBanks = new MoneyProducer("Bill Banks",5, "Bill Banks said he got nothing on you, you are now the Best!! ",1002003215, 3.5);
    static CodeClickUpgrades codeClickExample = new CodeClickUpgrades("WittyName", 1, 10000, 2, 3.6);

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

        totalMPPS = moneyExample.getProducerValue() + dropout.getProducerValue() + hackerBeast.getProducerValue()
                + collegeNerd.getProducerValue() + loogleEmployee.getProducerValue() + ceoOfMyFace.getProducerValue() + startupMyFace.getProducerValue() + loogle.getProducerValue() + c4P0.getProducerValue() + superSecretAgency.getProducerValue() + billBanks.getProducerValue();
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

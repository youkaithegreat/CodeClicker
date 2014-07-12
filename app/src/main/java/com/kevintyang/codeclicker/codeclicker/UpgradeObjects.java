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
    static CodeProducer codingBook = new CodeProducer("Coding Book", .1, "You bought a coding book to learn how to program!",15, 1.1);
    static CodeProducer mom = new CodeProducer("Mom",1, "Your mom wants to help you code!", 343, 1.3);
    static CodeProducer friend = new CodeProducer("Friend", 3, "You made your friend help you program!", 5000, 1.5);
    static CodeProducer collegeUndergrad = new CodeProducer("College Undergrad", 12, "An undergrad staying up late with you to help!", 15000, 1.3);
    static CodeProducer intern = new CodeProducer("Intern", 28, "An intern is producing software with you!", 100000, 1.4);
    static CodeProducer compSciGrad = new CodeProducer("Computer Science Grad", 64, "A computer science graduate student is helping you code!", 800000, 1.6);
    static CodeProducer softwareDeveloper = new CodeProducer("Software Developer", 320, "A software developer is developing programs for you!",123000000, 1.9);
    static CodeProducer markZookerburg = new CodeProducer("Mark Zookerburg", 999, "Mark Zookerburg is designing awesome software with you!", 458000000,2.2);
    static CodeProducer r3d3 = new CodeProducer("R3D3", 1600, "You created a robot to create code for you!", 784000000, 2.5);
    static CodeProducer virus = new CodeProducer("virus", 2424, "You have designed a virus to produce tons of code!", 958000000, 3.0);

    static MoneyProducer moneyExample = new MoneyProducer("ExampleName", .50, "Witty producer tag line", 1000, 1.1);
    static MoneyProducer passingGo  = new MoneyProducer("monopolyMan",.1, "You just passed GO to make the money rain!",1100, 1.2);
    static MoneyProducer nerdDownTown  = new MoneyProducer("nerdDownTown",.25, "A nerd just hacked Taco Bell to get you money!",500, .5);
    static MoneyProducer monopolyMan = new MoneyProducer("monopolyMan",.1, "You just passed go to make the money rain!",1100, 1.2);
    static CodeClickUpgrades codeClickExample = new CodeClickUpgrades("WittyName", 1, 10000, 2, 1.5);

    static MoneyClickUpgrades moneyClickExample = new MoneyClickUpgrades("AwesomeName", 1, 1000000, 2, 1.5);

    //add your code producer objects here 
    public static long totalCodeProducerPPS()
    {
        totalCodePPS = codeExample.getProducerValue() + mom.getProducerValue() + friend.getProducerValue() + collegeUndergrad.getProducerValue() + intern.getProducerValue()
                + compSciGrad.getProducerValue() + softwareDeveloper.getProducerValue() + markZookerburg.getProducerValue() + r3d3.getProducerValue() + virus.getProducerValue();
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

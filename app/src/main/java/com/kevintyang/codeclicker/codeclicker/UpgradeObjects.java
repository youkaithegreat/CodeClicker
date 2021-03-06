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

    static CodeClickUpgrades codeClickExample = new CodeClickUpgrades("WittyName", 1, 100, 2, 1.5);

    static MoneyClickUpgrades moneyClickExample = new MoneyClickUpgrades("AwesomeName", 1, 100, 2, 1.5);

    public static void buyCodeClickUpgrades(){
        codeClickExample.buyUpgrade();
    }
    public static void buyMoneyClickUpgrades(){ moneyClickExample.buyUpgrade();}
    //add your code producer objects here 
    public static long totalCodeProducerPPS()
    {
        totalCodePPS = codingBook.getProducerValue() + mom.getProducerValue() + friend.getProducerValue() + collegeUndergrad.getProducerValue() + intern.getProducerValue()
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

        totalMPPS = dropout.getProducerValue() + hackerBeast.getProducerValue()
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

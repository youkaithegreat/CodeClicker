package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin-Local on 7/11/2014.
 */
public class CapacityUpgrades {

    static MoneyCapacity pockets = new MoneyCapacity("Pockets","Old fashion coin bank.", 1000, 300);
    static MoneyCapacity envelope = new MoneyCapacity("Envelope", "Putting paper in paper.", 20000, 700);
    static MoneyCapacity wallet = new MoneyCapacity("Wallet", "Good old old leather storage.", 400000, 15000);
    static MoneyCapacity piggyBank = new MoneyCapacity("Piggy Bank", "Pigs don't have banks.",8000000, 300000);
    static MoneyCapacity strongBox = new MoneyCapacity("Strongbox", "Don't mess with the box.", 160000000, 650000);
    static MoneyCapacity safe = new MoneyCapacity("Safe", "No one will ever touch your money again.", 3200000000L, 110000000);
    static MoneyCapacity chest = new MoneyCapacity("Chest", "A pirate's storage!", 64000000000L, 2250000000L);
    static MoneyCapacity vault = new MoneyCapacity("Vault", "Storage for the rich", 1280000000000L, 45000000000L);
    static MoneyCapacity undergroundRepository = new MoneyCapacity("Underground Repository", "Because there wasn't enough room on the surface", 25600000000000L, 900000000000L);
    static MoneyCapacity privateIsland = new MoneyCapacity ("Private Island", "How could you possibly need more room than this?", 512000000000000L, 18000000000000L);
    static MoneyCapacity planet = new MoneyCapacity ("Planet", "Really?...", 1000000000000000L, 360000000000000L);

    static CodeCapacity punchCard = new CodeCapacity("Punch Card", "Back in the old days...", 1000, 300);
    static CodeCapacity floppyDisk = new CodeCapacity("Floppy Disk", "Still back in the old days...", 20000, 700);
    static CodeCapacity compactDisc = new CodeCapacity("Compact Disc", "Why don't you take me out for a spin?", 400000, 15000);
    static CodeCapacity digitalVideoDisc = new CodeCapacity("Digital Video Disc", "I promise, I'm different than a CD.", 8000000, 300000);  //joke needed
    static CodeCapacity bluRay = new CodeCapacity("Blu-Ray", "I promise, I'm even more different than a CD.", 160000000, 650000);
    static CodeCapacity microSecureDigitalCard = new CodeCapacity("Blu-Ray", "I promise, I'm even more different than a CD.", 3200000000L, 110000000);
    static CodeCapacity secureDigitalCard = new CodeCapacity("SD Card", "Size doesn't mean everything.", 64000000000L, 2250000000L);
    static CodeCapacity universalSerialBus = new CodeCapacity("USB", "Who wouldn't want a Universal Cereal Bus?", 1280000000000L, 45000000000L);
    static CodeCapacity hardDiskDrive = new CodeCapacity("Hard Drive", "Bigger, better, faster, stronger.", 25600000000000L , 900000000000L);
    static CodeCapacity solidStateDrive = new CodeCapacity("Solid State Drive", "Better, faster, stronger. But smaller.", 512000000000000L , 18000000000000L);
    static CodeCapacity cloud = new CodeCapacity("Cloud", "You have a cloud. You win." , 1000000000000000L , 360000000000000L);


    public static void buyPockets() { pockets.buyCapacity();}
    public static void buyEnvelope() { envelope.buyCapacity();}
    public static void buyWallet() { wallet.buyCapacity();}
    public static void buyPiggyBank() { piggyBank.buyCapacity();}
    public static void buyStrongBox() { strongBox.buyCapacity();}
    public static void buySafe() { safe.buyCapacity();}
    public static void buyChest() { chest.buyCapacity();}
    public static void buyVault() { vault.buyCapacity();}
    public static void buyUndergroundRepository() { undergroundRepository.buyCapacity();}
    public static void buyPrivateIsland() { privateIsland.buyCapacity();}
    public static void buyPlanet() { planet.buyCapacity();}

    public static void buyPunchCard(){ punchCard.buyCapacity(); }
    public static void buyFloppyDisk(){
        floppyDisk.buyCapacity();
    }
    public static void buyCompactDisk(){
        compactDisc.buyCapacity();
    }
    public static void buyDigitalVideoDisc(){
        digitalVideoDisc.buyCapacity();
    }
    public static void buyBluRay(){
        bluRay.buyCapacity();
    }
    public static void buyMicrosSecureDigitalCard(){
        microSecureDigitalCard.buyCapacity();
    }
    public static void buySecureDigitalCard(){
        secureDigitalCard.buyCapacity();
    }
    public static void buyUniversalSerialBus(){
        universalSerialBus.buyCapacity();
    }
    public static void buyHardDiskDrive(){
        hardDiskDrive.buyCapacity();
    }
    public static void buySolidStateDrive(){
        solidStateDrive.buyCapacity();
    }
    public static void buyCloud(){
        cloud.buyCapacity();
    }








}

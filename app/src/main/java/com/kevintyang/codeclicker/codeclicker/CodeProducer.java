package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/10/2014.
 */
public class CodeProducer {


        private String name = "Empty", description;
        private int qtyOfProducers = 0;
        private double codeAmount = 0;
        private long currentValue = 0;
        private long costToBuy = 0;
        private double costMultiplier;

        public CodeProducer(String producerName, double codeAmt, String tag, int cost, double costMultiplier){
            name = producerName;
            codeAmount = codeAmt;
            description = tag;
            costToBuy = cost;
            costMultiplier = costMultiplier;
        }

        public synchronized void addProducer(){
            if(MoneyCounters.getCurrentMoneyCount() >= costToBuy){
                qtyOfProducers++;
              MoneyCounters.subtractCostOfUpgrades((int)costToBuy);
               costToBuy = (int)(costToBuy * costMultiplier);
                //display message
            }
        }
        /*
        public void subtractProducer(){
            qtyOfProducers--;
            costToBuy = (int)(costToBuy/costMultiplier);
        }*/
        //extra method we may not instatiate


        //may have to turn this into a string
        public long  getCost(){
            return costToBuy;
        }

    }




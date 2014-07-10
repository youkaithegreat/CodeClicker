package com.kevintyang.codeclicker.codeclicker;

/**
 * Created by Kevin on 7/10/2014.
 */
public class CodeProducer {


        private String name = "Empty", description;
        private int qtyOfProducers = 0;
        private int codeAmount = 0, currentValue = 0;
        private int costToBuy = 0;
        private double costMultiplier;

        public CodeProducer(String producerName, int codeAmt, String tag, int cost, int costMultiplier){
            name = producerName;
            codeAmount = codeAmt;
            description = tag;
            costToBuy = cost;
            costMultiplier = costMultiplier;
        }

        public synchronized void addProducer(){
            if(MoneyCounters.getCurrentMoneyCount() >= costToBuy){
                qtyOfProducers++;
              MoneyCounters.subtractCostOfUpgrades(costToBuy);
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




package com.kevintyang.codeclicker.codeclicker;

import android.os.Handler;
import android.widget.TextView;

import java.util.TimerTask;
import java.util.Timer;

/**
 * Created by Kevin on 7/9/2014.
 */
public class Ticker extends Thread{

    private Handler handler = new Handler();

    public void run(){



        while(true)
        {

                try {
                    //adds the value of each per second
                    CodeCounters.addCodePerSecondValue();
                    MoneyCounters.addMoneyPerSecondValue();

                    sleep(990);

                }catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    System.exit(0);
                }
        }

    }

}

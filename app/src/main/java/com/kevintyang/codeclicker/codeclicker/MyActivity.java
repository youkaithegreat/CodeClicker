package com.kevintyang.codeclicker.codeclicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.TimerTask;
import android.widget.TextView;
import java.util.Timer;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Ticker tick = new Ticker();
        tick.start();
        //starts counting the code per second/money per second

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                updateMoneyTextView();
                updateCodeTextView();
            }
        }, 50, 100);



    }

    public void onPause(){
        super.onPause();

    }

    public void updateMoneyTextView() {

        TextView textView = (TextView) findViewById(R.id.cashTextView);
        textView.setText(MoneyCounters.getCurrentStr());

        return;
    }

    public void updateCodeTextView() {

        TextView textView = (TextView) findViewById(R.id.codeTextView);
        textView.setText(CodeCounters.getCurrentStr());

        return;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

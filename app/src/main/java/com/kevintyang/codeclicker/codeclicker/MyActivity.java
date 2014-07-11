package com.kevintyang.codeclicker.codeclicker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.*;

public class MyActivity extends Activity {

    //private variables to avoid creating additional objects
    private ImageView mCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove title bar. Eventually I need to the learn the 4.4 call to get Immersion Mode (no On Screen Navs
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_my);


        //Sets screen orientation to Portrait. We are also changing orientation in the xml, I might move it to the manifest . .
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //Get some variables
        mCodeButton = (ImageView)findViewById(R.id.keyboardButton);

        mCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateCodeButton();
                codeClick();
            }
        });


        Ticker tick = new Ticker();
        tick.start();
        //starts counting the code per second/money per second

    }

    @SuppressLint("NewApi")
    protected void onResume(){
        super.onResume();

        // Check what version of android they are running.
        // If they are running Kit Kat . . .
        if (Build.VERSION.SDK_INT >= 19) {

            int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            this.findViewById(android.R.id.content).setSystemUiVisibility(flags);
        }

        Log.d("Immersive Mode Activity", "onResume Called!");
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

    public void codeClick(){
        CodeCounters.codeClick();
        updateCodeTextView();
    }

    private void animateCodeButton() {
        mCodeButton.setImageResource(R.drawable.keyboard_click);
        AnimationDrawable buttonPress = (AnimationDrawable) mCodeButton.getDrawable();
        if(buttonPress.isRunning()) {
            buttonPress.stop();
        }
        buttonPress.start();
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


    private Runnable resetImmersive = new Runnable(){

        @SuppressLint("NewApi")
        @Override
        public void run() {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        }

    };

    private Handler mHandler = new Handler();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (Build.VERSION.SDK_INT >= 19){
            if (keyCode == KeyEvent.KEYCODE_BACK){
                finish();
            } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
                mHandler.postDelayed(resetImmersive, 450);
            }
        }
        return super.onKeyDown(keyCode, event);
    }



}

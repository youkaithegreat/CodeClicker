package com.kevintyang.codeclicker.codeclicker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.*;

public class MyActivity extends Activity {

    //private variables to avoid creating additional objects
    private ImageView mCodeButton;
    private ImageView mUpgradeButton;
    private ImageView mSellButton;
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    final static Ticker tick = new Ticker();
    final static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar. Eventually I need to the learn the 4.4 call to get Immersion Mode (no On Screen Navs
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.fragment_code);

        //new shit
        setContentView(R.layout.activity_my);

        //Sets screen orientation to Portrait. We are also changing orientation in the xml, I might move it to the manifest . .
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


       // tick.start();
        //starts counting the code per second/money per second

        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        handler.postDelayed(runnable, 100);

       //Get some variables
       /* mCodeButton = (ImageView)findViewById(R.id.keyboardButton);
        mUpgradeButton = (ImageView)findViewById(R.id.upgrades_button);
        mSellButton = (ImageView)findViewById(R.id.sellButton);




        mUpgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    sendMessage();
                }

        });

        mCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeClick();
            }
        });

        /*SwipeDetector swipeDetector = new SwipeDetector();
        mCodeButton.setOnTouchListener(swipeDetector);

        if (swipeDetector.getAction() == SwipeDetector.Action.LR) {
            this.setContentView(R.layout.fragment_sell);
        }*/
    }

    Runnable runnable = new Runnable() {

        public int timeCheck = 0;

        @Override
        public void run() {

            if(timeCheck >=990) {
                CodeCounters.addCodePerSecondValue();
                MoneyCounters.addMoneyPerSecondValue();
                timeCheck = 0;
            }
            timeCheck = timeCheck + 100;
            updateCodeTextView();
            handler.postDelayed(this, 100);


        }
    };
    //ViewPagerStuff
    /* @Override
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
    } */


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }

    //end viewpager stuff

    private void sendMessage() {
        Intent intent = new Intent(MyActivity.this, UpgradeScreen.class);
        startActivity(intent);
    }

    @SuppressLint("NewApi")
    protected void onResume(){
        super.onResume();


        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 200);
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


    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);

    }


    public void onPause(){
        super.onPause();
        handler.removeCallbacks(runnable);

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
        /*animateCodeButton();*/
        CodeCounters.codeClick();
        updateCodeTextView();
        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(30);
    }

    public void sellClick(){
        MoneyCounters.sellClick();
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

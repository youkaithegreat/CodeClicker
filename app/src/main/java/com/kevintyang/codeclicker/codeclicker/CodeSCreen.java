package com.kevintyang.codeclicker.codeclicker;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;




/**
 * Created by jameshuang on 7/11/14.
 */
public class CodeScreen extends Fragment {

    private ImageView mCodeButton;

    public void onClick(View v) {

        mCodeButton = (ImageView)getView().findViewById(R.id.keyboardButton);

        mCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateCodeButton();
            }
        });

    }

    public void codeClick(){
        /*animateCodeButton();*/
        CodeCounters.codeClick();

        //Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
       // v.vibrate(30);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false);

        }

    }

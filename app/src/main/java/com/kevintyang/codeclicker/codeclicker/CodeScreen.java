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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code, container, false);

        }

    }

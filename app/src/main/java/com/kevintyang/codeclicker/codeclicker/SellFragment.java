package com.kevintyang.codeclicker.codeclicker;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;

import android.view.LayoutInflater;
import android.view.ViewGroup;
/**
 * Created by Kevin-Local on 7/12/2014.
 */
public class SellFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.screen_sell, container, false);
    }
}

package com.example.jacob.utpbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jacob on 9/8/2015.
 */
public class BuildingLocator extends Fragment{

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.building_locator, container, false);

        return view;

//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

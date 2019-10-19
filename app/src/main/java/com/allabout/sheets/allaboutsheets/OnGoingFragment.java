package com.allabout.sheets.allaboutsheets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnGoingFragment extends Fragment {


    public OnGoingFragment() {
        // Required empty public constructor
    }

    public static OnGoingFragment fragment;

    public static OnGoingFragment getInstance(){
        if (fragment==null)
            fragment = new OnGoingFragment();
        return fragment;
    }

    public static OnGoingFragment refresh(){
        fragment = null;
        return getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_going, container, false);
        return view;
    }

}

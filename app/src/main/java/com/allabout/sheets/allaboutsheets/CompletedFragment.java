package com.allabout.sheets.allaboutsheets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedFragment extends Fragment {


    public CompletedFragment() {
        // Required empty public constructor
    }

    public static CompletedFragment fragment;

    public static CompletedFragment getInstance(){
        if (fragment==null)
            fragment = new CompletedFragment();
        return fragment;
    }

    public static CompletedFragment refresh(){
        fragment = null;
        return getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);
        return view;
    }

}

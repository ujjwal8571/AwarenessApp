package com.example.android.awarenessapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ResolvedComplaint extends Fragment {



    public ResolvedComplaint() {
        // Required empty public constructor
    }


    public static ResolvedComplaint newInstance() {
        ResolvedComplaint fragment = new ResolvedComplaint();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resolved_complaint, container, false);
    }


}

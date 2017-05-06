package com.example.android.awarenessapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.plus.PlusOneButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddComplaint extends Fragment {

    EditText tvName;
    EditText tvLocation;
    EditText tvDescription;
    Button submitButton;
    String userId;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    public AddComplaint() {
        // Required empty public constructor
    }


    public static AddComplaint newInstance() {
        AddComplaint fragment = new AddComplaint();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_complaint, container, false);


        mFirebaseInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabase = mFirebaseInstance.getReference("complaints");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Complaints");




        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvName = (EditText)getView().findViewById(R.id.editText);
        tvLocation = (EditText) getView().findViewById(R.id.editText2);
        tvDescription = (EditText) getView().findViewById(R.id.editText3);
        submitButton = (Button) getView().findViewById(R.id.button);





        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(TextUtils.isEmpty(userId)) {

                userId = mFirebaseDatabase.push().getKey();


                String cName = tvName.getText().toString();
                String cDescp = tvDescription.getText().toString();
                String cLocat = tvLocation.getText().toString();

                final Complaint complaint = new Complaint();
                complaint.setName(cName);
                complaint.setDescription(cDescp);
                complaint.setIsResolved(false);
                complaint.setLocation(cLocat);


                mFirebaseDatabase.child(userId).setValue(complaint);

                }
            }
        });



    }


    //    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//    }
}

package com.bro.kart.eventapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText edtemail;
EditText edtdate;
Button btncreateevent;

    private FirebaseDatabase mFirebaseInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_registration);
        initViews();

        findViewById(R.id.btncreateevent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtemail.getText().toString().length() > 0) {
                    mFirebaseInstance.getReference("myref").push().setValue(edtemail.getText().toString());
                }
            }
        });
    }


    private void initViews() {
        edtdate=findViewById(R.id.edtdate);
        edtemail=findViewById(R.id.edtdate);
        btncreateevent=findViewById(R.id.btncreateevent);
    }
}

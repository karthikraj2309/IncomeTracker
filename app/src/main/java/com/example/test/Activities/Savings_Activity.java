package com.example.test.Activities;

import android.animation.FloatArrayEvaluator;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.DecimalFormat;
import android.view.View.OnFocusChangeListener;

import com.example.test.R;

import java.text.NumberFormat;


public class Savings_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);


            EditText txtDate=(EditText)findViewById(R.id.txtdate);



            txtDate.setOnFocusChangeListener(new OnFocusChangeListener(){
                public void onFocusChange(View view, boolean hasfocus){
                    if(hasfocus){
                        com.example.test.DateDialog dialog=new com.example.test
                                .DateDialog(view);
                        FragmentTransaction ft =getFragmentManager().beginTransaction();
                        dialog.show(ft, "DatePicker");





                    }
                }

            });





    }
}
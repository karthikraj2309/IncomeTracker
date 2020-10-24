package com.example.test.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.DbHelpers.DatabaseHelper;
import com.example.test.Model.Income_Model;
import com.example.test.R;

import java.util.ArrayList;

public class Income_Activity extends AppCompatActivity {
    public ArrayList<Income_Model> income_modelArrayList= new ArrayList<>();


    private EditText sources;
    private EditText text;
    private Button savebut;
    double values;
    DatabaseHelper myDb;
    Button btnviewAll;
    static double sum;
    TextView remains;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_income);
        sources=(EditText)findViewById(R.id.sources);
        text=(EditText)findViewById(R.id.value);
        myDb = new DatabaseHelper(this);
        savebut=(Button)findViewById(R.id.saveButton);


        btnviewAll=(Button)findViewById(R.id.button_viewAll);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDb.insertData(sources.getText().toString(),values=Double.parseDouble(text.getText().toString()));
                if(isInserted == true)
                    Toast.makeText(getBaseContext(),"Data is Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"Data is Not Inserted",Toast.LENGTH_LONG).show();
            }
        });





    }





}

package com.example.test.Activities;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.test.DbHelpers.DatabaseHelper1;
import com.example.test.R;

public class Expenses_Activity extends AppCompatActivity {

    private Spinner listspinner;
    ArrayAdapter<CharSequence> adapter;
    static int prio;
    static double Values;
    private EditText expenseName;
    private EditText expensevalues;
    Button btnviewAll;
    private Button addDatabut;
    DatabaseHelper1 myDb1;
 double sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        listspinner=(Spinner)findViewById(R.id.spinnerList);
        expenseName=(EditText)findViewById(R.id.Sources);
        expensevalues=(EditText)findViewById(R.id.expenses_values);
        addDatabut=(Button)findViewById(R.id.saveButton);
        myDb1 = new DatabaseHelper1(this);

        btnviewAll=(Button)findViewById(R.id.button_viewAll);


        adapter=ArrayAdapter.createFromResource(this,R.array.expense_list,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listspinner.setAdapter(adapter);

        listspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prio=position;
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+"",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addDatabut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb1.insertData(expenseName.getText().toString(),Values=Double.parseDouble(expensevalues.getText().toString()),prio);
                if(isInserted == true)
                    Toast.makeText(getBaseContext(),"Data is Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"Data is Not Inserted",Toast.LENGTH_LONG).show();
            }
        });




    }






}

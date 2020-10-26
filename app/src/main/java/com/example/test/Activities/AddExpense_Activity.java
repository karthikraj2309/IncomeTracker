package com.example.mysampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test.Activities.Expenses_Activity;
import com.example.test.R;

public class AddExpense_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_expense);
    }
    public void onButtonclick(View v)
    {
        EditText e1=(EditText)findViewById(R.id.editText);
        EditText e2=(EditText)findViewById(R.id.editText2);
        //Button b1=(Button)findViewById(R.id.button_run);
        TextView t1=(TextView)findViewById(R.id.textView);
        int num1=Integer.parseInt(e1.getText().toString());
        int num2=Integer.parseInt(e2.getText().toString());
        int sum=num1+num2;
        t1.setText(Integer.toString(sum));
        String msg=t1.getText().toString();
        Intent intent1=new Intent(this, Expenses_Activity.class);
        intent1.putExtra("code1",msg);
        startActivity(intent1);
    }
}
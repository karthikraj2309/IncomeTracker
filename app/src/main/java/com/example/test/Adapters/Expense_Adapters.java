package com.example.test.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.test.Model.Expense_Model;
import com.example.test.Model.Income_Model;
import com.example.test.R;

import java.util.ArrayList;

public class Expense_Adapters extends ArrayAdapter<Expense_Model> {

    public Expense_Adapters(Context context, ArrayList<Expense_Model> expense_arraylist){
        super (context,0,expense_arraylist);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.expense_each_list,parent,false);
        }
        Expense_Model currentExpenses=getItem(position);
        TextView expsrc=(TextView)listItemView.findViewById(R.id.Expsrc_list);
        TextView expval=(TextView)listItemView.findViewById(R.id.Expval_list);
        TextView exprio=(TextView)listItemView.findViewById(R.id.ExpPrio_list);
        expsrc.setText(currentExpenses.getExpSrc());
        expval.setText(currentExpenses.getExpVal().toString());
        exprio.setText(currentExpenses.getPrios().toString());
        return listItemView;

    }
}

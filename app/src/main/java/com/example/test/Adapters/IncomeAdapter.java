package com.example.test.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.test.Model.Income_Model;
import com.example.test.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class IncomeAdapter extends ArrayAdapter<Income_Model> {
    public Income_adapter(Context context, ArrayList<Income_Model> income_arraylist) {

        super(context, 0, income_arraylist);
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.income_each_list,parent,false);
        }
        Income_Model currentIncome=getItem(position);
        TextView incsrc=(TextView)listItemView.findViewById(R.id.income_source_list);
        TextView incval=(TextView)listItemView.findViewById(R.id.income_value_list);
        incsrc.setText(currentIncome.getIncSrc());
        incval.setText(currentIncome.getIncVal().toString());
        return listItemView;

    }
}
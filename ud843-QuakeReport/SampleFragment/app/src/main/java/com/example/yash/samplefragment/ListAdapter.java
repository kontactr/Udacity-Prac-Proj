package com.example.yash.samplefragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yash on 08-01-2018.
 */

public class ListAdapter extends ArrayAdapter<String> {
    public ListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if (textView == null)
            LayoutInflater.from(getContext()).inflate(R.layout.list_items,null);

        textView.setText(""+getItem(position));
        return textView;
    }
}



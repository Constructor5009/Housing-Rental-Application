package com.example.newroof;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class cardapter extends ArrayAdapter {

    Context context;
    List<String> nm,address,phno;
    List<Integer> listImage;


    public cardapter(@NonNull Context context, List<String> nm, List<String> address, List<String> phno, List<Integer> li) {
        super(context, R.layout.list, nm);

        this.context = context;
        this.nm = nm;
        this.address =address;
        this.phno = phno;
        this.listImage = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list,parent,false);

        ImageView iv = (ImageView) v.findViewById(R.id.imageview);
        TextView nam = (TextView) v.findViewById(R.id.nm);
        TextView aaddress = (TextView) v.findViewById(R.id.address);
        TextView pphno = (TextView) v.findViewById(R.id.phno);

        iv.setImageResource(listImage.get(position));
        nam.setText(nm.get(position));
        aaddress.setText(address.get(position));
        pphno.setText((phno.get(position)));

        return v;
    }
}

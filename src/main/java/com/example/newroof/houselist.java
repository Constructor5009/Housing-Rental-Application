package com.example.newroof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class houselist extends AppCompatActivity {
    ListView lv;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houselist);

        lv = (ListView) findViewById(R.id.lv);

        List<String> nm = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> phno = new ArrayList<>();
        List<Integer> image = new ArrayList<>();

        nm.add("Aamir");
        nm.add("Devika");
        nm.add("Nikunj");
        nm.add("Manasi");

        address.add("Mira Road");
        address.add("Vashi");
        address.add("Bhayandar");
        address.add("Vashi");

        phno.add("8928178181");
        phno.add("8928178181");
        phno.add("8928178181");
        phno.add("8928178181");

        image.add(R.drawable.peach_door);
        image.add(R.drawable.peach_door);
        image.add(R.drawable.peach_door);
        image.add(R.drawable.peach_door);

        cardapter cardapter = new cardapter(this,nm,address,phno,image);
        lv.setAdapter(cardapter);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(houselist.this,Dashboard.class);
                startActivity(i);
            }
        });
    }
}
package com.example.newroof;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {

    Button logout;
    TextView cu;
    String email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container,false);
        logout = (Button)v.findViewById(R.id.logout);
        cu = (TextView)v.findViewById(R.id.ci);
        Dashboard activity = (Dashboard) getActivity();
        email = activity.gtdt();
        cu.setText(email);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),loginactivity.class);
                startActivity(i);
            }
        });
        return v;
    }


}


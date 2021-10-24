package com.example.newroof;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class forgetpassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email;
    Button reco;
    String resmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_forgetpassword);
        email = (EditText) findViewById(R.id.fpemail);
        reco = (Button) findViewById(R.id.recover);
    }
    public void recovpass(View v){
        resmail = email.getText().toString().trim();
        mAuth.sendPasswordResetEmail(resmail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(forgetpassword.this,"Reset Link has been sent to your email",Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(forgetpassword.this,"Error! Reset Link not sent. "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
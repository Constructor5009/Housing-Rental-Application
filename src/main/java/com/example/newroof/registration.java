package com.example.newroof;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {

    private EditText username,password,repassw,email;
    Button register;
    private FirebaseAuth mAuth;
    private ProgressDialog mloadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        register =(Button) findViewById(R.id.registerbtn);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassw = (EditText)findViewById(R.id.Repassword);
        email = (EditText) findViewById(R.id.email);
        mAuth = FirebaseAuth.getInstance();
        mloadingbar = new ProgressDialog(registration.this);

    }
    public void register(View v){
        String usne = username.getText().toString().trim();
        String passw = password.getText().toString().trim();
        String repass = repassw.getText().toString().trim();
        String em = email.getText().toString().trim();
        if(usne.equals("") || passw.equals("") || repass.equals("") || em.equals("")){

            Toast.makeText(registration.this,"Enter All Fields",Toast.LENGTH_SHORT).show();
        }
        else {

            mloadingbar.setTitle("Registeration");
            mloadingbar.setMessage("Please wait..");
            mloadingbar.setCanceledOnTouchOutside(false);
            mloadingbar.show();


            mAuth.createUserWithEmailAndPassword(em,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        User user = new User(usne,em);
                        FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            mloadingbar.dismiss();
                                            Toast.makeText(registration.this,"Welcome",Toast.LENGTH_SHORT).show();
                                            Intent i = new Intent(registration.this, loginactivity.class);
                                            startActivity(i);
                                        }else{
                                            Toast.makeText(registration.this,"The User Registration Failed",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                    else{
                        Toast.makeText(registration.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
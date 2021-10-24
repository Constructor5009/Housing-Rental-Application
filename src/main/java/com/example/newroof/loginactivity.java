package com.example.newroof;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {
    TextView fp,register;
    EditText email,password;
    Button login;
    private FirebaseAuth mAuth;
    ProgressDialog mloadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        login = (Button) findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();
        mloadingbar = new ProgressDialog(loginactivity.this);
    }
    public void login(View v)
    {
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        String em = email.getText().toString();
        String psw = password.getText().toString();
        if (em.equals("") || psw.equals("") || !em.contains("@") || em.length() < 5 || !em.contains(".com")) {
            Toast.makeText(loginactivity.this, "Login Failed, Invalid Credentials", Toast.LENGTH_SHORT).show();
        } else {
            mloadingbar.setTitle("Login");
            mloadingbar.setMessage("Please wait..");
            mloadingbar.setCanceledOnTouchOutside(false);
            mloadingbar.show();
            mAuth.signInWithEmailAndPassword(em, psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        mloadingbar.dismiss();
                        Intent i = new Intent(loginactivity.this, Dashboard.class);
                        i.putExtra("email", em);
                        startActivity(i);
                        Toast.makeText(loginactivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        mloadingbar.dismiss();
                        Toast.makeText(loginactivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void forgetpassw(View v){
        fp = (TextView) findViewById(R.id.forgetpassword);
        Intent i = new Intent(loginactivity.this,forgetpassword.class);
        startActivity(i);
        Toast.makeText(loginactivity.this,"Recover Account",Toast.LENGTH_LONG).show();
    }
    public void register(View v){
        register = (TextView) findViewById(R.id.register);
        Intent i = new Intent (loginactivity.this,registration.class);
        startActivity(i);
        Toast.makeText(loginactivity.this,"Register as New",Toast.LENGTH_LONG).show();
    }
}
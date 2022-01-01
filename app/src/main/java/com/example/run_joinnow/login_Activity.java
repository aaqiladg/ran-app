package com.example.run_joinnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_Activity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btnLogin;

    private String emailUser;
    private String passwordUser;
    FirebaseAuth firebaseAuth;

    boolean isValid = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        password = findViewById(R.id.editPassword);
        email = findViewById(R.id.editEmail);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract and validate
                if(email.getText().toString().isEmpty())
                {
                    email.setError("Email Dibutuhkan");
                    return;
                }

                if(password.getText().toString().isEmpty())
                {
                    password.setError("Password Dibutuhkan");
                    return;
                }
                //data validated
                //login
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //login sukses
                        Intent intent = new Intent(login_Activity.this, home.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




    }

    protected void onStart()
    {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            Intent intent = new Intent(login_Activity.this, Profile.class);
            startActivity(intent);
            finish();
        }
    }


}
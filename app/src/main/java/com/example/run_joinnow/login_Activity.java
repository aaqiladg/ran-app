package com.example.run_joinnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_Activity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;
    private Button btnLogin;

    private String emailUser;
    private String passwordUser;

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle extras = getIntent().getExtras();
        btnLogin = (Button) findViewById(R.id.btnLogin);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);

        if(extras != null) {
            emailUser = extras.getString("email");
            passwordUser = extras.getString("password");
            Toast.makeText(this, "Selamat Bergabung!", Toast.LENGTH_SHORT).show();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editEmail.getText().toString();
                String pass = editPassword.getText().toString();
                isValid = validate(email, pass);

                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(login_Activity.this, "Input your email and password correctly ", Toast.LENGTH_SHORT).show();
                }
                else if (isValid){
                    Toast.makeText(login_Activity.this, "Welcome aboard!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(login_Activity.this, "Wrong password!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean validate(String email, String password){
        if(email.equals(emailUser) && password.equals(passwordUser)){
            return true;
        }

        return false;
    }
}
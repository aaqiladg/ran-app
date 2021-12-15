package com.example.run_joinnow;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register_Activity extends AppCompatActivity {

    private EditText registerEmail;
    private Button btnRegister1;
    private EditText registerPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        btnRegister1 = (Button) findViewById(R.id.btnRegister1);

        btnRegister1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String emailUser = registerEmail.getText().toString();
                String passwordUser = registerPassword.getText().toString();

                Intent intent = new Intent(register_Activity.this, login_Activity.class);
                intent.putExtra("email", emailUser);
                intent.putExtra("password", passwordUser);
                startActivity(intent);
            }
        });
    }
}
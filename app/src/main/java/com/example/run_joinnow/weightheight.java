package com.example.run_joinnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class weightheight extends AppCompatActivity {

    EditText editWeight, editHeight;
    Button continueSave;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightheight);

        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        continueSave = findViewById(R.id.continueSave);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        userID = fAuth.getCurrentUser().getUid();

        String height = editHeight.getText().toString();
        String weight = editHeight.getText().toString();

        continueSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child(userID).child("height").setValue(height);
                reference.child(userID).child("weight").setValue(weight);

                Intent intent = new Intent(weightheight.this, home.class);
                startActivity(intent);
            }
        });



    }
}
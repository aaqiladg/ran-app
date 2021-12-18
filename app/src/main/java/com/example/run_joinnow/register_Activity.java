package com.example.run_joinnow;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class register_Activity extends AppCompatActivity {

    private EditText registerEmail,editNamaDepan,editNamaBelakang;
    private Button btnRegister1;
    private EditText registerPassword;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        editNamaDepan = findViewById(R.id.editNamaDepan);
        editNamaBelakang = findViewById(R.id.editNamaBelakang);

        btnRegister1 = (Button) findViewById(R.id.btnRegister1);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        btnRegister1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String emailUser = registerEmail.getText().toString();
                String passwordUser = registerPassword.getText().toString();
                String namaDepan = editNamaDepan.getText().toString();
                String namaBelakang = editNamaBelakang.getText().toString();


                if(namaDepan.isEmpty()){
                    editNamaDepan.setError("Nama Depan Dibutuhkan");
                    return;
                }
                if(namaBelakang.isEmpty()){
                    editNamaDepan.setError("Nama Belakang Dibutuhkan");
                    return;
                }
                if(emailUser.isEmpty()){
                    editNamaDepan.setError("Email Dibutuhkan");
                    return;
                }
                if(passwordUser.isEmpty()){
                    editNamaDepan.setError("Password Dibutuhkan");
                    return;
                }
                //data Validation



                fAuth.createUserWithEmailAndPassword(emailUser, passwordUser).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {




//



                        //oold
//                        userID = fAuth.getCurrentUser().getUid();
//                        DocumentReference documentReference = fStore.collection("users").document(userID);
//                        Map<String,Object> user = new HashMap<>();
//                        user.put("namaDepan", editNamaDepan);
//                        user.put("namaBelakang", editNamaBelakang);
//                        user.put("email", registerEmail);
//                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                Toast.makeText(register_Activity.this, "Berhasil Dibuat", Toast.LENGTH_SHORT).show();
//                            }
//                        });

                        //end of old


                        //move to login


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //get values
                userID = fAuth.getCurrentUser().getUid();
                UserHelper helper = new UserHelper(emailUser, passwordUser, namaDepan, namaBelakang);
                reference.child(userID).setValue(helper);

                Intent intent = new Intent(register_Activity.this, login_Activity.class);
                startActivity(intent);
//
//
//                Intent intent = new Intent(register_Activity.this, login_Activity.class);
//                intent.putExtra("email", emailUser);
//                intent.putExtra("password", passwordUser);
//                startActivity(intent);
            }
        });
    }
}
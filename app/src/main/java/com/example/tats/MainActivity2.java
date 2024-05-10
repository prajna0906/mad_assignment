package com.example.tats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    EditText login,reg,regcheck;
    Button sub,clear;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        login=findViewById(R.id.email);
        reg=findViewById(R.id.password);
        regcheck=findViewById(R.id.passwordrep);
        sub=findViewById(R.id.Sub);
        clear=findViewById(R.id.Clear);
        mAuth=FirebaseAuth.getInstance();
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password,password2;
                email=String.valueOf(login.getText());
                password=String.valueOf(reg.getText());
                password2=String.valueOf(regcheck.getText());
                if(!password.equals(password2)){
                    Toast.makeText(MainActivity2.this,"Password dont match",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity2.this,"Please enter an email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity2.this,"Please enter the password",Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity2.this, "Successfully created an account.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(MainActivity2.this, com.example.tats.MainActivity.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity2.this, "failed to create",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
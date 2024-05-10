package com.example.tats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class profilefragmentactv extends AppCompatActivity {
    Button log,gall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        log=findViewById(R.id.buttonLogout);
        gall=findViewById(R.id.gallary);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profilefragmentactv.this,MainActivity.class);
                startActivity(i);
            }
        });
        gall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profilefragmentactv.this,Infiscroll.class);
                startActivity(i);
            }
        });
    }
}
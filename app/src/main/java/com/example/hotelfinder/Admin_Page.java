package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__page);
    }

    public void addroom(View view){

        Intent intent = new Intent(getApplicationContext(),Adding.class);
        startActivity(intent);
    }
}

package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Adding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void insert(View view) {
        Toast t = Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT);
        t.show();
    }
}

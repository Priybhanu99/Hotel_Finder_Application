package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView t1 = (TextView)findViewById(R.id.heading);
        Bundle b1 = getIntent().getExtras();
        String str = b1.getString("user");
        t1.setText(str);
    }
}

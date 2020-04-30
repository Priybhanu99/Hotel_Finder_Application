package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText e1,e2,e3,e4,e5;
    Button addthis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        EditText t1 = (EditText) findViewById(R.id.heading);
        Bundle b1 = getIntent().getExtras();
        String str = b1.getString("user");
        t1.setText(str);
        e1 = t1;
        e2 =(EditText)findViewById(R.id.beds);
        e3 = (EditText)findViewById(R.id.washrooms);
        e4 = (EditText)findViewById(R.id.wifi);
        addthis = (Button)findViewById(R.id.addthis);
        AddData();
    }

    private void AddData() {
        addthis.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.add_data_for_roomdescription(e1.getText().toString(),
                                Integer.parseInt(e2.getText().toString()),
                                Integer.parseInt(e3.getText().toString()),
                                Integer.parseInt(e4.getText().toString()),
                                e5.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Details.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Details.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

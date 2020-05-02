package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class User_first extends AppCompatActivity {
    DatabaseHelper MyDb = new DatabaseHelper(this);
    EditText e1,e2,e3,e4;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_first);

        e1 = (EditText)findViewById(R.id.user_name);
        e2 = (EditText)findViewById(R.id.arrival);
        e3 = (EditText)findViewById(R.id.depart);
        e4 = (EditText)findViewById(R.id.payment);

        add = (Button)findViewById(R.id.add_user);
//        add_details();
        insert_data();
    }

    public void open_this(View view) {
        Intent intent = new Intent(getApplicationContext(),User_Page.class);
        startActivity(intent);
    }

    public void insert_data()
    {
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    boolean isInserted =  MyDb.insert_user(e1.getText().toString(),
                                e2.getText().toString(),
                                e3.getText().toString(),
                                e4.getText().toString()
                                );
                    if(isInserted==true)
                            Toast.makeText(User_first.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else                             Toast.makeText(User_first.this,"Data not inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


}

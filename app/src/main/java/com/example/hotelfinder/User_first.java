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
    DatabaseHelper Mydb;
    EditText e1,e2,e3;
    Button add;

    RadioButton one,two,x;
    RadioGroup grp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_first);

        e1 = (EditText)findViewById(R.id.user_name);
        e2 = (EditText)findViewById(R.id.arrival);
        e3 = (EditText)findViewById(R.id.depart);
//        one = (RadioButton)findViewById(R.id.cash);
//        two = (RadioButton)findViewById(R.id.paytm);

        add = (Button)findViewById(R.id.add_user);
        grp = (RadioGroup)findViewById(R.id.radioGroup2);
        add_details();
    }

    public void open_this(View view) {
        Intent intent = new Intent(getApplicationContext(),User_Page.class);
        startActivity(intent);
    }

    public void add_details(){

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int selectedId = grp.getCheckedRadioButtonId();
                        x = (RadioButton)grp.findViewById(selectedId);
                        boolean isInserted = Mydb.user_data(e1.getText().toString(),
                                e2.getText().toString(),
                                e3.getText().toString(),
                                x.getText().toString());

                        if(isInserted == true)
                            Toast.makeText(User_first.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(User_first.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }

                }
        );

    }
}

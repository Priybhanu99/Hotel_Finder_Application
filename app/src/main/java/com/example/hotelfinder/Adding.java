package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adding extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName,editType,editLocation,editStatus;
    Button btnAddData;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        myDb = new DatabaseHelper(this);


        editType= (EditText)findViewById(R.id.editText_type);
        editStatus= (EditText)findViewById(R.id.editText_status);
        btnAddData=(Button)findViewById(R.id.button_add);

        AddData();
    }

    private void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editType.getText().toString(),
                                editLocation.getText().toString(),
                                editStatus.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Adding.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Adding.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void hotel_details(View view) {
        Intent intent= new Intent(getApplicationContext(),Details.class);
        intent.putExtra("user",editType.getText().toString());
        startActivity(intent);
    }
}
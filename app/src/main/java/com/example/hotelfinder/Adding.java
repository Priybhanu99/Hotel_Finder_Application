package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adding extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);
    EditText editSize,editType,editPrice,editStatus;
    Button btnAddData;
    Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        myDb = new DatabaseHelper(this);

        editType= (EditText)findViewById(R.id.editText_type);
        editSize= (EditText)findViewById(R.id.editText_size);
        editPrice= (EditText)findViewById(R.id.editText_price);
        editStatus= (EditText)findViewById(R.id.editText_status);
        btnAddData=(Button)findViewById(R.id.button_add);
        btnViewAll=(Button)findViewById(R.id.view_all);

        AddData();
        ViewAll();
    }

    private void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editType.getText().toString(),
                                editSize.getText().toString(),
                                Integer.parseInt(editPrice.getText().toString()),

                                editStatus.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(Adding.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Adding.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void ViewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ROOM_ID: " + res.getString(0) + "\n");
                            buffer.append("Type: " + res.getString(1) + "\n");
                            buffer.append("Size: " + res.getString(2) + "\n");
                            buffer.append("Price: " + res.getString(3) + "\n");
                            buffer.append("Status: " + res.getString(4) + "\n\n");

                        }
                        showMessage("Data", buffer.toString());
                    }
                }

        );

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }





    public void hotel_details(View view) {
        Intent intent= new Intent(getApplicationContext(),Details.class);
        intent.putExtra("user",editType.getText().toString());
        startActivity(intent);
    }
}

package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    DatabaseHelper MYDb;
    EditText e1,e2,e3,e4,e5;
    Button addthis;
    Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        MYDb = new DatabaseHelper(this);

        EditText t1 = (EditText) findViewById(R.id.heading);
        Bundle b1 = getIntent().getExtras();
        String str = b1.getString("user");
        t1.setText(str);
        e1 = t1;
        e2 =(EditText)findViewById(R.id.beds);
        e3 = (EditText)findViewById(R.id.washrooms);
        e4 = (EditText)findViewById(R.id.service);
        e5 = (EditText)findViewById(R.id.wifi);
        addthis = (Button)findViewById(R.id.addthis);

        btnViewAll=(Button)findViewById(R.id.description_view);


        AddData();
        ViewAll();

    }

    private void AddData() {
        addthis.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = MYDb.add_data_for_roomdescription(e1.getText().toString(),
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

    public void ViewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=MYDb.getAllData_description();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }
                        StringBuffer buff=new StringBuffer();
                        while (res.moveToNext()) {
                            buff.append("Room Type: " + res.getString(0) + "\n");
                            buff.append("No of Beds: " + res.getString(1) + "\n");
                            buff.append("No of Washrooms: " + res.getString(2) + "\n");
                            buff.append("Service Charge: " + res.getString(3) + "\n");
                            buff.append("Wifi: " + res.getString(4) + "\n\n");

                        }
                        showMessage("Data", buff.toString());
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
}

package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class User_Page extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);
    EditText e1,e2,e3;
    Button unbooked_bttn;
    Button advanced_search;
    Button book_room;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__page);
        unbooked_bttn = (Button)findViewById(R.id.all_available);
        advanced_search = (Button)findViewById(R.id.advanced);
        book_room = (Button)findViewById(R.id.booking);

        e1 =(EditText)findViewById(R.id.type);
        e2 =(EditText)findViewById(R.id.budget);
        e3 =(EditText)findViewById(R.id.room_id);

        book_a_room();
        find_available();
        advanced_search();
    }

    public void find_available(){
        unbooked_bttn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.print_unbooked();
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

    public void advanced_search(){
        advanced_search.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.print_advanced(e1.getText().toString(),
                                Integer.parseInt(e2.getText().toString()));
                        if (res.getCount() == 0) {
                            showMessage("Error", "No Available Rooms Match your Criteria!");
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

    public void book_a_room()
    {
        book_room.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            int amount = myDb.booking(Integer.parseInt(e3.getText().toString()));
                        showMessage("Congratulations Room booked!\nPlease make a payment of : ",Integer.toString(amount));


                    }
                }
        );
    }


    public void showMessage(String title, String ans){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(ans);
        builder.show();
    }

    public void dothis(View view){

    }
}



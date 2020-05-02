package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin_Page extends AppCompatActivity {

    DatabaseHelper myDb=new DatabaseHelper(this);
    Button revenue_bttn;
    Button booked_bttn;
    Button unbooked_bttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__page);

        revenue_bttn = (Button)findViewById(R.id.revenue);
        booked_bttn = (Button)findViewById(R.id.booked);
        unbooked_bttn = (Button)findViewById(R.id.unbooked);


        find_revenue();
        find_unavailable();
        find_available();


    }

    public void addroom(View view){

        Intent intent = new Intent(getApplicationContext(),Adding.class);
        startActivity(intent);
    }

    public void find_revenue(){
        revenue_bttn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
//                       // Toast.makeText(getApplicationContext(),"hello there",Toast.LENGTH_SHORT);
                        int amount =myDb.print_revenue();

                       showMessage("Total Revenue Generated :",Integer.toString(amount));
//                        Cursor res=myDb.print_revenue();
//                        if (res.getCount() == 0) {
//                            showMessage("Error", "Nothing Found");
//                            return;
//                        }
//                        StringBuffer buffer=new StringBuffer();
//                        while (res.moveToNext()) {
//                            String s = Integer.toString(res.getInt(0));
//                            buffer.append("Revenue Generated: " + s + "\n");
//                        }
//                        showMessage("Data", buffer.toString());
                    }
                }

        );

    }

    public void find_unavailable(){
        booked_bttn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
//                       // Toast.makeText(getApplicationContext(),"hello there",Toast.LENGTH_SHORT);
                        int amount =myDb.print_booked();

                        showMessage("Number of rooms booked: ",Integer.toString(amount));
//                        Cursor res=myDb.print_revenue();
//                        if (res.getCount() == 0) {
//                            showMessage("Error", "Nothing Found");
//                            return;
//                        }
//                        StringBuffer buffer=new StringBuffer();
//                        while (res.moveToNext()) {
//                            String s = Integer.toString(res.getInt(0));
//                            buffer.append("Revenue Generated: " + s + "\n");
//                        }
//                        showMessage("Data", buffer.toString());
                    }
                }

        );

    }

    public void find_available(){
        unbooked_bttn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
//                       // Toast.makeText(getApplicationContext(),"hello there",Toast.LENGTH_SHORT);
                        int amount =myDb.print_unbooked();

                        showMessage("Number of Rooms Available: ",Integer.toString(amount));
//                        Cursor res=myDb.print_revenue();
//                        if (res.getCount() == 0) {
//                            showMessage("Error", "Nothing Found");
//                            return;
//                        }
//                        StringBuffer buffer=new StringBuffer();
//                        while (res.moveToNext()) {
//                            String s = Integer.toString(res.getInt(0));
//                            buffer.append("Revenue Generated: " + s + "\n");
//                        }
//                        showMessage("Data", buffer.toString());
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
}


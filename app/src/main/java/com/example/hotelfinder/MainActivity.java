package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
    }

    public void Onclick(View view) {

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        if(s1.equals("admin") && s2.equals("admin")){
            Intent intent = new Intent(getApplicationContext(),Admin_Page.class);
            startActivity(intent);
        }else if(s1.equals("user") && s2.equals("user")){
            Intent intent = new Intent(getApplicationContext(),User_Page.class);
            startActivity(intent);
        }else{
            Toast t = Toast.makeText(getApplicationContext(),"Bsdk password sahi daal",Toast.LENGTH_SHORT);
            t.show();
        }
    }
}





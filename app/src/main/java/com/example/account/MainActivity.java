package com.example.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText p,n;
    String r,s;
    Db d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p=findViewById(R.id.editTextTextPersonName);
        n=findViewById(R.id.editTextTextPassword);
        d1=new Db(this);
    }

    public void up(View view) {
        Intent in1 = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(in1);
    }

    public void in(View view) {
        r=p.getText().toString();
        s=n.getText().toString();
        ArrayList a = d1.myname(r);
        if(a.get(0).equals("Not exist")){
            Toast.makeText(this, "not exists", Toast.LENGTH_SHORT).show();
        }
        else if(a.get(1).equals(s)){
            Intent in3 = new Intent(MainActivity.this,MainActivity3.class);
            in3.putExtra("abcd",a);
            startActivity(in3);
        } else{
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
        }



    }
}
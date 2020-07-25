package com.example.account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    String s1,s2,s3,s4,s5,s6,s7;
    Db d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1=findViewById(R.id.editTextTextPersonName2);
        ed2=findViewById(R.id.editTextTextPassword2);
        ed3=findViewById(R.id.editTextTextPassword3);
        ed4=findViewById(R.id.editTextPhone);
        ed5=findViewById(R.id.editTextTextPersonName5);
        ed6=findViewById(R.id.editTextTextPersonName6);
        ed7=findViewById(R.id.editTextTextPersonName7);
        d=new Db(this);
    }

    public void sub(View view) {
        s1=ed1.getText().toString();
        s2=ed2.getText().toString();
        s3=ed3.getText().toString();
        s4=ed4.getText().toString();
        s5=ed5.getText().toString();
        s6=ed6.getText().toString();
        s7=ed7.getText().toString();
        if(s2.equals(s3)){
            d.savedata(s1,s2,s3,s4,s5,s6,s7);
            Toast.makeText(this, "Datas Saved!!!!!", Toast.LENGTH_SHORT).show();
            ArrayList b = new ArrayList();
            b=d.myname(s1);
            //new Handler().postDelayed(new Runnable() {
                //@Override
                //public void run() {
                    Intent in2 = new Intent(MainActivity2.this, MainActivity3.class);
                    in2.putExtra("abcd",b);
                    startActivity(in2);

                //}
            //}, 2000);
        }


    }
}
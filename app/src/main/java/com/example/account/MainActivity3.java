package com.example.account;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    TextView t;
    ArrayList<String> a2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t=findViewById(R.id.textView4);
        a2=getIntent().getStringArrayListExtra("abcd");
        t.setText(a2.get(0)+"\n"+a2.get(1)+"\n"+a2.get(2)+"\n"+a2.get(3)+"\n"+a2.get(4)+"\n"+a2.get(5)+"\n"+a2.get(6));
    }
}
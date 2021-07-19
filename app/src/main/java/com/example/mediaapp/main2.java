package com.example.mediaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class main2 extends AppCompatActivity {
    public static final String EXTRA_NAME="com.example.mediaapp.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.activity2);


    }
    public void onClick1(View v){
String s="https://paglasongs.com/files/download/id/2094";
Intent  intent2=new Intent(this,MainActivity.class);
intent2.putExtra(EXTRA_NAME,s);
startActivity(intent2);

    }
    public void onClick2(View v){

        Intent  intent2=new Intent(this,main3.class);
        startActivity(intent2);

    }
public void onclick3(View v) {

    Intent intent2 = new Intent(this, main5.class);
    startActivity(intent2);
}

}

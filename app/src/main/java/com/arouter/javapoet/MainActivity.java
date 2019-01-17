package com.arouter.javapoet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arouter.javapoet.view.TouchView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTouch(View view) {
        Intent intent=new Intent(this,TouchActivity.class);
        startActivity(intent);
    }
}

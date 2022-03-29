package com.wegren.wegrensdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wegren.wegrenmarketingapp.WegrenApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WegrenApp wegrenApp = new WegrenApp();
        wegrenApp.systemInformationSent(this, "1","2");
    }
}
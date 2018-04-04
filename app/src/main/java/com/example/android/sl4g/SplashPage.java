package com.example.android.sl4g;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashPage extends AppCompatActivity {

    //Creates a variable that equals 4 seconds
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent goes from Splash to Main
                Intent splashIntent = new Intent(SplashPage.this, MainActivity.class);
                startActivity(splashIntent);
                finish();
            }
        }, SPLASH_TIME_OUT); //Pass in how long it goes for

    }
}

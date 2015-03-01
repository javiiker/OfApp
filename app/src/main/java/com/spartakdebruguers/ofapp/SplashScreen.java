package com.spartakdebruguers.ofapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.spartakdebruguers.ofapp.database.DBHelper;
import com.spartakdebruguers.ofapp.model.News;

import java.util.List;

/**
 * Activity in charge of show the splash screen while system is synchronizing the data
 *
 * @author javier_santiago
 * @version 21.02.2015
 */

public class SplashScreen extends Activity {
    // Database Helper
    DBHelper db;

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        db = new DBHelper(getApplicationContext());

        // Create one testing new
        News newObject = new News(1,"url","title","header","created","2015-01-01","content");
        db.createNews(newObject);
        db.closeDB();



        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);

        // close this activity
        finish();


        // Create the database if not exists

        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
        */
    }
}

package com.example.jacob.utpbar;

/**
 * Created by jacob on 9/6/2015.
 */

/** Simple splash screen that displays the UTPB and AR logo
 */

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash extends Activity {

    //splash screen duration (in ms)
    private final int SPLASH_LENGTH = 1000;

    //for logging
    private static final String TAG = "Jacob logging";

    @Override
    public void onCreate(Bundle b) {

        super.onCreate(b);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //create intent that will start MainActivity
                Log.i(TAG, "1");
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Log.i(TAG, "2");
                Splash.this.startActivity(mainIntent);
                Log.i(TAG, "3");
                Splash.this.finish();
                Log.i(TAG, "4");
            }
        }, SPLASH_LENGTH);

    }
}

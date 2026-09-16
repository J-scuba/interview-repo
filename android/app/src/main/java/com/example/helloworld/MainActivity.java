package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppLogger logger = AppLogger.fromConfig();
        logger.d(TAG, "onCreate, API key configured: " + !AppConfig.apiKey().isEmpty());

        TextView greeting = new TextView(this);
        greeting.setText("Hello, world!");
        greeting.setTextColor(Color.rgb(27, 94, 32));
        greeting.setTextSize(28);
        greeting.setGravity(Gravity.CENTER);
        setContentView(greeting);
    }
}
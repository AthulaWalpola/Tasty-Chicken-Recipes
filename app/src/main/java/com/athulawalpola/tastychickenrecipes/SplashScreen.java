package com.athulawalpola.tastychickenrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    TextView textView_1, textView_2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splash_logo);
        textView_1 = findViewById(R.id.text_line_1);
        textView_2 = findViewById(R.id.text_line_2);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        imageView.startAnimation(animation);
        textView_1.startAnimation(animation);
        textView_2.startAnimation(animation);
        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}

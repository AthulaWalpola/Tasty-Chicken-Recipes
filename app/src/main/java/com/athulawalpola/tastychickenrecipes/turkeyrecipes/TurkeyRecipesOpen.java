package com.athulawalpola.tastychickenrecipes.turkeyrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class TurkeyRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turkey_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.turkeyrecipesopen_title_10);
        textView_2 = findViewById(R.id.turkeyrecipesopen_time_10);
        textView_3 = findViewById(R.id.turkeyrecipesopen_serving_10);
        textView_4 = findViewById(R.id.turkeyrecipesopen_ingredients_10);
        textView_5 = findViewById(R.id.turkeyrecipesopen_instructions_10);
        imageView = findViewById(R.id.turkeyrecipesopen_imageView_10);

        //Get data from intent
        String title = getIntent().getStringExtra("title_10");
        String time = getIntent().getStringExtra("time_10");
        String serving = getIntent().getStringExtra("serving_10");
        String ingredients = getIntent().getStringExtra("ingredients_10");
        String instructions = getIntent().getStringExtra("instructions_10");
        byte[] bytes = getIntent().getByteArrayExtra("image_10");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        //Set data to views
        textView_1.setText(title);
        textView_2.setText(time);
        textView_3.setText(serving);
        textView_4.setText(ingredients);
        textView_5.setText(instructions);
        imageView.setImageBitmap(bmp);
    }
}

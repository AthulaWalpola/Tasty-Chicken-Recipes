package com.athulawalpola.tastychickenrecipes.chickenbreasts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenBreastsRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_breasts_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickenbreastsrecipesopen_title_3);
        textView_2 = findViewById(R.id.chickenbreastsrecipesopen_time_3);
        textView_3 = findViewById(R.id.chickenbreastsrecipesopen_serving_3);
        textView_4 = findViewById(R.id.chickenbreastsrecipesopen_ingredients_3);
        textView_5 = findViewById(R.id.chickenbreastsrecipesopen_instructions_3);
        imageView = findViewById(R.id.chickenbreastsrecipesopen_imageView_3);

        //Get data from intent
        String title = getIntent().getStringExtra("title_3");
        String time = getIntent().getStringExtra("time_3");
        String serving = getIntent().getStringExtra("serving_3");
        String ingredients = getIntent().getStringExtra("ingredients_3");
        String instructions = getIntent().getStringExtra("instructions_3");
        byte[] bytes = getIntent().getByteArrayExtra("image_3");
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

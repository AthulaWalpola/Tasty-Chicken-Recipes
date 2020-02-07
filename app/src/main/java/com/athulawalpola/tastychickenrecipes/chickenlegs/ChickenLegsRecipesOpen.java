package com.athulawalpola.tastychickenrecipes.chickenlegs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenLegsRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_legs_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickenlegsrecipesopen_title_4);
        textView_2 = findViewById(R.id.chickenlegsrecipesopen_time_4);
        textView_3 = findViewById(R.id.chickenlegsrecipesopen_serving_4);
        textView_4 = findViewById(R.id.chickenlegsrecipesopen_ingredients_4);
        textView_5 = findViewById(R.id.chickenlegsrecipesopen_instructions_4);
        imageView = findViewById(R.id.chickenlegsrecipesopen_imageView_4);

        //Get data from intent
        String title = getIntent().getStringExtra("title_4");
        String time = getIntent().getStringExtra("time_4");
        String serving = getIntent().getStringExtra("serving_4");
        String ingredients = getIntent().getStringExtra("ingredients_4");
        String instructions = getIntent().getStringExtra("instructions_4");
        byte[] bytes = getIntent().getByteArrayExtra("image_4");
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

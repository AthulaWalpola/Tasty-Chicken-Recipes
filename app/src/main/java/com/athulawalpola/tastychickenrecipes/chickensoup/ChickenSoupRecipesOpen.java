package com.athulawalpola.tastychickenrecipes.chickensoup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenSoupRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_soup_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickensouprecipesopen_title_6);
        textView_2 = findViewById(R.id.chickensouprecipesopen_time_6);
        textView_3 = findViewById(R.id.chickensouprecipesopen_serving_6);
        textView_4 = findViewById(R.id.chickensouprecipesopen_ingredients_6);
        textView_5 = findViewById(R.id.chickensouprecipesopen_instructions_6);
        imageView = findViewById(R.id.chickensouprecipesopen_imageView_6);

        //Get data from intent
        String title = getIntent().getStringExtra("title_6");
        String time = getIntent().getStringExtra("time_6");
        String serving = getIntent().getStringExtra("serving_6");
        String ingredients = getIntent().getStringExtra("ingredients_6");
        String instructions = getIntent().getStringExtra("instructions_6");
        byte[] bytes = getIntent().getByteArrayExtra("image_6");
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

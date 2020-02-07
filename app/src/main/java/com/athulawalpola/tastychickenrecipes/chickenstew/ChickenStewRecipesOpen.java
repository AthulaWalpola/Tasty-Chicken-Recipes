package com.athulawalpola.tastychickenrecipes.chickenstew;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenStewRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_stew_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickenstewrecipesopen_title_7);
        textView_2 = findViewById(R.id.chickenstewrecipesopen_time_7);
        textView_3 = findViewById(R.id.chickenstewrecipesopen_serving_7);
        textView_4 = findViewById(R.id.chickenstewrecipesopen_ingredients_7);
        textView_5 = findViewById(R.id.chickenstewrecipesopen_instructions_7);
        imageView = findViewById(R.id.chickenstewrecipesopen_imageView_7);

        //Get data from intent
        String title = getIntent().getStringExtra("title_7");
        String time = getIntent().getStringExtra("time_7");
        String serving = getIntent().getStringExtra("serving_7");
        String ingredients = getIntent().getStringExtra("ingredients_7");
        String instructions = getIntent().getStringExtra("instructions_7");
        byte[] bytes = getIntent().getByteArrayExtra("image_7");
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

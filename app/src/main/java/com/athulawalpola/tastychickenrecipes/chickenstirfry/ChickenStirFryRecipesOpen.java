package com.athulawalpola.tastychickenrecipes.chickenstirfry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenStirFryRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_stir_fry_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickenstirfryrecipesopen_title_8);
        textView_2 = findViewById(R.id.chickenstirfryrecipesopen_time_8);
        textView_3 = findViewById(R.id.chickenstirfryrecipesopen_serving_8);
        textView_4 = findViewById(R.id.chickenstirfryrecipesopen_ingredients_8);
        textView_5 = findViewById(R.id.chickenstirfryrecipesopen_instructions_8);
        imageView = findViewById(R.id.chickenstirfryrecipesopen_imageView_8);

        //Get data from intent
        String title = getIntent().getStringExtra("title_8");
        String time = getIntent().getStringExtra("time_8");
        String serving = getIntent().getStringExtra("serving_8");
        String ingredients = getIntent().getStringExtra("ingredients_8");
        String instructions = getIntent().getStringExtra("instructions_8");
        byte[] bytes = getIntent().getByteArrayExtra("image_8");
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

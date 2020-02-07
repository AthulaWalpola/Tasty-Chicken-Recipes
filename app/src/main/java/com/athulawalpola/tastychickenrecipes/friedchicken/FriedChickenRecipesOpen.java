package com.athulawalpola.tastychickenrecipes.friedchicken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class FriedChickenRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fried_chicken_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.friedchickenrecipesopen_title_9);
        textView_2 = findViewById(R.id.friedchickenrecipesopen_time_9);
        textView_3 = findViewById(R.id.friedchickenrecipesopen_serving_9);
        textView_4 = findViewById(R.id.friedchickenrecipesopen_ingredients_9);
        textView_5 = findViewById(R.id.friedchickenrecipesopen_instructions_9);
        imageView = findViewById(R.id.friedchickenrecipesopen_imageView_9);

        //Get data from intent
        String title = getIntent().getStringExtra("title_9");
        String time = getIntent().getStringExtra("time_9");
        String serving = getIntent().getStringExtra("serving_9");
        String ingredients = getIntent().getStringExtra("ingredients_9");
        String instructions = getIntent().getStringExtra("instructions_9");
        byte[] bytes = getIntent().getByteArrayExtra("image_9");
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

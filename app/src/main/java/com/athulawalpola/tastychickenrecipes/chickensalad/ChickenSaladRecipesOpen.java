package com.athulawalpola.tastychickenrecipes.chickensalad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class ChickenSaladRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_salad_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.chickensaladrecipesopen_title_5);
        textView_2 = findViewById(R.id.chickensaladrecipesopen_time_5);
        textView_3 = findViewById(R.id.chickensaladrecipesopen_serving_5);
        textView_4 = findViewById(R.id.chickensaladrecipesopen_ingredients_5);
        textView_5 = findViewById(R.id.chickensaladrecipesopen_instructions_5);
        imageView = findViewById(R.id.chickensaladrecipesopen_imageView_5);

        //Get data from intent
        String title = getIntent().getStringExtra("title_5");
        String time = getIntent().getStringExtra("time_5");
        String serving = getIntent().getStringExtra("serving_5");
        String ingredients = getIntent().getStringExtra("ingredients_5");
        String instructions = getIntent().getStringExtra("instructions_5");
        byte[] bytes = getIntent().getByteArrayExtra("image_5");
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

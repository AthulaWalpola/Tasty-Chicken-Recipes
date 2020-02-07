package com.athulawalpola.tastychickenrecipes.wholechicken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class WholeChickenRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_chicken_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.wholechickenrecipesopen_title_11);
        textView_2 = findViewById(R.id.wholechickenrecipesopen_time_11);
        textView_3 = findViewById(R.id.wholechickenrecipesopen_serving_11);
        textView_4 = findViewById(R.id.wholechickenrecipesopen_ingredients_11);
        textView_5 = findViewById(R.id.wholechickenrecipesopen_instructions_11);
        imageView = findViewById(R.id.wholechickenrecipesopen_imageView_11);

        //Get data from intent
        String title = getIntent().getStringExtra("title_11");
        String time = getIntent().getStringExtra("time_11");
        String serving = getIntent().getStringExtra("serving_11");
        String ingredients = getIntent().getStringExtra("ingredients_11");
        String instructions = getIntent().getStringExtra("instructions_11");
        byte[] bytes = getIntent().getByteArrayExtra("image_11");
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

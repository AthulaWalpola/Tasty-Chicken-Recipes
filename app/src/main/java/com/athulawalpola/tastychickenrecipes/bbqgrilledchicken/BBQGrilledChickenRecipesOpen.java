package com.athulawalpola.tastychickenrecipes.bbqgrilledchicken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;

public class BBQGrilledChickenRecipesOpen extends AppCompatActivity {

    TextView textView_1, textView_2, textView_3, textView_4, textView_5;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbq_grilled_chicken_recipes_open);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Initialize views
        textView_1 = findViewById(R.id.bbqgrilledchickenrecipesopen_title_2);
        textView_2 = findViewById(R.id.bbqgrilledchickenrecipesopen_time_2);
        textView_3 = findViewById(R.id.bbqgrilledchickenrecipesopen_serving_2);
        textView_4 = findViewById(R.id.bbqgrilledchickenrecipesopen_ingredients_2);
        textView_5 = findViewById(R.id.bbqgrilledchickenrecipesopen_instructions_2);
        imageView = findViewById(R.id.bbqgrilledchickenrecipesopen_imageView_2);

        //Get data from intent
        String title = getIntent().getStringExtra("title_2");
        String time = getIntent().getStringExtra("time_2");
        String serving = getIntent().getStringExtra("serving_2");
        String ingredients = getIntent().getStringExtra("ingredients_2");
        String instructions = getIntent().getStringExtra("instructions_2");
        byte[] bytes = getIntent().getByteArrayExtra("image_2");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        //Set data to view
        textView_1.setText(title);
        textView_2.setText(time);
        textView_3.setText(serving);
        textView_4.setText(ingredients);
        textView_5.setText(instructions);
        imageView.setImageBitmap(bmp);
    }
}

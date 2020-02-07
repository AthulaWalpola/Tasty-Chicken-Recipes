package com.athulawalpola.tastychickenrecipes.bakedroastedchicken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;
import com.like.LikeButton;

public class BakedRoastedChickenRecipesOpen extends AppCompatActivity {

    ImageView imageView;
    TextView textView_1, textView_2, textView_3, textView_4, textView_5;
    LikeButton likeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baked_roasted_chicken_recipes_open);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        textView_1 = findViewById(R.id.bakedroastedchickenrecipesopen_title_1);
        textView_2 = findViewById(R.id.bakedroastedchickenrecipesopen_time_1);
        textView_3 = findViewById(R.id.bakedroastedchickenrecipesopen_serving_1);
        textView_4 = findViewById(R.id.bakedroastedchickenrecipesopen_ingredients_1);
        textView_5 = findViewById(R.id.bakedroastedchickenrecipesopen_instructions_1);
        likeButton = findViewById(R.id.bakedroastedchickenrecipesopen_like_1);
        imageView = findViewById(R.id.bakedroastedchickenrecipesopen_imageView_1);

        //Get data from intent
        String title = getIntent().getStringExtra("title_1");
        String time = getIntent().getStringExtra("time_1");
        String serving = getIntent().getStringExtra("serving_1");
        String ingredients = getIntent().getStringExtra("ingredients_1");
        String instructions = getIntent().getStringExtra("instructions_1");
        byte[] bytes = getIntent().getByteArrayExtra("image_1");
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

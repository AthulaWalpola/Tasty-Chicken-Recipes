package com.athulawalpola.tastychickenrecipes;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.bakedroastedchicken.BakedRoastedChicken;
import com.athulawalpola.tastychickenrecipes.bbqgrilledchicken.BBQGrilledChicken;
import com.athulawalpola.tastychickenrecipes.chickenbreasts.ChickenBreasts;
import com.athulawalpola.tastychickenrecipes.chickenlegs.ChickenLegs;
import com.athulawalpola.tastychickenrecipes.chickensalad.ChickenSalad;
import com.athulawalpola.tastychickenrecipes.chickensoup.ChickenSoup;
import com.athulawalpola.tastychickenrecipes.chickenstew.ChickenStew;
import com.athulawalpola.tastychickenrecipes.chickenstirfry.ChickenStirFry;
import com.athulawalpola.tastychickenrecipes.friedchicken.FriedChicken;
import com.athulawalpola.tastychickenrecipes.turkeyrecipes.TurkeyRecipes;
import com.athulawalpola.tastychickenrecipes.wholechicken.WholeChicken;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    public static final String ITEM_ID = "com.athulawalpola.tastychickenrecipes.ITEM_ID";

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }

    //Set details to recyclerView row
    public void setDetails(final Context context, final String title, String image, final String categoryName) {
        TextView textView = mView.findViewById(R.id.title);
        ImageView imageView = mView.findViewById(R.id.imageView);

        textView.setText(title);
        Picasso.get().load(image).fit().into(imageView);

        mView.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View view) {
                switch (categoryName) {
                    case "baked_roasted_chicken_recipes":
                        intent = new Intent(context, BakedRoastedChicken.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "bbq_grilled_chicken_recipes":
                        intent = new Intent(context, BBQGrilledChicken.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_breasts_recipes":
                        intent = new Intent(context, ChickenBreasts.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_legs_recipes":
                        intent = new Intent(context, ChickenLegs.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_salad_recipes":
                        intent = new Intent(context, ChickenSalad.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_soup_recipes":
                        intent = new Intent(context, ChickenSoup.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_stew_recipes":
                        intent = new Intent(context, ChickenStew.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "chicken_stirfry_recipes":
                        intent = new Intent(context, ChickenStirFry.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "fried_chicken_recipes":
                        intent = new Intent(context, FriedChicken.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "turkey_recipes":
                        intent = new Intent(context, TurkeyRecipes.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;

                    case "whole_chicken_recipes":
                        intent = new Intent(context, WholeChicken.class);
                        intent.putExtra(ITEM_ID, categoryName);
                        break;
                }
                context.startActivity(intent);
            }
        });
    }
}

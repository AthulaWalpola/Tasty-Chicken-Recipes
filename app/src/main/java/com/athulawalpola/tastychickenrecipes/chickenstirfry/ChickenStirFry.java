package com.athulawalpola.tastychickenrecipes.chickenstirfry;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.athulawalpola.tastychickenrecipes.R;
import com.athulawalpola.tastychickenrecipes.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;

public class ChickenStirFry extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_stir_fry);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_8);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Chicken Stir-Fry Recipes");
        //Set back button in actionbar
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //Go to previous activity

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //Load data into recyclerView onStart

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ChickenStirFryModel, ChickenStirFryViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ChickenStirFryModel, ChickenStirFryViewHolder>(
                        ChickenStirFryModel.class,
                        R.layout.chicken_stir_fry_items,
                        ChickenStirFryViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(ChickenStirFryViewHolder chickenStirFryViewHolder, ChickenStirFryModel chickenStirFryModel, int i) {
                chickenStirFryViewHolder.setDetails(getApplicationContext(), chickenStirFryModel.getTitle_8(), chickenStirFryModel.getImage_8(),
                        chickenStirFryModel.getTime_8(), chickenStirFryModel.getServing_8(), chickenStirFryModel.getIngredients_8(), chickenStirFryModel.getInstructions_8());
            }

            //Added from here
            @Override
            public ChickenStirFryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                ChickenStirFryViewHolder chickenStirFryViewHolder = super.onCreateViewHolder(parent, viewType);
                chickenStirFryViewHolder.setOnClickListener(new ChickenStirFryViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_8);
                        TextView tTextView = view.findViewById(R.id.time_8);
                        TextView sTextView = view.findViewById(R.id.serving_8);
                        TextView ingTextView = view.findViewById(R.id.ingredients_8);
                        TextView insTextView = view.findViewById(R.id.instructions_8);
                        ImageView mImageView = view.findViewById(R.id.imageView_8);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), ChickenStirFryRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_8", bytes);
                        intent.putExtra("title_8", mTitle);
                        intent.putExtra("time_8", mTime);
                        intent.putExtra("serving_8", mServing);
                        intent.putExtra("ingredients_8", mIngredients);
                        intent.putExtra("instructions_8", mInstructions);
                        startActivity(intent);
                    }
                });

                return chickenStirFryViewHolder;
            }
            //To here
        };

        //Set adapter to the recyclerView
        rRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    //Search Data
    private void firebaseSearch(String searchText) {

        //Convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mReference.orderByChild("search_8").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<ChickenStirFryModel, ChickenStirFryViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ChickenStirFryModel, ChickenStirFryViewHolder>(
                        ChickenStirFryModel.class,
                        R.layout.chicken_stir_fry_items,
                        ChickenStirFryViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ChickenStirFryViewHolder chickenStirFryViewHolder, ChickenStirFryModel chickenStirFryModel, int i) {
                        chickenStirFryViewHolder.setDetails(getApplicationContext(), chickenStirFryModel.getTitle_8(), chickenStirFryModel.getImage_8(),
                                chickenStirFryModel.getTime_8(), chickenStirFryModel.getServing_8(), chickenStirFryModel.getIngredients_8(), chickenStirFryModel.getInstructions_8());
                    }

                    //Added from here
                    @Override
                    public ChickenStirFryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ChickenStirFryViewHolder chickenStirFryViewHolder = super.onCreateViewHolder(parent, viewType);
                        chickenStirFryViewHolder.setOnClickListener(new ChickenStirFryViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_8);
                                TextView tTextView = view.findViewById(R.id.time_8);
                                TextView sTextView = view.findViewById(R.id.serving_8);
                                TextView ingTextView = view.findViewById(R.id.ingredients_8);
                                TextView insTextView = view.findViewById(R.id.instructions_8);
                                ImageView mImageView = view.findViewById(R.id.imageView_8);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), ChickenStirFryRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_8", bytes);
                                intent.putExtra("title_8", mTitle);
                                intent.putExtra("time_8", mTime);
                                intent.putExtra("serving_8", mServing);
                                intent.putExtra("ingredients_8", mIngredients);
                                intent.putExtra("instructions_8", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return chickenStirFryViewHolder;
                    }
                    //To here
                };

        //Set adapter to recycleView
        rRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this add item to actionbar if it present
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.item_action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Filter by type
                firebaseSearch(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}

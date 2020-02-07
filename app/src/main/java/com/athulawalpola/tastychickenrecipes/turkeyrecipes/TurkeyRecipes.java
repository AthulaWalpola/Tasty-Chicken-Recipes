package com.athulawalpola.tastychickenrecipes.turkeyrecipes;

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

public class TurkeyRecipes extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turkey_recipes);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_10);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Turkey Recipes");
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
        FirebaseRecyclerAdapter<TurkeyRecipesModel, TurkeyRecipesViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<TurkeyRecipesModel, TurkeyRecipesViewHolder>(
                        TurkeyRecipesModel.class,
                        R.layout.turkey_recipes_items,
                        TurkeyRecipesViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(TurkeyRecipesViewHolder turkeyRecipesViewHolder, TurkeyRecipesModel turkeyRecipesModel, int i) {
                turkeyRecipesViewHolder.setDetails(getApplicationContext(), turkeyRecipesModel.getTitle_10(), turkeyRecipesModel.getImage_10(),
                        turkeyRecipesModel.getTime_10(), turkeyRecipesModel.getServing_10(), turkeyRecipesModel.getIngredients_10(), turkeyRecipesModel.getInstructions_10());
            }

            //Added from here
            @Override
            public TurkeyRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                TurkeyRecipesViewHolder turkeyRecipesViewHolder = super.onCreateViewHolder(parent, viewType);
                turkeyRecipesViewHolder.setOnClickListener(new TurkeyRecipesViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_10);
                        TextView tTextView = view.findViewById(R.id.time_10);
                        TextView sTextView = view.findViewById(R.id.serving_10);
                        TextView ingTextView = view.findViewById(R.id.ingredients_10);
                        TextView insTextView = view.findViewById(R.id.instructions_10);
                        ImageView mImageView = view.findViewById(R.id.imageView_10);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), TurkeyRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_10", bytes);
                        intent.putExtra("title_10", mTitle);
                        intent.putExtra("time_10", mTime);
                        intent.putExtra("serving_10", mServing);
                        intent.putExtra("ingredients_10", mIngredients);
                        intent.putExtra("instructions_10", mInstructions);
                        startActivity(intent);
                    }
                });

                return turkeyRecipesViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_10").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<TurkeyRecipesModel, TurkeyRecipesViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<TurkeyRecipesModel, TurkeyRecipesViewHolder>(
                        TurkeyRecipesModel.class,
                        R.layout.turkey_recipes_items,
                        TurkeyRecipesViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(TurkeyRecipesViewHolder turkeyRecipesViewHolder, TurkeyRecipesModel turkeyRecipesModel, int i) {
                        turkeyRecipesViewHolder.setDetails(getApplicationContext(), turkeyRecipesModel.getTitle_10(), turkeyRecipesModel.getImage_10(),
                                turkeyRecipesModel.getTime_10(), turkeyRecipesModel.getServing_10(), turkeyRecipesModel.getIngredients_10(), turkeyRecipesModel.getInstructions_10());
                    }

                    //Added from here
                    @Override
                    public TurkeyRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        TurkeyRecipesViewHolder turkeyRecipesViewHolder = super.onCreateViewHolder(parent, viewType);
                        turkeyRecipesViewHolder.setOnClickListener(new TurkeyRecipesViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_10);
                                TextView tTextView = view.findViewById(R.id.time_10);
                                TextView sTextView = view.findViewById(R.id.serving_10);
                                TextView ingTextView = view.findViewById(R.id.ingredients_10);
                                TextView insTextView = view.findViewById(R.id.instructions_10);
                                ImageView mImageView = view.findViewById(R.id.imageView_10);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), TurkeyRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_10", bytes);
                                intent.putExtra("title_10", mTitle);
                                intent.putExtra("time_10", mTime);
                                intent.putExtra("serving_10", mServing);
                                intent.putExtra("ingredients_10", mIngredients);
                                intent.putExtra("instructions_10", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return turkeyRecipesViewHolder;
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

package com.athulawalpola.tastychickenrecipes.chickensalad;

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
import com.athulawalpola.tastychickenrecipes.chickenlegs.ChickenLegsViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;

public class ChickenSalad extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_salad);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_5);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Chicken Salad Recipes");
        //Set back button in actionbar
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    //Go to previous action
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //Load data into recyclerView onStart
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ChickenSaladModel, ChickenSaladViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ChickenSaladModel, ChickenSaladViewHolder>(
                        ChickenSaladModel.class,
                        R.layout.chicken_salad_items,
                        ChickenSaladViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(ChickenSaladViewHolder chickenSaladViewHolder, ChickenSaladModel chickenSaladModel, int i) {
                chickenSaladViewHolder.setDetails(getApplicationContext(), chickenSaladModel.getTitle_5(), chickenSaladModel.getImage_5(),
                        chickenSaladModel.getTime_5(), chickenSaladModel.getServing_5(), chickenSaladModel.getIngredients_5(), chickenSaladModel.getInstructions_5());
            }

            //Added from here
            @Override
            public ChickenSaladViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                ChickenSaladViewHolder chickenSaladViewHolder = super.onCreateViewHolder(parent, viewType);
                chickenSaladViewHolder.setOnClickListener(new ChickenSaladViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_5);
                        TextView tTextView = view.findViewById(R.id.time_5);
                        TextView sTextView = view.findViewById(R.id.serving_5);
                        TextView ingTextView = view.findViewById(R.id.ingredients_5);
                        TextView insTextView = view.findViewById(R.id.instructions_5);
                        ImageView mImageView = view.findViewById(R.id.imageView_5);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), ChickenSaladRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_5", bytes);
                        intent.putExtra("title_5", mTitle);
                        intent.putExtra("time_5", mTime);
                        intent.putExtra("serving_5", mServing);
                        intent.putExtra("ingredients_5", mIngredients);
                        intent.putExtra("instructions_5", mInstructions);
                        startActivity(intent);
                    }
                });

                return chickenSaladViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_5").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<ChickenSaladModel, ChickenSaladViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ChickenSaladModel, ChickenSaladViewHolder>(
                        ChickenSaladModel.class,
                        R.layout.chicken_salad_items,
                        ChickenSaladViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ChickenSaladViewHolder chickenSaladViewHolder, ChickenSaladModel chickenSaladModel, int i) {
                        chickenSaladViewHolder.setDetails(getApplicationContext(), chickenSaladModel.getTitle_5(), chickenSaladModel.getImage_5(),
                                chickenSaladModel.getTime_5(), chickenSaladModel.getServing_5(), chickenSaladModel.getIngredients_5(), chickenSaladModel.getInstructions_5());
                    }

                    //Added from here
                    @Override
                    public ChickenSaladViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ChickenSaladViewHolder chickenSaladViewHolder = super.onCreateViewHolder(parent, viewType);
                        chickenSaladViewHolder.setOnClickListener(new ChickenSaladViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_5);
                                TextView tTextView = view.findViewById(R.id.time_5);
                                TextView sTextView = view.findViewById(R.id.serving_5);
                                TextView ingTextView = view.findViewById(R.id.ingredients_5);
                                TextView insTextView = view.findViewById(R.id.instructions_5);
                                ImageView mImageView = view.findViewById(R.id.imageView_5);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), ChickenSaladRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_5", bytes);
                                intent.putExtra("title_5", mTitle);
                                intent.putExtra("time_5", mTime);
                                intent.putExtra("serving_5", mServing);
                                intent.putExtra("ingredients_5", mIngredients);
                                intent.putExtra("instructions_5", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return chickenSaladViewHolder;
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

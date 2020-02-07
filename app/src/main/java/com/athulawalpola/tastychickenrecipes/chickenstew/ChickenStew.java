package com.athulawalpola.tastychickenrecipes.chickenstew;

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

public class ChickenStew extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_stew);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_7);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Chicken Stew Recipes");
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
        FirebaseRecyclerAdapter<ChickenStewModel, ChickenStewViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ChickenStewModel, ChickenStewViewHolder>(
                        ChickenStewModel.class,
                        R.layout.chicken_stew_items,
                        ChickenStewViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(ChickenStewViewHolder chickenStewViewHolder, ChickenStewModel chickenStewModel, int i) {
                chickenStewViewHolder.setDetails(getApplicationContext(), chickenStewModel.getTitle_7(), chickenStewModel.getImage_7(),
                        chickenStewModel.getTime_7(), chickenStewModel.getServing_7(), chickenStewModel.getIngredients_7(), chickenStewModel.getInstructions_7());
            }

            //Added from here
            @Override
            public ChickenStewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                ChickenStewViewHolder chickenStewViewHolder = super.onCreateViewHolder(parent, viewType);
                chickenStewViewHolder.setOnClickListener(new ChickenStewViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_7);
                        TextView tTextView = view.findViewById(R.id.time_7);
                        TextView sTextView = view.findViewById(R.id.serving_7);
                        TextView ingTextView = view.findViewById(R.id.ingredients_7);
                        TextView insTextView = view.findViewById(R.id.instructions_7);
                        ImageView mImageView = view.findViewById(R.id.imageView_7);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), ChickenStewRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_7", bytes);
                        intent.putExtra("title_7", mTitle);
                        intent.putExtra("time_7", mTime);
                        intent.putExtra("serving_7", mServing);
                        intent.putExtra("ingredients_7", mIngredients);
                        intent.putExtra("instructions_7", mInstructions);
                        startActivity(intent);
                    }
                });

                return chickenStewViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_7").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<ChickenStewModel, ChickenStewViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ChickenStewModel, ChickenStewViewHolder>(
                        ChickenStewModel.class,
                        R.layout.chicken_stew_items,
                        ChickenStewViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ChickenStewViewHolder chickenStewViewHolder, ChickenStewModel chickenStewModel, int i) {
                        chickenStewViewHolder.setDetails(getApplicationContext(), chickenStewModel.getTitle_7(), chickenStewModel.getImage_7(),
                                chickenStewModel.getTime_7(), chickenStewModel.getServing_7(), chickenStewModel.getIngredients_7(), chickenStewModel.getInstructions_7());
                    }

                    //Added from here
                    @Override
                    public ChickenStewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ChickenStewViewHolder chickenStewViewHolder = super.onCreateViewHolder(parent, viewType);
                        chickenStewViewHolder.setOnClickListener(new ChickenStewViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_7);
                                TextView tTextView = view.findViewById(R.id.time_7);
                                TextView sTextView = view.findViewById(R.id.serving_7);
                                TextView ingTextView = view.findViewById(R.id.ingredients_7);
                                TextView insTextView = view.findViewById(R.id.instructions_7);
                                ImageView mImageView = view.findViewById(R.id.imageView_7);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), ChickenStewRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_7", bytes);
                                intent.putExtra("title_7", mTitle);
                                intent.putExtra("time_7", mTime);
                                intent.putExtra("serving_7", mServing);
                                intent.putExtra("ingredients_7", mIngredients);
                                intent.putExtra("instructions_7", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return chickenStewViewHolder;
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

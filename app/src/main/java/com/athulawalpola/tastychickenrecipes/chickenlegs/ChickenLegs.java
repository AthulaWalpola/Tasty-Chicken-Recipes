package com.athulawalpola.tastychickenrecipes.chickenlegs;

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

public class ChickenLegs extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chicken_legs);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_4);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Chicken Leg Recipes");
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
        FirebaseRecyclerAdapter<ChickenLegsModel, ChickenLegsViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ChickenLegsModel, ChickenLegsViewHolder>(
                        ChickenLegsModel.class,
                        R.layout.chicken_legs_items,
                        ChickenLegsViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(ChickenLegsViewHolder chickenLegsViewHolder, ChickenLegsModel chickenLegsModel, int i) {
                chickenLegsViewHolder.setDetails(getApplicationContext(), chickenLegsModel.getTitle_4(), chickenLegsModel.getImage_4(),
                        chickenLegsModel.getTime_4(), chickenLegsModel.getServing_4(), chickenLegsModel.getIngredients_4(), chickenLegsModel.getInstructions_4());
            }

            //Added from here
            @Override
            public ChickenLegsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                ChickenLegsViewHolder chickenLegsViewHolder = super.onCreateViewHolder(parent, viewType);
                chickenLegsViewHolder.setOnClickListener(new ChickenLegsViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_4);
                        TextView tTextView = view.findViewById(R.id.time_4);
                        TextView sTextView = view.findViewById(R.id.serving_4);
                        TextView ingTextView = view.findViewById(R.id.ingredients_4);
                        TextView insTextView = view.findViewById(R.id.instructions_4);
                        ImageView mImageView = view.findViewById(R.id.imageView_4);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), ChickenLegsRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_4", bytes);
                        intent.putExtra("title_4", mTitle);
                        intent.putExtra("time_4", mTime);
                        intent.putExtra("serving_4", mServing);
                        intent.putExtra("ingredients_4", mIngredients);
                        intent.putExtra("instructions_4", mInstructions);
                        startActivity(intent);
                    }
                });

                return chickenLegsViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_4").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<ChickenLegsModel, ChickenLegsViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ChickenLegsModel, ChickenLegsViewHolder>(
                        ChickenLegsModel.class,
                        R.layout.chicken_legs_items,
                        ChickenLegsViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ChickenLegsViewHolder chickenLegsViewHolder, ChickenLegsModel chickenLegsModel, int i) {
                        chickenLegsViewHolder.setDetails(getApplicationContext(), chickenLegsModel.getTitle_4(), chickenLegsModel.getImage_4(),
                                chickenLegsModel.getTime_4(), chickenLegsModel.getServing_4(), chickenLegsModel.getIngredients_4(), chickenLegsModel.getInstructions_4());
                    }

                    //Added from here
                    @Override
                    public ChickenLegsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        ChickenLegsViewHolder chickenLegsViewHolder = super.onCreateViewHolder(parent, viewType);
                        chickenLegsViewHolder.setOnClickListener(new ChickenLegsViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_4);
                                TextView tTextView = view.findViewById(R.id.time_4);
                                TextView sTextView = view.findViewById(R.id.serving_4);
                                TextView ingTextView = view.findViewById(R.id.ingredients_4);
                                TextView insTextView = view.findViewById(R.id.instructions_4);
                                ImageView mImageView = view.findViewById(R.id.imageView_4);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), ChickenLegsRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_4", bytes);
                                intent.putExtra("title_4", mTitle);
                                intent.putExtra("time_4", mTime);
                                intent.putExtra("serving_4", mServing);
                                intent.putExtra("ingredients_4", mIngredients);
                                intent.putExtra("instructions_4", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return chickenLegsViewHolder;
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

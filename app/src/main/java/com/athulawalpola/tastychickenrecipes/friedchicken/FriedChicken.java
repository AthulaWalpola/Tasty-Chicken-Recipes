package com.athulawalpola.tastychickenrecipes.friedchicken;

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

public class FriedChicken extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fried_chicken);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_9);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Fried Chicken Recipes");
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
        FirebaseRecyclerAdapter<FriedChickenModel, FriedChickenViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<FriedChickenModel, FriedChickenViewHolder>(
                        FriedChickenModel.class,
                        R.layout.fried_chicken_items,
                        FriedChickenViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(FriedChickenViewHolder friedChickenViewHolder, FriedChickenModel friedChickenModel, int i) {
                friedChickenViewHolder.setDetails(getApplicationContext(), friedChickenModel.getTitle_9(), friedChickenModel.getImage_9(),
                        friedChickenModel.getTime_9(), friedChickenModel.getServing_9(), friedChickenModel.getIngredients_9(), friedChickenModel.getInstructions_9());
            }

            //Added from here
            @Override
            public FriedChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                FriedChickenViewHolder friedChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                friedChickenViewHolder.setOnClickListener(new FriedChickenViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_9);
                        TextView tTextView = view.findViewById(R.id.time_9);
                        TextView sTextView = view.findViewById(R.id.serving_9);
                        TextView ingTextView = view.findViewById(R.id.ingredients_9);
                        TextView insTextView = view.findViewById(R.id.instructions_9);
                        ImageView mImageView = view.findViewById(R.id.imageView_9);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), FriedChickenRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_9", bytes);
                        intent.putExtra("title_9", mTitle);
                        intent.putExtra("time_9", mTime);
                        intent.putExtra("serving_9", mServing);
                        intent.putExtra("ingredients_9", mIngredients);
                        intent.putExtra("instructions_9", mInstructions);
                        startActivity(intent);
                    }
                });

                return friedChickenViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_9").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<FriedChickenModel, FriedChickenViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<FriedChickenModel, FriedChickenViewHolder>(
                        FriedChickenModel.class,
                        R.layout.fried_chicken_items,
                                FriedChickenViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(FriedChickenViewHolder friedChickenViewHolder, FriedChickenModel friedChickenModel, int i) {
                        friedChickenViewHolder.setDetails(getApplicationContext(), friedChickenModel.getTitle_9(), friedChickenModel.getImage_9(),
                                friedChickenModel.getTime_9(), friedChickenModel.getServing_9(), friedChickenModel.getIngredients_9(), friedChickenModel.getInstructions_9());
                    }

                    //Added from here
                    @Override
                    public FriedChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        FriedChickenViewHolder friedChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                        friedChickenViewHolder.setOnClickListener(new FriedChickenViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_9);
                                TextView tTextView = view.findViewById(R.id.time_9);
                                TextView sTextView = view.findViewById(R.id.serving_9);
                                TextView ingTextView = view.findViewById(R.id.ingredients_9);
                                TextView insTextView = view.findViewById(R.id.instructions_9);
                                ImageView mImageView = view.findViewById(R.id.imageView_9);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), FriedChickenRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_9", bytes);
                                intent.putExtra("title_9", mTitle);
                                intent.putExtra("time_9", mTime);
                                intent.putExtra("serving_9", mServing);
                                intent.putExtra("ingredients_9", mIngredients);
                                intent.putExtra("instructions_9", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return friedChickenViewHolder;
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

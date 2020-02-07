package com.athulawalpola.tastychickenrecipes.wholechicken;

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

public class WholeChicken extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_chicken);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_11);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Set actionbar
        ActionBar actionBar = getSupportActionBar();
        //Set actionbar title
        actionBar.setTitle("Whole Chicken Recipes");
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
        FirebaseRecyclerAdapter<WholeChickenModel, WholeChickenViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<WholeChickenModel, WholeChickenViewHolder>(
                        WholeChickenModel.class,
                        R.layout.whole_chicken_items,
                        WholeChickenViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(WholeChickenViewHolder wholeChickenViewHolder, WholeChickenModel wholeChickenModel, int i) {
                wholeChickenViewHolder.setDetails(getApplicationContext(), wholeChickenModel.getTitle_11(), wholeChickenModel.getImage_11(),
                        wholeChickenModel.getTime_11(), wholeChickenModel.getServing_11(), wholeChickenModel.getIngredients_11(), wholeChickenModel.getInstructions_11());
            }

            //Added from here
            @Override
            public WholeChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                WholeChickenViewHolder wholeChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                wholeChickenViewHolder.setOnClickListener(new WholeChickenViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_11);
                        TextView tTextView = view.findViewById(R.id.time_11);
                        TextView sTextView = view.findViewById(R.id.serving_11);
                        TextView ingTextView = view.findViewById(R.id.ingredients_11);
                        TextView insTextView = view.findViewById(R.id.instructions_11);
                        ImageView mImageView = view.findViewById(R.id.imageView_11);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), WholeChickenRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_11", bytes);
                        intent.putExtra("title_11", mTitle);
                        intent.putExtra("time_11", mTime);
                        intent.putExtra("serving_11", mServing);
                        intent.putExtra("ingredients_11", mIngredients);
                        intent.putExtra("instructions_11", mInstructions);
                        startActivity(intent);
                    }
                });

                return wholeChickenViewHolder;
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

        Query firebaseSearchQuery = mReference.orderByChild("search_11").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<WholeChickenModel, WholeChickenViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<WholeChickenModel, WholeChickenViewHolder>(
                        WholeChickenModel.class,
                        R.layout.whole_chicken_items,
                        WholeChickenViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(WholeChickenViewHolder wholeChickenViewHolder, WholeChickenModel wholeChickenModel, int i) {
                        wholeChickenViewHolder.setDetails(getApplicationContext(), wholeChickenModel.getTitle_11(), wholeChickenModel.getImage_11(),
                                wholeChickenModel.getTime_11(), wholeChickenModel.getServing_11(), wholeChickenModel.getIngredients_11(), wholeChickenModel.getInstructions_11());
                    }

                    //Added from here
                    @Override
                    public WholeChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        WholeChickenViewHolder wholeChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                        wholeChickenViewHolder.setOnClickListener(new WholeChickenViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_11);
                                TextView tTextView = view.findViewById(R.id.time_11);
                                TextView sTextView = view.findViewById(R.id.serving_11);
                                TextView ingTextView = view.findViewById(R.id.ingredients_11);
                                TextView insTextView = view.findViewById(R.id.instructions_11);
                                ImageView mImageView = view.findViewById(R.id.imageView_11);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), WholeChickenRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_11", bytes);
                                intent.putExtra("title_11", mTitle);
                                intent.putExtra("time_11", mTime);
                                intent.putExtra("serving_11", mServing);
                                intent.putExtra("ingredients_11", mIngredients);
                                intent.putExtra("instructions_11", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return wholeChickenViewHolder;
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

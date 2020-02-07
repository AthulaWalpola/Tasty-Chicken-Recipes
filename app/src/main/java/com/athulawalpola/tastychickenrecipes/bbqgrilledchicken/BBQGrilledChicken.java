package com.athulawalpola.tastychickenrecipes.bbqgrilledchicken;

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

public class BBQGrilledChicken extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bbq_grilled_chicken);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_2);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Action bar
        ActionBar actionBar = getSupportActionBar();
        //Action bar title
        actionBar.setTitle("BBQ and Grilled Chicken");
        //set back button in actionbar
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
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

        FirebaseRecyclerAdapter<BBQGrilledChickenModel, BBQGrilledChickenViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<BBQGrilledChickenModel, BBQGrilledChickenViewHolder>(
                        BBQGrilledChickenModel.class,
                        R.layout.bbq_grilled_chicken_items,
                        BBQGrilledChickenViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(BBQGrilledChickenViewHolder bbqGrilledChickenViewHolder, BBQGrilledChickenModel bbqGrilledChickenModel, int i) {
                bbqGrilledChickenViewHolder.setDetails(getApplicationContext(), bbqGrilledChickenModel.getTitle_2(), bbqGrilledChickenModel.getImage_2(),
                        bbqGrilledChickenModel.getTime_2(), bbqGrilledChickenModel.getServing_2(), bbqGrilledChickenModel.getIngredients_2(), bbqGrilledChickenModel.getInstructions_2());
            }

            @Override
            public BBQGrilledChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                BBQGrilledChickenViewHolder bbqGrilledChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                bbqGrilledChickenViewHolder.setOnClickListener(new BBQGrilledChickenViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        TextView tvTextView = view.findViewById(R.id.title_2);
                        TextView tTextView = view.findViewById(R.id.time_2);
                        TextView sTextView = view.findViewById(R.id.serving_2);
                        TextView ingTextView = view.findViewById(R.id.ingredients_2);
                        TextView insTextView = view.findViewById(R.id.instructions_2);
                        ImageView mImageView = view.findViewById(R.id.imageView_2);

                        //Get data from views
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), BBQGrilledChickenRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_2", bytes);
                        intent.putExtra("title_2", mTitle);
                        intent.putExtra("time_2", mTime);
                        intent.putExtra("serving_2", mServing);
                        intent.putExtra("ingredients_2", mIngredients);
                        intent.putExtra("instructions_2", mInstructions);
                        startActivity(intent);
                    }
                });

                return bbqGrilledChickenViewHolder;
            }
        };

        //Set adapter to the recyclerView
        rRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    //Search Data
    private void firebaseSearch(String searchText) {

        //Convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mReference.orderByChild("search_2").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<BBQGrilledChickenModel, BBQGrilledChickenViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<BBQGrilledChickenModel, BBQGrilledChickenViewHolder>(
                        BBQGrilledChickenModel.class,
                        R.layout.bbq_grilled_chicken_items,
                        BBQGrilledChickenViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(BBQGrilledChickenViewHolder bbqGrilledChickenViewHolder, BBQGrilledChickenModel bbqGrilledChickenModel, int i) {
                        bbqGrilledChickenViewHolder.setDetails(getApplicationContext(), bbqGrilledChickenModel.getTitle_2(), bbqGrilledChickenModel.getImage_2(),
                                bbqGrilledChickenModel.getTime_2(), bbqGrilledChickenModel.getServing_2(), bbqGrilledChickenModel.getIngredients_2(), bbqGrilledChickenModel.getInstructions_2());
                    }

                    @Override
                    public BBQGrilledChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        BBQGrilledChickenViewHolder bbqGrilledChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                        bbqGrilledChickenViewHolder.setOnClickListener(new BBQGrilledChickenViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_2);
                                TextView tTextView = view.findViewById(R.id.time_2);
                                TextView sTextView = view.findViewById(R.id.serving_2);
                                TextView ingTextView = view.findViewById(R.id.ingredients_2);
                                TextView insTextView = view.findViewById(R.id.instructions_2);
                                ImageView mImageView = view.findViewById(R.id.imageView_2);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), BBQGrilledChickenRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_2", bytes);
                                intent.putExtra("title_2", mTitle);
                                intent.putExtra("time_2", mTime);
                                intent.putExtra("serving_2", mServing);
                                intent.putExtra("ingredients_2", mIngredients);
                                intent.putExtra("instructions_2", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return bbqGrilledChickenViewHolder;
                    }
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

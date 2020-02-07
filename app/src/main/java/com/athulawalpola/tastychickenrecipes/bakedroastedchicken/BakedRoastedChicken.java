package com.athulawalpola.tastychickenrecipes.bakedroastedchicken;

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

public class   BakedRoastedChicken extends AppCompatActivity {

    RecyclerView rRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baked_roasted_chicken);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(ViewHolder.ITEM_ID);

        rRecyclerView = findViewById(R.id.rvRecyclerView_1);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReference = mFirebaseDatabase.getReference(categoryName + "_class");

        //Action bar
        ActionBar actionBar = getSupportActionBar();
        //Actionbar Title
        actionBar.setTitle("Baked and Roasted Chicken");
        //Set back button in action bar
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

        FirebaseRecyclerAdapter<BakedRoastedChickenModel, BakedRoastedChickenViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<BakedRoastedChickenModel, BakedRoastedChickenViewHolder>(
                        BakedRoastedChickenModel.class,
                        R.layout.baked_roasted_chicken_items,
                        BakedRoastedChickenViewHolder.class,
                        mReference
        ) {
            @Override
            protected void populateViewHolder(BakedRoastedChickenViewHolder bakedRoastedChickenViewHolder, BakedRoastedChickenModel bakedRoastedChickenModel, int i) {
                bakedRoastedChickenViewHolder.setDetails(getApplicationContext(), bakedRoastedChickenModel.getTitle_1(), bakedRoastedChickenModel.getImage_1(),
                        bakedRoastedChickenModel.getTime_1(), bakedRoastedChickenModel.getServing_1(), bakedRoastedChickenModel.getIngredients_1(), bakedRoastedChickenModel.getInstructions_1());
            }

            //Added from here
            @Override
            public BakedRoastedChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                BakedRoastedChickenViewHolder bakedRoastedChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                bakedRoastedChickenViewHolder.setOnClickListener(new BakedRoastedChickenViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Views
                        ImageView mImageView = view.findViewById(R.id.imageView_1);
                        TextView tvTextView = view.findViewById(R.id.title_1);
                        TextView tTextView = view.findViewById(R.id.time_1);
                        TextView sTextView = view.findViewById(R.id.serving_1);
                        TextView ingTextView = view.findViewById(R.id.ingredients_1);
                        TextView insTextView = view.findViewById(R.id.instructions_1);

                        //Get data from views
                        Drawable mDrawable = mImageView.getDrawable();
                        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();
                        String mTitle = tvTextView.getText().toString();
                        String mTime = tTextView.getText().toString();
                        String mServing = sTextView.getText().toString();
                        String mIngredients = ingTextView.getText().toString();
                        String mInstructions = insTextView.getText().toString();

                        //Pass this data to new activity
                        Intent intent = new Intent(view.getContext(), BakedRoastedChickenRecipesOpen.class);
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                        byte[] bytes = stream.toByteArray();
                        intent.putExtra("image_1", bytes);
                        intent.putExtra("title_1", mTitle);
                        intent.putExtra("time_1", mTime);
                        intent.putExtra("serving_1", mServing);
                        intent.putExtra("ingredients_1", mIngredients);
                        intent.putExtra("instructions_1", mInstructions);
                        startActivity(intent);
                    }
                });

                return bakedRoastedChickenViewHolder;
            }
            //To here
        };

        //set adapter to the recyclerView
        rRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    //Search Data
    private void firebaseSearch(String searchText) {

        //Convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mReference.orderByChild("search_1").startAt(query).endAt(query + "\uf8ff");
        FirebaseRecyclerAdapter<BakedRoastedChickenModel, BakedRoastedChickenViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<BakedRoastedChickenModel, BakedRoastedChickenViewHolder>(
                        BakedRoastedChickenModel.class,
                        R.layout.baked_roasted_chicken_items,
                        BakedRoastedChickenViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(BakedRoastedChickenViewHolder bakedRoastedChickenViewHolder, BakedRoastedChickenModel bakedRoastedChickenModel, int i) {
                        bakedRoastedChickenViewHolder.setDetails(getApplicationContext(), bakedRoastedChickenModel.getTitle_1(), bakedRoastedChickenModel.getImage_1(),
                                bakedRoastedChickenModel.getTime_1(), bakedRoastedChickenModel.getServing_1(), bakedRoastedChickenModel.getIngredients_1(), bakedRoastedChickenModel.getInstructions_1());
                    }

                    //Added from here
                    @Override
                    public BakedRoastedChickenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                        BakedRoastedChickenViewHolder bakedRoastedChickenViewHolder = super.onCreateViewHolder(parent, viewType);
                        bakedRoastedChickenViewHolder.setOnClickListener(new BakedRoastedChickenViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Views
                                TextView tvTextView = view.findViewById(R.id.title_1);
                                TextView tTextView = view.findViewById(R.id.time_1);
                                TextView sTextView = view.findViewById(R.id.serving_1);
                                TextView ingTextView = view.findViewById(R.id.ingredients_1);
                                TextView insTextView = view.findViewById(R.id.instructions_1);
                                ImageView mImageView = view.findViewById(R.id.imageView_1);

                                //Get data from views
                                String mTitle = tvTextView.getText().toString();
                                String mTime = tTextView.getText().toString();
                                String mServing = sTextView.getText().toString();
                                String mIngredients = ingTextView.getText().toString();
                                String mInstructions = insTextView.getText().toString();
                                Drawable mDrawable = mImageView.getDrawable();
                                Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

                                //Pass this data to new activity
                                Intent intent = new Intent(view.getContext(), BakedRoastedChickenRecipesOpen.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte[] bytes = stream.toByteArray();
                                intent.putExtra("image_1", bytes);
                                intent.putExtra("title_1", mTitle);
                                intent.putExtra("time_1", mTime);
                                intent.putExtra("serving_1", mServing);
                                intent.putExtra("ingredients_1", mIngredients);
                                intent.putExtra("instructions_1", mInstructions);
                                startActivity(intent);
                            }
                        });

                        return bakedRoastedChickenViewHolder;
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

package com.athulawalpola.tastychickenrecipes.turkeyrecipes;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class TurkeyRecipesViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public TurkeyRecipesViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        //Item click listener
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });
    }

    public void setDetails(Context context, String title_10, String image_10, String time_10, String serving_10, String ingredients_10, String instructions_10) {
        TextView textView_1 = mView.findViewById(R.id.title_10);
        TextView textView_2 = mView.findViewById(R.id.time_10);
        TextView textView_3 = mView.findViewById(R.id.serving_10);
        TextView textView_4 = mView.findViewById(R.id.ingredients_10);
        TextView textView_5 = mView.findViewById(R.id.instructions_10);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_10);

        textView_1.setText(title_10);
        textView_2.setText(time_10);
        textView_3.setText(serving_10);
        textView_4.setText(ingredients_10);
        textView_5.setText(instructions_10);
        Picasso.get().load(image_10).fit().into(imageView_1);
    }

    private TurkeyRecipesViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(TurkeyRecipesViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

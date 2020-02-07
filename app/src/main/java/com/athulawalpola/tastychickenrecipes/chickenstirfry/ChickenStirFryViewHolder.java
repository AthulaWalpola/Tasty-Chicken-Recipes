package com.athulawalpola.tastychickenrecipes.chickenstirfry;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenStirFryViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ChickenStirFryViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_8, String image_8, String time_8, String serving_8, String ingredients_8, String instructions_8) {
        TextView textView_1 = mView.findViewById(R.id.title_8);
        TextView textView_2 = mView.findViewById(R.id.time_8);
        TextView textView_3 = mView.findViewById(R.id.serving_8);
        TextView textView_4 = mView.findViewById(R.id.ingredients_8);
        TextView textView_5 = mView.findViewById(R.id.instructions_8);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_8);

        textView_1.setText(title_8);
        textView_2.setText(time_8);
        textView_3.setText(serving_8);
        textView_4.setText(ingredients_8);
        textView_5.setText(instructions_8);
        Picasso.get().load(image_8).fit().into(imageView_1);
    }

    private ChickenStirFryViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenStirFryViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

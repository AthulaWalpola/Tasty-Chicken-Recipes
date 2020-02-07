package com.athulawalpola.tastychickenrecipes.bbqgrilledchicken;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class BBQGrilledChickenViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public BBQGrilledChickenViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        //Item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });

    }

    public void setDetails(Context context, String title_2, String image_2, String time_2, String serving_2, String ingredients_2, String instructions_2) {
        TextView textView_1 = mView.findViewById(R.id.title_2);
        TextView textView_2 = mView.findViewById(R.id.time_2);
        TextView textView_3 = mView.findViewById(R.id.serving_2);
        TextView textView_4 = mView.findViewById(R.id.ingredients_2);
        TextView textView_5 = mView.findViewById(R.id.instructions_2);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_2);

        textView_1.setText(title_2);
        textView_2.setText(time_2);
        textView_3.setText(serving_2);
        textView_4.setText(ingredients_2);
        textView_5.setText(instructions_2);
        Picasso.get().load(image_2).fit().into(imageView_1);
    }

    private BBQGrilledChickenViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(BBQGrilledChickenViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}
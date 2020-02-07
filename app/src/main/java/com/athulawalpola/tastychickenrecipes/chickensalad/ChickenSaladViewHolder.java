package com.athulawalpola.tastychickenrecipes.chickensalad;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenSaladViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ChickenSaladViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_5, String image_5, String time_5, String serving_5, String ingredients_5, String instructions_5) {
        TextView textView_1 = mView.findViewById(R.id.title_5);
        TextView textView_2 = mView.findViewById(R.id.time_5);
        TextView textView_3 = mView.findViewById(R.id.serving_5);
        TextView textView_4 = mView.findViewById(R.id.ingredients_5);
        TextView textView_5 = mView.findViewById(R.id.instructions_5);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_5);

        textView_1.setText(title_5);
        textView_2.setText(time_5);
        textView_3.setText(serving_5);
        textView_4.setText(ingredients_5);
        textView_5.setText(instructions_5);
        Picasso.get().load(image_5).fit().into(imageView_1);
    }

    private ChickenSaladViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenSaladViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

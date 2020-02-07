package com.athulawalpola.tastychickenrecipes.chickensoup;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenSoupViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ChickenSoupViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_6, String image_6, String time_6, String serving_6, String ingredients_6, String instructions_6) {
        TextView textView_1 = mView.findViewById(R.id.title_6);
        TextView textView_2 = mView.findViewById(R.id.time_6);
        TextView textView_3 = mView.findViewById(R.id.serving_6);
        TextView textView_4 = mView.findViewById(R.id.ingredients_6);
        TextView textView_5 = mView.findViewById(R.id.instructions_6);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_6);

        textView_1.setText(title_6);
        textView_2.setText(time_6);
        textView_3.setText(serving_6);
        textView_4.setText(ingredients_6);
        textView_5.setText(instructions_6);
        Picasso.get().load(image_6).fit().into(imageView_1);
    }

    private ChickenSoupViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenSoupViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

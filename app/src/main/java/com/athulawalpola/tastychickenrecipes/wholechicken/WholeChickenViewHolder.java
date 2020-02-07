package com.athulawalpola.tastychickenrecipes.wholechicken;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class WholeChickenViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public WholeChickenViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_11, String image_11, String time_11, String serving_11, String ingredients_11, String instructions_11) {
        TextView textView_1 = mView.findViewById(R.id.title_11);
        TextView textView_2 = mView.findViewById(R.id.time_11);
        TextView textView_3 = mView.findViewById(R.id.serving_11);
        TextView textView_4 = mView.findViewById(R.id.ingredients_11);
        TextView textView_5 = mView.findViewById(R.id.instructions_11);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_11);

        textView_1.setText(title_11);
        textView_2.setText(time_11);
        textView_3.setText(serving_11);
        textView_4.setText(ingredients_11);
        textView_5.setText(instructions_11);
        Picasso.get().load(image_11).fit().into(imageView_1);
    }

    private WholeChickenViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(WholeChickenViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

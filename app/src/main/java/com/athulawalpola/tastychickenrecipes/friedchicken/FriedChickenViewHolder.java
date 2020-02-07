package com.athulawalpola.tastychickenrecipes.friedchicken;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class FriedChickenViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public FriedChickenViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_9, String image_9, String time_9, String serving_9, String ingredients_9, String instructions_9) {
        TextView textView_1 = mView.findViewById(R.id.title_9);
        TextView textView_2 = mView.findViewById(R.id.time_9);
        TextView textView_3 = mView.findViewById(R.id.serving_9);
        TextView textView_4 = mView.findViewById(R.id.ingredients_9);
        TextView textView_5 = mView.findViewById(R.id.instructions_9);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_9);

        textView_1.setText(title_9);
        textView_2.setText(time_9);
        textView_3.setText(serving_9);
        textView_4.setText(ingredients_9);
        textView_5.setText(instructions_9);
        Picasso.get().load(image_9).fit().into(imageView_1);
    }

    private FriedChickenViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(FriedChickenViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

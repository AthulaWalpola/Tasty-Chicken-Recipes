package com.athulawalpola.tastychickenrecipes.chickenbreasts;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenBreastsViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ChickenBreastsViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_3, String image_3, String time_3, String serving_3, String ingredients_3, String instructions_3) {
        TextView textView_1 = mView.findViewById(R.id.title_3);
        TextView textView_2 = mView.findViewById(R.id.time_3);
        TextView textView_3 = mView.findViewById(R.id.serving_3);
        TextView textView_4 = mView.findViewById(R.id.ingredients_3);
        TextView textView_5 = mView.findViewById(R.id.instructions_3);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_3);

        textView_1.setText(title_3);
        textView_2.setText(time_3);
        textView_3.setText(serving_3);
        textView_4.setText(ingredients_3);
        textView_5.setText(instructions_3);
        Picasso.get().load(image_3).fit().into(imageView_1);
    }

    private ChickenBreastsViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenBreastsViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

package com.athulawalpola.tastychickenrecipes.bakedroastedchicken;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class BakedRoastedChickenViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public BakedRoastedChickenViewHolder(@NonNull View itemView) {
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

    public void setDetails(final Context context, String title_1, String image_1, String time_1, String serving_1, String ingredients_1, String instructions_1) {
        TextView textView_1 = mView.findViewById(R.id.title_1);
        TextView textView_2 = mView.findViewById(R.id.time_1);
        TextView textView_3 = mView.findViewById(R.id.serving_1);
        TextView textView_4 = mView.findViewById(R.id.ingredients_1);
        TextView textView_5 = mView.findViewById(R.id.instructions_1);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_1);

        textView_1.setText(title_1);
        textView_2.setText(time_1);
        textView_3.setText(serving_1);
        textView_4.setText(ingredients_1);
        textView_5.setText(instructions_1);
        Picasso.get().load(image_1).fit().into(imageView_1);
    }

    private BakedRoastedChickenViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(BakedRoastedChickenViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }

}

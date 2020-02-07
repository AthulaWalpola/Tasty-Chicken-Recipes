package com.athulawalpola.tastychickenrecipes.chickenstew;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenStewViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ChickenStewViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_7, String image_7, String time_7, String serving_7, String ingredients_7, String instructions_7) {
        TextView textView_1 = mView.findViewById(R.id.title_7);
        TextView textView_2 = mView.findViewById(R.id.time_7);
        TextView textView_3 = mView.findViewById(R.id.serving_7);
        TextView textView_4 = mView.findViewById(R.id.ingredients_7);
        TextView textView_5 = mView.findViewById(R.id.instructions_7);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_7);

        textView_1.setText(title_7);
        textView_2.setText(time_7);
        textView_3.setText(serving_7);
        textView_4.setText(ingredients_7);
        textView_5.setText(instructions_7);
        Picasso.get().load(image_7).fit().into(imageView_1);
    }

    private ChickenStewViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenStewViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

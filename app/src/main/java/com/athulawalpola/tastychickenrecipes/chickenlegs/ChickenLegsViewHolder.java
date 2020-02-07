package com.athulawalpola.tastychickenrecipes.chickenlegs;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.athulawalpola.tastychickenrecipes.R;
import com.squareup.picasso.Picasso;

public class ChickenLegsViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ChickenLegsViewHolder(@NonNull View itemView) {
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

    public void setDetails(Context context, String title_4, String image_4, String time_4, String serving_4, String ingredients_4, String instructions_4) {
        TextView textView_1 = mView.findViewById(R.id.title_4);
        TextView textView_2 = mView.findViewById(R.id.time_4);
        TextView textView_3 = mView.findViewById(R.id.serving_4);
        TextView textView_4 = mView.findViewById(R.id.ingredients_4);
        TextView textView_5 = mView.findViewById(R.id.instructions_4);
        ImageView imageView_1 = mView.findViewById(R.id.imageView_4);

        textView_1.setText(title_4);
        textView_2.setText(time_4);
        textView_3.setText(serving_4);
        textView_4.setText(ingredients_4);
        textView_5.setText(instructions_4);
        Picasso.get().load(image_4).fit().into(imageView_1);
    }

    private ChickenLegsViewHolder.ClickListener mClickListener;

    //Interface to send callbacks
    public interface ClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ChickenLegsViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}

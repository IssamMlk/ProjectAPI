package com.vogella.android.projectapi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        final ListItem listItem = listItems.get(position);
        holder.textViewName.setText(listItem.getName());
        holder.textViewNum.setText(listItem.getNum());

        Picasso.get().load(listItem.getImageUrl()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked "+listItem.getName(), Toast.LENGTH_LONG).show();

                Bundle bundle = new Bundle();
                bundle.putString("NAME", listItem.getName());
                bundle.putString("NUM", listItem.getNum());


                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("Heading", listItem.getName());
                i.putExtra("Description1", listItem.getNum());
                context.startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
       public TextView textViewNum;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewNum=(TextView) itemView.findViewById(R.id.textViewNum);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}

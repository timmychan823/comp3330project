package com.example.ricelegfinder;


import android.util.Log;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    Context context;
    ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_message_recycler_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {

        if (items.get(position).getType()=="Sent"){
            holder.leftChatLayout.setVisibility(View.GONE);
            holder.rightChatLayout.setVisibility(View.VISIBLE);
            holder.rightMessageView.setText(items.get(position).getMessage());

            Log.d("MyAdapter", "Sent Message");

        }else{
            holder.rightChatLayout.setVisibility(View.GONE);
            holder.leftChatLayout.setVisibility(View.VISIBLE);
            holder.leftMessageView.setText(items.get(position).getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
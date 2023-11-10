package com.example.ricelegfinder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView leftMessageView,rightMessageView;
    ConstraintLayout leftChatLayout, rightChatLayout;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        leftMessageView = itemView.findViewById(R.id.left_chat_textview);
        rightMessageView = itemView.findViewById(R.id.right_chat_textview);
        leftChatLayout = itemView.findViewById(R.id.left_chat_layout);
        rightChatLayout = itemView.findViewById(R.id.right_chat_layout);
    }
}
package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_books.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private List<User> mlistUser;

    public void setData(List<User> list){
        this.mlistUser = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mlistUser.get(position);
        if(user==null){
            return;
        }
        holder.imgAvatar.setImageResource(user.getResourceID());
        holder.textName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(mlistUser!=null){
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
            private ImageView imgAvatar;
            private TextView textName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_user);
            textName = itemView.findViewById(R.id.tv_name);
        }
    }

}


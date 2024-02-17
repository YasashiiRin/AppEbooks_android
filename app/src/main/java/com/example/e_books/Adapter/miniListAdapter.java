package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_books.Interface.Icclickitemminitruyen;
import com.example.e_books.Interface.IclickItemtruyen;
import com.example.e_books.Model.Truyen;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class miniListAdapter extends RecyclerView.Adapter<miniListAdapter.miniListHolder> {
    private List<Truyen> mnlisttruyen;
    private Context context;
    private Icclickitemminitruyen icclickitemminitruyen;

    public miniListAdapter(List<Truyen> mnlisttruyen, Context context,Icclickitemminitruyen listenmini) {
        this.mnlisttruyen = mnlisttruyen;
        this.context = context;
        this.icclickitemminitruyen=listenmini;
    }

    @NonNull
    @Override
    public miniListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_list,parent,false);
        return new miniListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull miniListHolder holder, int position) {
        Truyen truyen=mnlisttruyen.get(position);
        if (truyen==null){
            return;
        } Picasso.get().load(truyen.getTimg()).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(holder.miniimg);
        holder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icclickitemminitruyen.onclickitemminitruyen(truyen);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mnlisttruyen!=null){
            return mnlisttruyen.size();
        }
        return 0;
    }

    public class miniListHolder extends RecyclerView.ViewHolder{
         private ImageView miniimg;
        private LinearLayout layoutitem;
        public miniListHolder(@NonNull View itemView) {
            super(itemView);
            layoutitem=itemView.findViewById(R.id.minilayout);
            miniimg=itemView.findViewById(R.id.imgmini);

        }
    }
}

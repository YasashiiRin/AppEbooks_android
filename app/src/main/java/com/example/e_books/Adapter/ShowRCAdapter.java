package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_books.Interface.IclickItemtruyen;
import com.example.e_books.Model.Truyen;
import com.example.e_books.NoidungActivity;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShowRCAdapter extends RecyclerView.Adapter<ShowRCAdapter.ShowRcHolder>{
    private List<Truyen> mlisttruyen;
    private Context context;
    private IclickItemtruyen iclickItemtruyen;

    public ShowRCAdapter(List<Truyen> mlisttruyen, Context context,IclickItemtruyen listener) {
        this.mlisttruyen = mlisttruyen;
        this.context = context;
        this.iclickItemtruyen=listener;

    }

    public ShowRCAdapter(List<Truyen> mlisttruyen) {
        this.mlisttruyen = mlisttruyen;
    }

    public void setData(List<Truyen> list){
        this.mlisttruyen=mlisttruyen;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ShowRcHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listtruyen,parent,false);
        return new ShowRcHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowRcHolder holder, int position) {
              Truyen truyen=mlisttruyen.get(position);
              if (truyen==null){
                  return;
        } Picasso.get().load(truyen.getTimg()).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(holder.imgtruyen);
              holder.tvname.setText(truyen.getTtentruyen());
              holder.layoutitemmini.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      iclickItemtruyen.onlickitemtruyen(truyen);
                  }
              });
    }


    @Override
    public int getItemCount() {
        if(mlisttruyen!=null){
            return mlisttruyen.size();
        }
        return 0;
    }

    public class ShowRcHolder extends RecyclerView.ViewHolder{
        private LinearLayout layoutitemmini;
        private TextView tvname;
        private ImageView imgtruyen;
        public ShowRcHolder(@NonNull View itemView) {
            super(itemView);
            layoutitemmini=itemView.findViewById(R.id.listtruyenid);
            tvname=itemView.findViewById(R.id.tvtruyenL1);
            imgtruyen=itemView.findViewById(R.id.imgtruyenL1);
        }
    }
}

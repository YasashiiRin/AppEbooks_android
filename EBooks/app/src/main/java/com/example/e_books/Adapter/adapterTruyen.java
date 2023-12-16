package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.e_books.Model.Truyen;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterTruyen extends BaseAdapter {

    private Context context;
    private ArrayList<Truyen> listTruyen;

    public adapterTruyen(Context context, ArrayList<Truyen> listtruyen) {
        this.context = context;
        this.listTruyen = listtruyen;
    }

    @Override
    public int getCount() {

        return listTruyen.size();
    }

    @Override
    public Object getItem(int i) {
        return listTruyen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Viewholder{
            TextView txttentruyen;
            ImageView imgtruyen;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
          Viewholder viewholder=null;
          viewholder=new Viewholder();
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.newtruyen,null);
        viewholder.txttentruyen=view.findViewById(R.id.tvnametruyen);
        viewholder.imgtruyen=view.findViewById(R.id.imgnewtruyen);
        view.setTag(viewholder);

        Truyen truyen=(Truyen) getItem(i);
        

        viewholder.txttentruyen.setText(truyen.getTtentruyen());
        Picasso.get().load(truyen.getTimg()).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(viewholder.imgtruyen);
        return view;
    }
    public void filterList(ArrayList<Truyen> filteredList){
        listTruyen = filteredList;
        notifyDataSetChanged();
    }
}

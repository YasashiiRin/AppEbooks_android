package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_books.Model.Truyen;
import com.example.e_books.Model.TruyenYT;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterTruyenyt extends BaseAdapter
{
    private Context context;
    private ArrayList<TruyenYT> listTruyen;

    public AdapterTruyenyt(Context context, ArrayList<TruyenYT> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
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
        view=inflater.inflate(R.layout.listtruyenyt,null);
        viewholder.txttentruyen=view.findViewById(R.id.tvnametruyenyt);
        viewholder.imgtruyen=view.findViewById(R.id.imgtruyenyt);
        view.setTag(viewholder);

        TruyenYT truyenYT =(TruyenYT) getItem(i);


        viewholder.txttentruyen.setText(truyenYT.getYtentruyen());
        Picasso.get().load(truyenYT.getYimg()).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(viewholder.imgtruyen);
        return view;
    }
}

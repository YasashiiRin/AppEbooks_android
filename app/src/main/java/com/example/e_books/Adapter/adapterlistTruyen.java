package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.e_books.Model.Truyen;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterlistTruyen  extends BaseAdapter {

    private Context context;
    private ArrayList<Truyen> listTruyenL1;

    public adapterlistTruyen(Context context, ArrayList<Truyen> listTruyen) {
        this.context = context;
        this.listTruyenL1 = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyenL1.size();
    }

    @Override
    public Object getItem(int i) {
        return listTruyenL1.get(i);
    }
  public class Viewholder{
        ImageView img;
  }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder viewholder=null;
        viewholder=new Viewholder();
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.newtruyen,null);
        viewholder.img=view.findViewById(R.id.imgtruyenL1);
        view.setTag(viewholder);
        Truyen truyen=(Truyen) getItem(i);
        Picasso.get().load(truyen.getTimg()).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(viewholder.img);

        return view;
    }
}

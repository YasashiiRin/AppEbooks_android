package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_books.Model.Itemprofile;
import com.example.e_books.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterItem extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Itemprofile> itemprofileList;

    public adapterItem(Context context, int layout, List<Itemprofile> itemprofileList) {
        this.context = context;
        this.layout = layout;
        this.itemprofileList = itemprofileList;
    }

    @Override
    public int getCount() {
        return itemprofileList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        ImageView img=(ImageView) view.findViewById(R.id.imgitem);
        TextView txt=(TextView) view.findViewById(R.id.tvnameitem);
        Itemprofile itemprofile=itemprofileList.get(i);
        txt.setText(itemprofile.getNameitem());

        return view;
    }
}

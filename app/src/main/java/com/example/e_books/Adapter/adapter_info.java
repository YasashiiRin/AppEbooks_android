package com.example.e_books.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_books.Model.Taikhoan;
import com.example.e_books.R;

import java.util.List;

public class adapter_info extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Taikhoan> taikhoanList;

    public adapter_info(Context context, int layout, List<Taikhoan> taikhoanList) {
        this.context = context;
        this.layout = layout;
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int getCount() {
        return taikhoanList.size();
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
        TextView txttentaikhoan=(TextView) view.findViewById(R.id.tvten);
        TextView txtEmail=(TextView)  view.findViewById(R.id.tvgmail);
        TextView txtid=(TextView) view.findViewById(R.id.tvid);
        Taikhoan taikhoan=taikhoanList.get(i);
        txttentaikhoan.setText(taikhoan.getmTenTaiKhoan());
        txtEmail.setText(taikhoan.getmEmail());
        txtid.setText(String.valueOf(taikhoan.getmId()));

        return view;
    }
}

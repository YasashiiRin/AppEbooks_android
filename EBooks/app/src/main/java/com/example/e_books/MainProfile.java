package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Taikhoan;
import com.example.e_books.Model.Truyen;

import java.util.ArrayList;
import com.example.e_books.Adapter.adapterTruyen;
import com.example.e_books.Adapter.adapter_info;
import com.example.e_books.Adapter.adapterItem;
public class MainProfile extends AppCompatActivity {
    ListView listView,listViewNew,listviewThongtin;
    ArrayList<Taikhoan> taiKhoanArrayList;

DatabaseEBooks databaseEBooks;
   adapter_info adapter_info;
    String email;
    String tentaikhoan;
    int idd;
    String idtk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
       databaseEBooks= new DatabaseEBooks(this);
        Intent intentpq = getIntent();
        int i = intentpq.getIntExtra("phanq",0);
        idd = intentpq.getIntExtra("Id",0);
        email = intentpq.getStringExtra("email");
        tentaikhoan = intentpq.getStringExtra("ttkname");
        Anhxa();
    }

    private void Anhxa() {
        listviewThongtin=findViewById(R.id.listprofile);
        taiKhoanArrayList = new ArrayList<>();
        taiKhoanArrayList.add(new Taikhoan(idd,tentaikhoan,email));
        adapter_info = new adapter_info(this,R.layout.nv_profile,taiKhoanArrayList);
        listviewThongtin.setAdapter(adapter_info);
    }

}
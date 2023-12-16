package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.e_books.Adapter.adapterTruyen;
import com.example.e_books.Adapter.AdapterTruyenyt;
import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;
import com.example.e_books.Model.TruyenYT;

import java.util.ArrayList;

public class MainYeuthich extends AppCompatActivity {
    Integer idtaikhoan;
    ListView listViewyt;
    ArrayList<TruyenYT> ytArrayList;
    AdapterTruyenyt adapterTruyenyt;
    ArrayList<TruyenYT> ytarrayList;
    DatabaseEBooks databaseEBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_yeuthich);
        Intent intentpq=getIntent();
        idtaikhoan=intentpq.getIntExtra("ID",0);
        listViewyt = findViewById(R.id.listviewyt);
        initList();
        listViewyt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainYeuthich.this,Noidunglistview.class);
                String tent =   ytarrayList.get(position).getYtentruyen();
                String noidungt = ytarrayList.get(position).getYnoidung();
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);
                intent.putExtra("ID",idtaikhoan);
                startActivity(intent);
            }
        });
    }
    public void initList() {
        ytArrayList = new ArrayList<>();
        //
        ytarrayList = new ArrayList<>();
        databaseEBooks = new DatabaseEBooks(this);
        Cursor cursor1 = databaseEBooks.getyt(idtaikhoan);
        while (cursor1.moveToNext()) {

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            ytArrayList.add(new TruyenYT(id, tentruyen, noidung, anh, id_tk));

            //Thêm dữ liệu vào mảng
            ytarrayList.add(new TruyenYT(id, tentruyen, noidung, anh, id_tk));

            adapterTruyenyt= new AdapterTruyenyt(getApplicationContext(), ytArrayList);
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,TruyenArrayList);
            listViewyt.setAdapter(adapterTruyenyt);
        }
        cursor1.moveToFirst();
        cursor1.close();


    }
}
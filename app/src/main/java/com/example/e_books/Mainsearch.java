package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.example.e_books.Adapter.adapterTruyen;
import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;
import java.util.ArrayList;
import java.util.List;

public class Mainsearch extends AppCompatActivity {
    ListView listViewall;
    EditText edt;

    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;
    ArrayList<Truyen> arrayList;
    DatabaseEBooks databaseEBooks;
    int idtaikhoan;
    String tentaikhoan;
    private Menu menu;
    private boolean isExplainded = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainsearch);
        Intent intentpq=getIntent();
        idtaikhoan=intentpq.getIntExtra("ID",0);
        tentaikhoan=intentpq.getStringExtra("ttkname");
        listViewall = findViewById(R.id.listviewall);
        //toolbar = findViewById(R.id.toolbartimkiem);
        edt = findViewById(R.id.timkiem);
        initList();

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }

        });
        listViewall.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Mainsearch.this,Noidunglistview.class);
                String tent =   arrayList.get(position).getTtentruyen();
                String noidungt = arrayList.get(position).getTnoidung();
                intent.putExtra("tentruyen",tent);
                intent.putExtra("noidung",noidungt);
                intent.putExtra("ID",idtaikhoan);
                //Log.e("Tên truyện : ",tent);
                startActivity(intent);
            }
        });
    }

    private void filter(String text){
        //xóa sau mỗi lần gọi tới filter
        arrayList.clear();

        ArrayList<Truyen> filteredList = new ArrayList<>();

        for(Truyen item : TruyenArrayList){
            if (item.getTtentruyen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);

                //Thêm dữ liệu để hiển thị ra item nội dung
                arrayList.add(item);
            }
        }
        adapterTruyen.filterList(filteredList);
    }
    //Hàm  gán dữ liệu từ CSDL vào listview
    public void initList() {
        TruyenArrayList = new ArrayList<>();
        //
        arrayList = new ArrayList<>();
        databaseEBooks = new DatabaseEBooks(this);

        Cursor cursor1 = databaseEBooks.getDataALL();
        while (cursor1.moveToNext()) {

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArrayList.add(new Truyen(id, tentruyen, noidung, anh, id_tk));

            //Thêm dữ liệu vào mảng
            arrayList.add(new Truyen(id, tentruyen, noidung, anh, id_tk));

            adapterTruyen = new adapterTruyen(getApplicationContext(), TruyenArrayList);
            //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,TruyenArrayList);
            listViewall.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();


    }
    }

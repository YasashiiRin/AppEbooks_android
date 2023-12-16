package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;

//adapter
import com.example.e_books.Adapter.adapterTruyen;

import java.util.ArrayList;

public class Admin_Activity extends AppCompatActivity {
    ListView listView;
    Button buttonThem;

    ArrayList<Truyen> TruyenArrayList;
    adapterTruyen adapterTruyen;
    DatabaseEBooks databaseEBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);

        listView = findViewById(R.id.listviewAdmin);
        buttonThem = findViewById(R.id.buttonAddTruyen);

        initList();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DialogDelete(position);
                return false;
            }


        });


        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                int id = intent.getIntExtra("Id",0);
                Intent intent1 = new Intent(Admin_Activity.this,MainQuanly.class);
                intent.putExtra("Id",id);
                startActivity(intent1);
            }
        });
    }
    //Dialog Delete
    private void DialogDelete(int position) {

        //Tạo đối tượng cửa sổ dialog
        Dialog dialog  =  new Dialog(this);

        //Nạp layout vào
        dialog.setContentView(R.layout.dialogdelete);
        //Click No mới thoát, click ngoài ko thoát
        dialog.setCanceledOnTouchOutside(false);

        //Ánh xạ
        Button btnYes = dialog.findViewById(R.id.buttonYes);
        Button btnNo = dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idtruyen = TruyenArrayList.get(position).getTid();
                //Xóa trong SQL
                databaseEBooks.Delete(idtruyen);
                //Cập nhật lại listview
                Intent intent = new Intent(Admin_Activity.this,Admin_Activity.class);
                finish();
                startActivity(intent);
                Toast.makeText(Admin_Activity.this,"Xóa truyện thành công",Toast.LENGTH_SHORT).show();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }


    //Gán DL vào listview
    public void initList(){
        TruyenArrayList = new ArrayList<>();
        databaseEBooks = new DatabaseEBooks(this);

        Cursor cursor1 = databaseEBooks.getDataALL();

        while (cursor1.moveToNext()){

            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);
            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));

           adapterTruyen = new adapterTruyen(getApplicationContext(),TruyenArrayList);
            listView.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();
    }
}
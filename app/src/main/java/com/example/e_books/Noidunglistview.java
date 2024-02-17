package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;
import com.example.e_books.Adapter.adapterTruyen;
import com.example.e_books.Model.TruyenYT;

import java.util.ArrayList;

public class Noidunglistview extends AppCompatActivity {
    TextView txtTenTruyen,txtNoidung;
    String tt;
    String nd;
    String anh;
    int idt;
    int idtaikhoan;
    Button btyeuthich;
    DatabaseEBooks databaseEBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidunglistview);
        databaseEBooks= new DatabaseEBooks(this);
        txtNoidung = findViewById(R.id.NoiDung);
        btyeuthich=findViewById(R.id.bthemyt);
        txtTenTruyen = findViewById(R.id.TenTruyen);
        Intent intenttruyen = getIntent();
        tt = intenttruyen.getStringExtra("tentruyen");
        nd = intenttruyen.getStringExtra("noidung");
        anh=intenttruyen.getStringExtra("img");

        txtTenTruyen.setText(tt);
        txtNoidung.setText(nd);

        //Cuộn textview
        txtNoidung.setMovementMethod(new ScrollingMovementMethod());
//        btyeuthich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Truyen truyen=setid();
////                databaseDocTruyen.update(truyen);
////                Intent intent1 = new Intent(Noidunglistview.this,MainYeuthich.class);
//                finish();
//                startActivity(intent1);
//                Toast.makeText(ManNoiDungTruyen.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
//            }
//        });

        btyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TruyenYT truyenyt = CreatTruyenyt();
                    databaseEBooks.AddYeuthich(truyenyt);
                    Intent intent = new Intent(Noidunglistview.this,MainYeuthich.class);
                    intent.putExtra("ID",idtaikhoan);
                    finish();
                    startActivity(intent);
                    Toast.makeText(Noidunglistview.this,"Thêm truyện thành công",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private TruyenYT CreatTruyenyt(){
        Intent intent = getIntent();
        idtaikhoan=intent.getIntExtra("ID",0);
        TruyenYT truyenyt = new TruyenYT(tt,nd,anh,idtaikhoan);
        return truyenyt;
    }
}
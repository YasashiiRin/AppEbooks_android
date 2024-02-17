package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;

public class MainQuanly extends AppCompatActivity {
    EditText edtTieuDe,edtNoiDung,edtAnh;
    Button btnThem;
    DatabaseEBooks databaseEBooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quanly);

        edtTieuDe = findViewById(R.id.dbtieude);
        edtNoiDung = findViewById(R.id.dbnoidung);
        btnThem = findViewById(R.id.dbdangbai);
        edtAnh = findViewById(R.id.dbimg);

        databaseEBooks= new DatabaseEBooks(this);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tentruyen = edtTieuDe.getText().toString();
                String noidung = edtNoiDung.getText().toString();
                String img = edtAnh.getText().toString();

                Truyen truyen = CreatTruyen();

                if(tentruyen.equals("") || noidung.equals("") || img.equals("")){
                    Toast.makeText(MainQuanly.this,"Yêu cầu nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseEBooks.AddTruyen(truyen);
                    Intent intent = new Intent(MainQuanly.this,Admin_Activity.class);
                    finish();
                    startActivity(intent);
                    Toast.makeText(MainQuanly.this,"Thêm truyện thành công",Toast.LENGTH_SHORT).show();
                    //Log.e("Thêm truyện : ","Thành công");
                }
            }
        });
    }
    private Truyen CreatTruyen(){
        String tentruyen = edtTieuDe.getText().toString();
        String noidung = edtNoiDung.getText().toString();
        String img = edtAnh.getText().toString();

        Intent intent = getIntent();
        int id = intent.getIntExtra("Id",0);

        Truyen truyen = new Truyen(tentruyen,noidung,img,id);
        return truyen;
    }
}
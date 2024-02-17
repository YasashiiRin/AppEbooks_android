package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;

public class DangNhapActivity extends AppCompatActivity {

   EditText gettaikhoan;
   EditText getmatkhau;
   Button getdangnhap;
   Button getbtdangky;
   TextView gettv;


   DatabaseEBooks databaseebooks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        Anhxa();
        databaseebooks=new DatabaseEBooks(this);
        getbtdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
        getdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String tentaikhoan=gettaikhoan.getText().toString();
                 String matkhau=getmatkhau.getText().toString();
                 Cursor cursor=databaseebooks.getData();
                 while(cursor.moveToNext()){
                     String datataikhoan=cursor.getString(1);
                     String datamatkhau=cursor.getString(2);
                     int pq=cursor.getInt(4);
                     if(datataikhoan.equals(tentaikhoan) && datamatkhau.equals(matkhau)){
                         int phanquyen=cursor.getInt(4);
                         int idd=cursor.getInt(0);
                         String email=cursor.getString(3);
                         String tentk=cursor.getString(1);
                         Intent intent =new Intent(DangNhapActivity.this,MainActivity.class);
                         intent.putExtra("phanq",phanquyen);
                         intent.putExtra("ID",idd);
                         intent.putExtra("email",email);
                         intent.putExtra("tentaikhoan",tentk);
                         startActivity(intent);
                     }
                     else{
                         Toast.makeText(DangNhapActivity.this,"tài khoản or mật khẩu không đúng ",Toast.LENGTH_SHORT).show();
                     }
//
                 }
               cursor.moveToFirst();
                 cursor.close();
            }
        });

    }
    public void nextdk(View v){

    }

    private void Anhxa() {
        gettaikhoan=findViewById(R.id.edtname1);
        getmatkhau=findViewById(R.id.edtpass1);
        getdangnhap=findViewById(R.id.btndn1);
        getbtdangky=findViewById(R.id.btregister);
//
//        getdangnhap=findViewById();
    }
}
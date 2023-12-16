package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Taikhoan;

public class DangKyActivity extends AppCompatActivity {
    EditText edtname,edtpass,edtemail;
    Button btdangky,btdangnhap;
    DatabaseEBooks databaseEBooks;
    Context context;
    ImageView btout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        databaseEBooks=new DatabaseEBooks(this);
        edtname=findViewById(R.id.edtname1);
        edtpass=findViewById(R.id.edtpass1);
        edtemail=findViewById(R.id.edtgmail);
        btdangky=findViewById(R.id.btdangky);
        btout=findViewById(R.id.imgout);
        btdangnhap=findViewById(R.id.btndn);
        context=this;
        databaseEBooks=new DatabaseEBooks(context);
        btdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan=edtname.getText().toString();
                String matkhau=edtpass.getText().toString();
                String email=edtemail.getText().toString();
                Taikhoan taikhoan1=createtaikhoan();
                Cursor cursor=databaseEBooks.getData();
                while(cursor.moveToNext()){
                    String datataikhoan=cursor.getString(1);
                    if(datataikhoan.equals(taikhoan)){
                        Toast.makeText(context," Tài khoản này đã tồn tại  ",Toast.LENGTH_LONG).show();
                        edtname.setText(null);
                        edtpass.setText(null);
                        edtemail.setText(null);
                    }
                    else{
                        databaseEBooks.AddTk(taikhoan1);
                        Toast.makeText(context,"Đăng ký thành công ",Toast.LENGTH_LONG).show();

                    }
                }
                cursor.moveToFirst();
                cursor.close();

                if(taikhoan.equals("")|| matkhau.equals("")|| email.equals("")){
                    Toast.makeText(context,"vui lòng nhập đầy đủ thông tin ",Toast.LENGTH_LONG).show();
                }

            }
        });

        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
    }
    private Taikhoan createtaikhoan(){
        String taikhoan=edtname.getText().toString();
        String matkhau=edtpass.getText().toString();
        String email=edtemail.getText().toString();
        int phanquyen=1;
        Taikhoan tk=new Taikhoan(taikhoan,matkhau,email,phanquyen);
        return  tk;
    }
    public void imgout(View v){
        Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
        startActivity(intent);
    }
}